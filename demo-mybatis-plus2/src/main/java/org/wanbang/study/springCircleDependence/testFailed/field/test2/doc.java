package org.wanbang.study.springCircleDependence.testFailed.field.test2;

// 在多例类（先初始化）中注入单例类（后初始化）：将陷入环
public class doc {
    // 环的陷入，是因为创建LoopA类需要LoopB类，LoopB类又需要LoopA类，
    // 在获取LoopA类时，发现LoopA类被存在一个未创建完成的HashSet中，于是抛出陷入循环的异常。
}
