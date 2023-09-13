package org.dongfu.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/18 18:01
* @version 1.0
*/

/**
 *
 * 这⾥⾯提供了两个接⼝⼀个是查询审核结果( queryAuthInfo )、另外⼀个是处理审核( auth )。
 * 这部分是把由谁审核的和审核的单⼦ID作为唯⼀key值记录到内存Map结构中。
 *
 */
public class AuthService {
    private static Map<String, Date> authMap = new ConcurrentHashMap<String, Date>();

    public static Date queryAuthInfo(String uId, String orderId) {
        return authMap.get(uId.concat(orderId));
    }

    public static void auth(String uId, String orderId) {
        authMap.put(uId.concat(orderId), new Date());
    }
}
