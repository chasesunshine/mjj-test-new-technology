package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.event;

import org.wanbang.study.allDesignMode.behaviorMode.strategyMode.common.ICouponDiscount;

import java.math.BigDecimal;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 12:26
* @version 1.0
*/

public class ZKCouponDiscount implements ICouponDiscount<Double> {

    /**
     * 折扣计算
     * 1. 使⽤商品价格乘以折扣⽐例，为最后⽀付⾦额
     * 2. 保留两位⼩数
     * 3. 最低⽀付⾦额1元
     */
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal(couponInfo)).setScale(2, BigDecimal.ROUND_HALF_UP);
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }

}