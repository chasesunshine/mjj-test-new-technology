package org.wanbang.study.allDesignMode.publishSubscribe;

import org.wanbang.study.allDesignMode.publishSubscribe.publish.ConcretePublisher;
import org.wanbang.study.allDesignMode.publishSubscribe.publish.Publisher;
import org.wanbang.study.allDesignMode.publishSubscribe.subscribe.ConcreteSubscriber;
import org.wanbang.study.allDesignMode.publishSubscribe.subscribe.Subscriber;

/**
 * 发布-订阅模式（Publish-Subscribe Pattern）是一种常见的设计模式，用于实现对象间的一对多依赖关系。当一个对象的状态发生变化时，所有依赖于它的对象都会收到通知并自动更新。
 * 下面是一个简单的Java实现发布-订阅模式的示例：
 *
 * 代码说明：
 * Publisher接口：定义了订阅、取消订阅和通知订阅者的方法。
 * Subscriber接口：定义了更新方法，当发布者发布消息时，订阅者会收到通知并执行更新操作。
 * ConcretePublisher类：实现了Publisher接口，维护了一个事件类型到订阅者列表的映射。
 * ConcreteSubscriber类：实现了Subscriber接口，定义了具体的更新操作。
 * PubSubPatternDemo类：测试类，演示了如何使用发布-订阅模式。
 *
 * 总结：
 * 这个示例展示了如何手写一个简单的发布-订阅模式。通过这种模式，发布者和订阅者之间实现了松耦合，发布者不需要知道具体的订阅者，只需要通知所有订阅了特定事件的订阅者即可。
 *
 */
// 测试类
public class PubSubPatternDemoTest {
    public static void main(String[] args) {
        // 创建发布者
        Publisher publisher = new ConcretePublisher();

        // 创建订阅者
        Subscriber subscriber1 = new ConcreteSubscriber("Subscriber1");
        Subscriber subscriber2 = new ConcreteSubscriber("Subscriber2");

        /**
         * 个人理解：就是 subscriber1需要订阅 ，所以需要调用发布者的方法，来把自身的信息注册到发布者里面
         */
        // 订阅事件
        publisher.subscribe("event1", subscriber1);
        publisher.subscribe("event1", subscriber2);

        // 发布事件
        publisher.notifySubscribers("event1", "Hello, World!");

        // 取消订阅
        publisher.unsubscribe("event1", subscriber2);

        // 再次发布事件
        publisher.notifySubscribers("event1", "Hello again!");
    }
}