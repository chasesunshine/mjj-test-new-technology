package org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.service;

import org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.common.Leader;
import org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.entity.LeaveInfo;

/**
* @description: 经理类
* @author majiajian
* @date 2023/3/8 19:45
* @version 1.0
*/

public class Manager extends Leader {

    /**
     * 初始化父类(传入姓名)
     */
    public Manager(String name) {
        super(name);
    }


    /**
     * 处理业务的核心方法, 对请假信息进行处理
     */
    @Override
    public void handleLeave(LeaveInfo request) {
        if (request.getLeaveDays() < 10) {
            System.out.println("员工: " + request.getEmpName() + "请假,天数: " + request.getLeaveDays() + ",理由: " + request.getReason());
            System.out.println("经理: " + this.name + ",审批通过!");
        }else {
            if (this.nextLeader!=null) {//如果有后继对象, 让后继对象继续处理
                this.nextLeader.handleLeave(request);
            }
        }
    }

}
