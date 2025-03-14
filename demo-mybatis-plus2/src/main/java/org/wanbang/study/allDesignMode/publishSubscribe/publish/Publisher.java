package org.wanbang.study.allDesignMode.publishSubscribe.publish;

import org.wanbang.study.allDesignMode.publishSubscribe.subscribe.Subscriber;

// 发布者接口
public interface Publisher {

    // 订阅
    void subscribe(String eventType, Subscriber subscriber);

    // 取消订阅
    void unsubscribe(String eventType, Subscriber subscriber);

    // 通知所有订阅者
    void notifySubscribers(String eventType, String message);

}
