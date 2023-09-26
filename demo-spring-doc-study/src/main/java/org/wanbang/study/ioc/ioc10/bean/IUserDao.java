package org.wanbang.study.ioc.ioc10.bean;
/**
* @description: TODO
* @author majiajian
* @date 2022/10/27 20:17
* @version 1.0
*/

/**
 *  这个章节我们删掉 UserDao，定义一个 IUserDao 接口，之所这样做是为了通过
 * FactoryBean 做一个自定义对象的代理操作。
 */
public interface IUserDao {
    String queryUserName(String uId);
}
