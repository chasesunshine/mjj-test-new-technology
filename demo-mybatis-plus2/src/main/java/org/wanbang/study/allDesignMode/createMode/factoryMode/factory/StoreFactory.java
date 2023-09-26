package org.wanbang.study.allDesignMode.createMode.factoryMode.factory;

import org.wanbang.study.allDesignMode.createMode.factoryMode.common.ICommodity;
import org.wanbang.study.allDesignMode.createMode.factoryMode.service.impl.CardCommodityService;
import org.wanbang.study.allDesignMode.createMode.factoryMode.service.impl.CouponCommodityService;
import org.wanbang.study.allDesignMode.createMode.factoryMode.service.impl.GoodsCommodityService;

/**
* @description:  创建商店⼯⼚
* @author majiajian
* @date 2022/7/15 16:49
* @version 1.0
*/

/**
 * 这⾥我们定义了⼀个商店的⼯⼚类，在⾥⾯按照类型实现各种商品的服务。可以⾮常⼲净整洁的处
 * 理你的代码，后续新增的商品在这⾥扩展即可。如果你不喜欢 if 判断，也可以使⽤ switch 或
 * 者 map 配置结构，会让代码更加⼲净。
 * 另外很多代码检查软件和编码要求，不喜欢if语句后⾯不写扩展，这⾥是为了更加⼲净的向你体现
 * 逻辑。在实际的业务编码中可以添加括号
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
