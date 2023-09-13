package org.dongfu.study.allDesignMode.behaviorMode.observerMode.service;

import org.dongfu.study.allDesignMode.behaviorMode.observerMode.entity.LotteryResult;
import org.dongfu.study.allDesignMode.behaviorMode.observerMode.event.EventManager;
import org.dongfu.study.allDesignMode.behaviorMode.observerMode.event.listener.MQEventListener;
import org.dongfu.study.allDesignMode.behaviorMode.observerMode.event.listener.MessageEventListener;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 15:22
* @version 1.0
*/

/**
 * 业务抽象类接⼝
 *
 * 这种使⽤抽象类的⽅式定义实现⽅法，可以在⽅法中扩展需要的额外调⽤。并提供抽象
 * 类 abstract LotteryResult doDraw(String uId) ，让类的继承者实现。
 * 同时⽅法的定义使⽤的是 protected ，也就是保证将来外部的调⽤⽅不会调⽤到此⽅法，只有调
 * ⽤到 draw(String uId) ，才能让我们完成事件通知。
 * 此种⽅式的实现就是在抽象类中写好⼀个基本的⽅法，在⽅法中完成新增逻辑的同时，再增加抽象
 * 类的使⽤。⽽这个抽象类的定义会有继承者实现。
 * 另外在构造函数中提供了对事件的定
 * 义； eventManager.subscribe(EventManager.EventType.MQ, new
 * MQEventListener()) 。
 * 在使⽤的时候也是使⽤枚举的⽅式进⾏通知使⽤，传了什么类型
 * EventManager.EventType.MQ ，就会执⾏什么事件通知，按需添加。
 *
 */
public abstract class LotteryService {
    private EventManager eventManager;

    public LotteryService() {
        //把事件类型放入 构造器初始化
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);

        // subscribe - 订阅
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);

        // 需要什么通知就给调⽤什么⽅法
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);

        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);
}
