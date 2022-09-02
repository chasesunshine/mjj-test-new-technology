package org.wanbang.study.anno;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义spring容器框架 注解方式实现
 * Created by yz on 2018/6/3.
 */
public class ExtClassPathXmlApplicationContext {

    // 定义springbean容器
    private ConcurrentHashMap<String,Object> beans;

    // 扫包的范围
    private String packageName;

    public ExtClassPathXmlApplicationContext(String xmlPath) throws Exception {
        // 初始化参数
        beans = new ConcurrentHashMap<>();
        this.packageName = getPackageName(xmlPath);
        initBeans();
        initEntryField();
    }

    // 初始化属性
    private void initEntryField() throws Exception {
        // 1.遍历所有bena容器对象
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            // 2.判断属性上面是否有加注解
            Object object = entry.getValue();
            inversionOfControl(object);
        }
    }

    public Object getBean(String beanId) throws Exception {
        System.out.println(beanId);
        if(StringUtils.isEmpty(beanId)){
            throw new Exception("beanId参数不能为空");
        }
        // 从spring容器获取bean
        Object object = beans.get(beanId);
        return object;
    }

    // 根据路径通过反射机制获取对象
    public Object newInstance(Class<?> classInfo) throws Exception {
        return classInfo.getDeclaredConstructor().newInstance();
    }

    // 初始化对象
    public void initBeans() throws Exception {
        // 1.使用Java的反射机制扫包，获取当前包下所有的类
        List<Class<?>> classes = ClassUtil.getClasses(packageName);
        // 2.判断类上是否存在注入bean的注解
        ConcurrentHashMap<String, Object> classIsAnnotation = findClassIsAnnotation(classes);
        if(classIsAnnotation == null || classIsAnnotation.isEmpty()){
            throw new Exception("该包下没有任何类加上注解");
        }
    }

    // 判断类上是否存在注入bean的注解
    public ConcurrentHashMap<String,Object> findClassIsAnnotation(List<Class<?>> classes) throws Exception {
        for (Class<?> classInfo : classes) {
            // 判断类上是否有注解
            ExtService annotation = classInfo.getAnnotation(ExtService.class);
            if(annotation !=null){
                // 获取当前类名，beanid 默认类名小写
                String className = classInfo.getSimpleName();
                String beanId = toLowerCaseFirstOne(className);
                // 通过反射机制创建对象
                Object newInstance = newInstance(classInfo);
                beans.put(beanId,newInstance);
                continue;
            }
        }
        return beans;
    }

    //首字母转小写
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder())
                    .append(Character.toLowerCase(s.charAt(0)))
                    .append(s.substring(1)).toString();
    }

    // 读取xml中配置的包路径
    public String getPackageName(String xmlPath) throws Exception {
        SAXReader saxReader = new SAXReader();
        // 读取xml文件
        Document document = saxReader.read(getResourcesAsStream(xmlPath));
        // 读取节点
        Element rootElement = document.getRootElement();
        // 获取根节点下所有的子节点
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            if(element.getName().equals("component-scan")){
                // 获取扫包路径
                Attribute attribute = element.attribute("base-package");
                return attribute.getText();
            }
        }
        return null;
    }

    public InputStream getResourcesAsStream(String xmlPath){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
        return inputStream;
    }

    // 依赖注入
    public void inversionOfControl(Object object) throws Exception {
        // 依赖注入实现原理
        // 1.使用反射机制，获取当前类的所有属性
        Class<?> classInfo = object.getClass();
        Field[] fileds = classInfo.getDeclaredFields();
        // 2.判断当前类属性是否存在注解
        for (Field filed : fileds) {
            // 3.默认使用属性名称，查找bean容器对象
            ExtResource extResource = filed.getAnnotation(ExtResource.class);
            if(extResource !=null){
                // 获取属性名称
                String beanId = filed.getName();
                Object bean = getBean(beanId+"Impl");
                if(bean != null){
                    // 允许访问私有属性
                    filed.setAccessible(true);
                    // 属性赋值
                    filed.set(object,bean);
                }
            }
        }
    }

}