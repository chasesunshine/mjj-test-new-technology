package org.wanbang.study.allDesignMode.behaviorMode.statusMode.enums;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/23 20:24
 * @version 1.0
 */
public enum Status {

    // 1 - 创建编辑、2 - 待审核、3 - 审核通过(任务扫描成活动中)、4 - 审核拒绝(可以撤审到编辑状态)、
    // 5 - 活动中、6 - 活动关闭、7 - 活动开启(任务扫描成活动中)
    Editing, Check, Pass, Refuse, Doing, Close, Open

}
