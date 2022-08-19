package org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.service.impl;

import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.entity.AuthInfo;
import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.entity.AuthLink;
import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.service.AuthService;

import java.util.Date;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/18 18:02
* @version 1.0
*/

/**
 *
 * 例如第⼀个审核类中会先判断是否审核通过，如果没有审核通过则返回结果给调⽤⽅，引导去审
 * 核。（这⾥简单模拟审核后有时间信息不为空，作为判断条件）
 * 判断完成后获取下⼀个审核节点； super.next(); ，如果不存在下⼀个节点，则直接返回结果。
 * 之后是根据不同的业务时间段进⾏判断是否需要，⼆级和⼀级的审核。
 * 最后返回下⼀个审核结果； next.doAuth(uId, orderId, authDate); ，有点像递归调⽤。
 *
 */
public class Level1AuthLink extends AuthLink {

    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        System.out.println("Level1AuthLink 一级审批人");

        Date date = AuthService.queryAuthInfo(levelUserId, orderId);

        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待⼀级审批负责⼈ ", levelUserName);
        }

        AuthLink next = super.next();

        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：⼀级审批完成负责⼈", " 时间：", f.format(date), " 审批⼈：", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }
}