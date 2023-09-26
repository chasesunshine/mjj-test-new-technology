package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.behaviorMode.strategyMode.common.Context;
import org.wanbang.study.allDesignMode.behaviorMode.strategyMode.event.MJCouponDiscount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 12:12
* @version 1.0
*/

public class TestMj {
    private static Logger logger = LoggerFactory.getLogger(TestMj.class);
    
    public static void main(String[] args) {
        // 满100减10，商品100元
        Context<Map<String,String>> context = new Context<>(new MJCouponDiscount());

        Map<String,String> mapReq = new HashMap<>();
        mapReq.put("x","100");
        mapReq.put("n","10");

        BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
        logger.info("测试结果：满减优惠后⾦额 {}", discountAmount);
    }

}
