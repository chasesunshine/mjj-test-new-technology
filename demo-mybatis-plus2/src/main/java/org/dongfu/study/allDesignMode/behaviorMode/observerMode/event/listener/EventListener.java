package org.dongfu.study.allDesignMode.behaviorMode.observerMode.event.listener;

import org.dongfu.study.allDesignMode.behaviorMode.observerMode.entity.LotteryResult;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 15:23
* @version 1.0
*/

/**
 * 接⼝中定义了基本的事件类，这⾥如果⽅法的⼊参信息类型是变化的可以使⽤泛型 <T>
 */
public interface EventListener {

    void doEvent(LotteryResult result);

}
