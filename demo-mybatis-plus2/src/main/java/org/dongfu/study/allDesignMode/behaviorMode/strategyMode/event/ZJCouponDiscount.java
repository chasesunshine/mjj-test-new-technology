package org.dongfu.study.allDesignMode.behaviorMode.strategyMode.event;

import org.dongfu.study.allDesignMode.behaviorMode.strategyMode.common.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @description: 优惠券接⼝实现 - 直减
 * @author majiajian
 * @date 2022/8/25 12:25
 * @version 1.0
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {

    /**
     * 直减计算
     * 1. 使⽤商品价格减去优惠价格
     * 2. 最低⽀付⾦额1元
     */
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }

}
