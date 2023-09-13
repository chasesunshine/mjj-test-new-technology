package org.dongfu.study.allDesignMode.constructMode.flyWeightMode.controller;
/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/17 17:53
 * @version 1.0
 */

import org.dongfu.study.allDesignMode.constructMode.flyWeightMode.design.ActivityFactory;
import org.dongfu.study.allDesignMode.constructMode.flyWeightMode.design.Stock;
import org.dongfu.study.allDesignMode.constructMode.flyWeightMode.entity.Activity;
import org.dongfu.study.allDesignMode.constructMode.flyWeightMode.util.RedisUtils;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成⻓，让⾃⼰和他⼈都能有所收获！
 * 公众号：bugstack⾍洞栈
 * Create by ⼩傅哥(fustack) @2020
 */
public class ActivityController {
    private RedisUtils redisUtils = new RedisUtils();

    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        // 模拟从Redis中获取库存变化信息
        Stock stock = new Stock(1000, redisUtils.getStockUsed());
        activity.setStock(stock);
        return activity;
    }

}