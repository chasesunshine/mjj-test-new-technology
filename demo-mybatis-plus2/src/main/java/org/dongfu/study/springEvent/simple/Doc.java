package org.dongfu.study.springEvent.simple;
/**
* @description: springboot 事件监听（@EventListener实现）
* @author majiajian
* @date 2022/12/7 11:24
* @version 1.0
*/

public class Doc {
    // 参考
    //【Java基础系列2】事件注解@EventListener使用姿势
    // https://zhuanlan.zhihu.com/p/387937470

    /**
     * spring中@EventListener 的详解和使用 (这篇案例讲的很好)
     * https://blog.csdn.net/flymoringbird/article/details/120481883
     * 事件模式中的几个概念
     * 事件源：事件的触发者，比如上面的注册器就是事件源。
     * 事件：描述发生了什么事情的对象，比如上面的：xxx注册成功的事件
     * 事件监听器：监听到事件发生的时候，做一些处理，比如上面的：路人A、路人B
     */

    // 个人用的这篇
    // springboot 事件监听（@EventListener实现
    // https://www.cnblogs.com/ryelqy/p/14616037.html?ivk_sa=1024320u
    /**
     * 说明：
     * @EventListener(CustomEvent.class)表示监听CustomEvent类的信息，
     * 如果流程applicationContext.publishEvent 推送customEvent类的消息，
     * 就会被CustomEventListener类中，标志@EventListener注解的方法所接受，并执行被注解方法的代码
     *
     */
}
