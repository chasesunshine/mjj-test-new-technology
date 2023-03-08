package org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/18 18:03
* @version 1.0
*/

/**
 *
 * 这部分是责任链，链接起来的核⼼部分。 AuthLink next ，᯿点在于可以通过 next ⽅式获取下
 * ⼀个链路需要处理的节点。
 * levelUserId 、 levelUserName ，是责任链中的公⽤信息，标记每⼀个审核节点的⼈员信息。
 * 抽象类中定义了⼀个抽象⽅法， abstract AuthInfo doAuth ，这是每⼀个实现者必须实现的
 * 类，不同的审核级别处理不同的业务。
 *
 */
public abstract class AuthLink {
    protected Logger logger = LoggerFactory.getLogger(AuthLink.class);
    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间格式化
    protected String levelUserId; // 级别⼈员ID
    protected String levelUserName; // 级别⼈员姓名
    private AuthLink next; // 责任链

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);
}
