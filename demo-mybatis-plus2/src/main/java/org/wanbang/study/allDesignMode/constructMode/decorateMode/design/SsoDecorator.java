package org.wanbang.study.allDesignMode.constructMode.decorateMode.design;

import org.wanbang.study.allDesignMode.constructMode.decorateMode.common.HandlerInterceptor;

/**
* @description: 抽象类装饰⻆⾊
* @author majiajian
* @date 2022/8/12 16:48
* @version 1.0
*/

/**
 * 在装饰类中有两个᯿点的地⽅是；1)继承了处理接⼝、2)提供了构造函数、3)覆盖了⽅法 preHandle 。
 * 以上三个点是装饰器模式的核⼼处理部分，这样可以踢掉对⼦类继承的⽅式实现逻辑功能扩展。
 */
public abstract class SsoDecorator implements HandlerInterceptor {
    private HandlerInterceptor handlerInterceptor;
    private SsoDecorator(){}
    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }
    public boolean preHandle(String request, String response, Object
            handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }
}
