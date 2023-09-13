package org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.common;

import org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.entity.LeaveInfo;

/**
 * @description: 领导抽象类
 * @author majiajian
 * @date 2023/3/8 19:36
 * @version 1.0
 */

public abstract class Leader {

    protected String name;//姓名
    protected Leader nextLeader;//责任链上的后继对象

    public Leader(String name){
        this.name = name;
    }


    /**
     * 设置责任链上的后继对象
     */
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }


    /**
     * 处理业务的核心方法
     */
    public abstract void handleLeave(LeaveInfo leaveInfo);

}
