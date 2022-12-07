package org.wanbang.study.springEvent.difficult.service;
/**
* @description: 用户注册服务
 * 负责实现用户注册逻辑
 *
 * @0：事件发布者
 * @1：registerUser这个方法负责用户注册，内部主要做了2个事情
 * @2：模拟将用户信息落库
 * @3：使用事件发布者eventPublisher发布用户注册成功的消息:
 *
* @author majiajian
* @date 2022/12/7 14:30
* @version 1.0
*/

import org.wanbang.study.springEvent.difficult.event.UserRegisterSuccessEvent;
import org.wanbang.study.springEvent.difficult.listenerManage.EventMulticaster;

/**
 * 用户注册服务
 */
public class UserRegisterService {
    //事件发布者
    private EventMulticaster eventMulticaster; //@0

    /**
     * 注册用户
     *
     * @param userName 用户名
     */
    public void registerUser(String userName) { //@1
        //用户注册(将用户信息入库等操作)
        System.out.println(String.format("用户【%s】注册成功", userName)); //@2
        //广播事件
        this.eventMulticaster.multicastEvent(new UserRegisterSuccessEvent(this, userName)); //@3
    }

    public EventMulticaster getEventMulticaster() {
        return eventMulticaster;
    }

    public void setEventMulticaster(EventMulticaster eventMulticaster) {
        this.eventMulticaster = eventMulticaster;
    }
}
