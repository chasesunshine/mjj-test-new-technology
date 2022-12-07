package org.wanbang.study.springEvent.difficult.listener;
/**
* @description: 添加注册成功发送邮件功能
 * 下面添加一个注册成功发送邮件的功能，
 * 只需要自定义一个监听用户注册成功事件的监听器就可以了，
 * 其他代码不需要任何改动，如下
* @author majiajian
* @date 2022/12/7 14:43
* @version 1.0
*/

import org.springframework.stereotype.Component;
import org.wanbang.study.springEvent.difficult.event.UserRegisterSuccessEvent;

/**
 * 用户注册成功事件监听器->负责给用户发送邮件
 */
@Component
public class SendEmailOnUserRegisterSuccessListener implements EventListener<UserRegisterSuccessEvent> {

    @Override
    public void onEvent(UserRegisterSuccessEvent event) {
        System.out.println(String.format("给用户【%s】发送注册成功邮件!", event.getUserName()));
    }

}