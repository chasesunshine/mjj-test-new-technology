package org.wanbang.study.allDesignMode.publishSubscribe.publish;


import org.wanbang.study.allDesignMode.publishSubscribe.subscribe.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 具体的发布者类
public class ConcretePublisher implements Publisher {
    //         topic             ip集合
    private Map<String, List<Subscriber>> subscribers = new HashMap<>();

    /**
     * mjj个人理解：订阅者 需要注册自身的信息到发布者这边
     * @param eventType
     * @param subscriber
     */
    @Override
    public void subscribe(String eventType, Subscriber subscriber) {
        List<Subscriber> subscribersList = subscribers.computeIfAbsent(eventType, k -> new ArrayList<>());
        subscribersList.add(subscriber);
    }

    @Override
    public void unsubscribe(String eventType, Subscriber subscriber) {
        List<Subscriber> subs = subscribers.get(eventType);
        if (subs != null) {
            subs.remove(subscriber);
        }
        System.out.println("取消订阅成功");
    }

    @Override
    public void notifySubscribers(String eventType, String message) {
        List<Subscriber> subs = subscribers.get(eventType);
        if (subs != null) {
            for (Subscriber sub : subs) {
                sub.update(message);
            }
        }
    }
}

