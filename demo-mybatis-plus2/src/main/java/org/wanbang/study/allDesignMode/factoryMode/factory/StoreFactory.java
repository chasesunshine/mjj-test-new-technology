package org.wanbang.study.allDesignMode.factoryMode.factory;

import org.wanbang.study.allDesignMode.factoryMode.common.ICommodity;
import org.wanbang.study.allDesignMode.factoryMode.service.impl.CardCommodityService;
import org.wanbang.study.allDesignMode.factoryMode.service.impl.CouponCommodityService;
import org.wanbang.study.allDesignMode.factoryMode.service.impl.GoodsCommodityService;

/**
* @description: TODO
* @author majiajian
* @date 2022/7/15 16:49
* @version 1.0
*/

public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
