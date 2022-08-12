package org.wanbang.study.allDesignMode.constructMode.decorateMode.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.constructMode.decorateMode.common.HandlerInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
* @description: 装饰⻆⾊逻辑实现
* @author majiajian
* @date 2022/8/12 16:48
* @version 1.0
*/

/**
 *
 * 在具体的装饰类实现中，继承了装饰类 SsoDecorator ，那么现在就可以扩展⽅法； preHandle
 * 在 preHandle 的实现中可以看到，这⾥只关⼼扩展部分的功能，同时不会影响原有类的核⼼服
 * 务，也不会因为使⽤继承⽅式⽽导致的多余⼦类，增加了整体的灵活性。
 *
 */
public class LoginSsoDecorator extends SsoDecorator {
    private Logger logger = LoggerFactory.getLogger(LoginSsoDecorator.class);
    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();
    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object
            handler) {
        boolean success = super.preHandle(request, response, handler);
        if (!success) return false;
        String userId = request.substring(8);
        String method = authMap.get(userId);
        logger.info("模拟单点登录⽅法访问拦截校验：{} {}", userId, method);
        // 模拟⽅法校验
        return "queryUserInfo".equals(method);
    }
    
}