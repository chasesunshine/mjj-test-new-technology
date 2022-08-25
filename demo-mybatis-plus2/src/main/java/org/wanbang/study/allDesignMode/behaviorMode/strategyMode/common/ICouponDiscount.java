package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.common;

import java.math.BigDecimal;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 12:26
* @version 1.0
*/
public interface ICouponDiscount<T> {

    /**
     * 优惠券⾦额计算
     * @param couponInfo 券折扣信息；直减、满减、折扣、N元购
     * @param skuPrice sku⾦额
     * @return 优惠后⾦额
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);

}
