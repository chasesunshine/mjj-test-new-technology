package org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest;

import org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.common.Leader;
import org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.entity.LeaveInfo;
import org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.service.Director;
import org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.service.GeneralManager;
import org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.service.Manager;
import org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.ownTest.service.ViceGeneralManager;

/**
* @description: 测试类:
* @author majiajian
* @date 2023/3/9 13:09
* @version 1.0
*/
public class Test {

    public static void main(String[] args) {
        //主任
        Leader director = new Director("张三");
        //经理
        Leader manager = new Manager("李四");
        //副总经理
        Leader viceGeneralManager = new ViceGeneralManager("李小四");
        //总经理
        Leader generalManager = new GeneralManager("王五");
        //也可以存到容器里,并进行遍历,一样

        //组织责任链对象的关系
        director.setNextLeader(manager);//主任的上司: 经理
        manager.setNextLeader(viceGeneralManager);//经理的上司: 副总经理
        viceGeneralManager.setNextLeader(generalManager);//副总经理的上司: 总经理


        //开始请假操作
        LeaveInfo leave = new LeaveInfo("Tom", 15, "去美国探亲!");
        director.handleLeave(leave);//先由低层开始处理, 可以处理就处理, 请假15天应该由副总经理处理, 看看结果!
    }

}
