package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.event;

import org.wanbang.study.allDesignMode.behaviorMode.strategyMode.common.ICouponDiscount;

import java.math.BigDecimal;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 12:25
* @version 1.0
*/

public class NYGCouponDiscount implements ICouponDiscount<Double> {

    /**
     * n元购购买
     * 1. ⽆论原价多少钱都固定⾦额购买
     */
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        return new BigDecimal(couponInfo);
    }

}
