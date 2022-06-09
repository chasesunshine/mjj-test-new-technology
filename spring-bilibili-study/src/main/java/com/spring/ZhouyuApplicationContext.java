package com.spring;

import java.lang.annotation.Annotation;

public class ZhouyuApplicationContext {
    private Class configClass;

    public ZhouyuApplicationContext(Class configClass) {
        this.configClass = configClass;

        // 解析配置类
        // ComponentScan注解 --> 扫描路径 --> 扫描
        Annotation[] annotations = configClass.getAnnotations();

    }

    public Object getBean(String beanName){
        return null;
    }
}
