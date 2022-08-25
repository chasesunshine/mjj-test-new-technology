package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.event;

import org.wanbang.study.allDesignMode.behaviorMode.strategyMode.common.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 12:25
* @version 1.0
*/
public class MJCouponDiscount implements ICouponDiscount<Map<String,String>> {

    /**
     * 满减计算
     * 1. 判断满⾜x元后-n元，否则不减
     * 2. 最低⽀付⾦额1元
     */
    public BigDecimal discountAmount(Map<String,String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String o = couponInfo.get("n");
        // ⼩于商品⾦额条件的，直接返回商品原价
        if (skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;
        // 减去优惠⾦额判断
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }

}
