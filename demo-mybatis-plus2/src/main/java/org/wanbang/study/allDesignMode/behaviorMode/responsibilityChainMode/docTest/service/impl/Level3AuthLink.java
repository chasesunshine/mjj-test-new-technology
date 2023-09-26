package org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.service.impl;

import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.entity.AuthInfo;
import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.entity.AuthLink;
import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.service.AuthService;

import java.text.ParseException;
import java.util.Date;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/18 18:03
* @version 1.0
*/

public class Level3AuthLink extends AuthLink {
    private Date beginDate = f.parse("2022-08-01 00:00:00");
    private Date endDate = f.parse("2022-08-25 23:59:59");

    public Level3AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        System.out.println("Level3AuthLink 三级审批人");

        Date date = AuthService.queryAuthInfo(levelUserId, orderId);

        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待三级审批负责⼈ ", levelUserName);
        }

        AuthLink next = super.next();

        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：三级审批负责⼈完成", " 时间：", f.format(date), " 审批⼈：", levelUserName);
        }

        if (authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：三级审批负责⼈完成", " 时间：", f.format(date), " 审批⼈：", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }
}
