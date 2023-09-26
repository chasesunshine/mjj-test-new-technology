package org.wanbang.study.allDesignMode.behaviorMode.commandMode;

import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cook.service.impl.GuangDongCook;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cook.service.impl.JiangSuCook;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cook.service.impl.ShanDongCook;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cook.service.impl.SiChuanCook;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cuisine.service.ICuisine;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cuisine.service.impl.GuangDoneCuisine;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cuisine.service.impl.JiangSuCuisine;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cuisine.service.impl.ShanDongCuisine;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cuisine.service.impl.SiChuanCuisine;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.util.XiaoEr;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 11:43
* @version 1.0
*/

public class Test {
    public static void main(String[] args) {

        // 菜系 + 厨师；⼴东（粤菜）、江苏（苏菜）、⼭东（鲁菜）、四川（川菜）
        ICuisine guangDoneCuisine = new GuangDoneCuisine(new GuangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        // 点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        // 下单
        xiaoEr.placeOrder();

    }

}
