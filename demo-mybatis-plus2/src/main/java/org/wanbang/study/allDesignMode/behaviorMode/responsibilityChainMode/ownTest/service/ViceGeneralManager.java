package org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.service;

import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.common.Leader;
import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.entity.LeaveInfo;

/**
* @description: 副总经理类
* @author majiajian
* @date 2023/3/9 9:54
* @version 1.0
*/
public class ViceGeneralManager extends Leader {

    /**
     * 初始化父类(传入姓名)
     */
    public ViceGeneralManager(String name) {
        super(name);
    }


    /**
     * 处理业务的核心方法, 对请假信息进行处理
     */
    @Override
    public void handleLeave(LeaveInfo request) {
        if (request.getLeaveDays() < 20) {
            System.out.println("员工: " + request.getEmpName() + "请假,天数: " + request.getLeaveDays() + ",理由: " + request.getReason());
            System.out.println("副总经理: " + this.name + ",审批通过!");
        }else {
            if (this.nextLeader!=null) {//如果有后继对象, 让后继对象继续处理
                this.nextLeader.handleLeave(request);
            }
        }
    }

}

