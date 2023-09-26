package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.behaviorMode.strategyMode.common.Context;
import org.wanbang.study.allDesignMode.behaviorMode.strategyMode.event.ZJCouponDiscount;

import java.math.BigDecimal;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 12:12
* @version 1.0
*/

public class TestZj {
    private static Logger logger = LoggerFactory.getLogger(TestZj.class);

    public static void main(String[] args) {
        // 直减；100-10，商品100元
        Context<Double> context = new Context<Double>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
        logger.info("测试结果：直减优惠后⾦额 {}", discountAmount);
    }
}
