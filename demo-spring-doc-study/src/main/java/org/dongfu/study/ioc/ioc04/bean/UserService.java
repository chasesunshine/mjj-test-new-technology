package org.dongfu.study.ioc.ioc04.bean;
/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:17
* @version 1.0
*/

/**
 * 这里唯一多在 UserService 中添加的就是一个有 name 入参的构造函数，方便我
 * 们验证这样的对象是否能被实例化。
 */
public class UserService {
    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }

}
