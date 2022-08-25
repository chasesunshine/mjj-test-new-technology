package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.common;

import java.math.BigDecimal;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 12:26
* @version 1.0
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
