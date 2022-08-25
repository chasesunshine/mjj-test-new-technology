package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.behaviorMode.strategyMode.common.Context;
import org.wanbang.study.allDesignMode.behaviorMode.strategyMode.event.ZKCouponDiscount;

import java.math.BigDecimal;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 12:12
* @version 1.0
*/

public class TestZk {
    private static Logger logger = LoggerFactory.getLogger(TestZk.class);

    public static void main(String[] args) {
        // 折扣9折，商品100元
        Context<Double> context = new Context<Double>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
        logger.info("测试结果：折扣9折后⾦额 {}", discountAmount);
    }
}
