package org.wanbang.study.springCircleDependence;

// Spring 是如何解决循环依赖的？
// https://www.zhihu.com/question/438247718/answer/1730527725
public class doc {
    // spring内部有三级缓存：
    //    一级缓存，用于保存实例化、注入、初始化完成的bean实例  singletonObjects
    //    二级缓存，用于保存实例化完成的bean实例  earlySingletonObjects
    //    三级缓存，用于保存bean创建工厂，以便于后面扩展有机会创建代理对象。singletonFactories
}
