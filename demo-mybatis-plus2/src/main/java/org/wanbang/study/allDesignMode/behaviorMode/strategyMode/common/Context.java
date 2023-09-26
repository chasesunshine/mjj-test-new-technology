package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.common;

import java.math.BigDecimal;

/**
* @description: 策略控制类
* @author majiajian
* @date 2022/8/25 12:26
* @version 1.0
*/

/**
 * 策略模式的控制类主要是外部可以传递不同的策略实现，在通过统⼀的⽅法执⾏优惠策略计算。
 * 另外这⾥也可以包装成map结构，让外部只需要对应的泛型类型即可使⽤相应的服务
 *
 * @param <T>
 */
public class Context<T> {
    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }
}
