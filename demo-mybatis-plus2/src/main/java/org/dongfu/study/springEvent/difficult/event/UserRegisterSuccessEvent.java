package org.dongfu.study.springEvent.difficult.event;
/**
* @description: 自定义用户注册成功事件类
 * 继承了AbstractEvent类
* @author majiajian
* @date 2022/12/7 14:28
* @version 1.0
*/

/**
 * 用户注册成功事件
 */
public class UserRegisterSuccessEvent extends AbstractEvent {
    //用户名
    private String userName;

    /**
     * 创建用户注册成功事件对象
     *
     * @param source   事件源
     * @param userName 当前注册的用户名
     */
    public UserRegisterSuccessEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}