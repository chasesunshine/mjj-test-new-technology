package org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.service;

import org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.common.Leader;
import org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.entity.LeaveInfo;

/**
* @description: 总经理类
* @author majiajian
* @date 2023/3/9 13:07
* @version 1.0
*/
public class GeneralManager extends Leader {


    /**
     * 初始化父类(传入姓名)
     */
    public GeneralManager(String name) {
        super(name);
    }


    /**
     * 处理业务的核心方法, 对请假信息进行处理
     */
    @Override
    public void handleLeave(LeaveInfo request) {
        if (request.getLeaveDays() < 30) {
            System.out.println("员工: " + request.getEmpName() + "请假,天数: " + request.getLeaveDays() + ",理由: " + request.getReason());
            System.out.println("总经理: " + this.name + ",审批通过!");
        }else {
            System.out.println("莫非" + request.getEmpName() + "想辞职,居然请假" + request.getLeaveDays() + "天!");
        }
    }

}
