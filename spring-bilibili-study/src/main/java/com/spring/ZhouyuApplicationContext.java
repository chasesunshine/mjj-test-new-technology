package com.spring;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;

public class ZhouyuApplicationContext {
    private Class configClass;

    public ZhouyuApplicationContext(Class configClass) {
        this.configClass = configClass;

        // 解析配置类
        // ComponentScan注解 --> 扫描路径 --> 扫描
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
                    System.out.println(className);

                    Class<?> aClass = null;
                    try {
                        aClass = classLoader.loadClass(className);
                        if(aClass.isAnnotationPresent(Component.class)){
                            // 当前类 是 一个bean
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }

    public Object getBean(String beanName){
        return null;
    }
}
