package org.wanbang.study.springEvent;
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
