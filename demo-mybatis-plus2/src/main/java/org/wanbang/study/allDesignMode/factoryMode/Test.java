package org.wanbang.study.allDesignMode.factoryMode;

import org.wanbang.study.allDesignMode.factoryMode.factory.StoreFactory;
import org.wanbang.study.allDesignMode.factoryMode.common.ICommodity;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/7/15 16:51
 * @version 1.0
 */

public class Test {
    public static void main(String[] args) throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        // 1. 优惠券
        ICommodity commodityService_1 = storeFactory.getCommodityService(1);
        commodityService_1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);


        // 2. 实物商品
        ICommodity commodityService_2 = storeFactory.getCommodityService(2);
        Map<String,String> extMap = new HashMap<String,String>();
        extMap.put("consigneeUserName", "谢⻜机");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "吉林省.⻓春市.双阳区.XX街道.檀溪苑⼩区.#18-2109");
        commodityService_2.sendCommodity("10001","9820198721311","1023000020112221113", extMap);


        // 3. 第三⽅兑换卡(爱奇艺)
        ICommodity commodityService_3 = storeFactory.getCommodityService(3);

        commodityService_3.sendCommodity("10001","AQY1xjkUodl8LO975GdfrYUio",null,null);
    }
}
