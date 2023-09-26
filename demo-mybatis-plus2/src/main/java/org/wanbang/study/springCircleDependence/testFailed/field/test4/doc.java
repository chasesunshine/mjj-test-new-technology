package org.wanbang.study.springCircleDependence.testFailed.field.test4;

// 在单例类（先初始化）中注入多例类（后初始化）：不会陷入环
public class doc {

    // 从日志中也可以看到，当对单例类（LoopA类）进行初始化时，还未执行构造函数，类就已经被实例化出来了，
    // 并存放于第三级缓存 singletonFactories 的HashMap中，
    // 再注入单例类（LoopA类）中的属性，当其他的类（单例或多例）在循环注入单例类（LoopA类）时，
    // 就可以获取到单例类（LoopA类），此时便跳出了循环
}
