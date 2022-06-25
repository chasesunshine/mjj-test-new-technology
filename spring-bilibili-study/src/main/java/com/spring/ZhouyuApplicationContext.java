package com.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZhouyuApplicationContext {
    private Class configClass;

    private ConcurrentHashMap<String ,Object> singleObjects = new ConcurrentHashMap<>(); //单例池
    private ConcurrentHashMap<String ,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(); //单例池


    public ZhouyuApplicationContext(Class configClass) {
        this.configClass = configClass;

        // 解析配置类
        // ComponentScan注解 --> 扫描路径 --> 扫描 --> BeanDefinition --> beanDefinitionMap
        scan(configClass);

        for (Map.Entry<String,BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if(beanDefinition.getScope().equals("singleton")){
                Object bean = createBean(beanDefinition); //单例bean

                singleObjects.put(beanName,bean);
            }
        }

    }

    public Object createBean(BeanDefinition beanDefinition){
        Class clazz = beanDefinition.getClazz();
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // 依赖注入
            for (Field declaredField : clazz.getDeclaredFields()) {
                if(declaredField.isAnnotationPresent(Autowired.class)){
                    Object bean = getBean(declaredField.getName());
                    declaredField.setAccessible(true);
                    declaredField.set(instance,bean);

                }
            }

            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void scan(Class configClass) {
        ComponentScan componentScan = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScan.value(); //扫描路径
        path = path.replace(".","/");

        // 扫描 三种类加载器
        // Bootstrap -->jre/lib
        // Ert -->jre/ext/lib
        // App -->classpath-->
        ClassLoader classLoader = ZhouyuApplicationContext.class.getClassLoader(); //app
        URL resource = classLoader.getResource(path);
        File file = new File((resource.getFile()));
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f:files) {

                String fileName = f.getAbsolutePath();
                // 将 C:\AllJavaWorkSpace\IdeaWorkSpace\mjj-test-new-technology\spring-bilibili-study\target\classes\com\zhouyu\service\UserService.class 转换为 com.zhouyu.service.UserService
                if(fileName.endsWith(".class")){
                    String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                    className = className.replace("\\",".");

                    Class<?> aClass = null;
                    try {
                        aClass = classLoader.loadClass(className);
                        if(aClass.isAnnotationPresent(Component.class)){
                            // 当前类 是 一个bean
                            // 解析类，判断当前bean 是单例bean，还是 prototype 的bean
                            // BeanDefinition

                            Component componentAnnotation = aClass.getAnnotation(Component.class);
                            String beanName = componentAnnotation.value();

                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(aClass);
                            if(aClass.isAnnotationPresent(Scope.class)){
                                Scope scopeDeclaredAnnotation = aClass.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeDeclaredAnnotation.value());
                            }else {
                                beanDefinition.setScope("singleton");
                            }

                            beanDefinitionMap.put(beanName,beanDefinition);

                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public Object getBean(String beanName){
        // 看map里面是否有bean的定义，再看是否是 单例 或者是 原型（多例）
        if(beanDefinitionMap.containsKey(beanName)){
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if(beanDefinition.getScope().equals("singleton")){
                Object o = singleObjects.get(beanName);
                return o;
            }else {
                //创建bean对象？
                Object bean = createBean(beanDefinition);
                return bean;
            }
        }else {
            // 不存在对应的bean
            throw new NullPointerException();
        }
    }
}
