package org.wanbang.study.allDesignMode.behaviorMode.observerMode;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.behaviorMode.observerMode.entity.LotteryResult;
import org.wanbang.study.allDesignMode.behaviorMode.observerMode.service.LotteryService;
import org.wanbang.study.allDesignMode.behaviorMode.observerMode.service.impl.LotteryServiceImpl;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 15:20
* @version 1.0
*/

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        LotteryService lotteryService = new LotteryServiceImpl();

        LotteryResult result = lotteryService.draw("2765789109876");

        logger.info("测试结果：{}", JSON.toJSONString(result));
    }
}
