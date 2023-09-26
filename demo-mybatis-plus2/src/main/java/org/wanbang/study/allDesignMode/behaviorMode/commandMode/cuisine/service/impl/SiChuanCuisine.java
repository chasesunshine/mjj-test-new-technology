package org.wanbang.study.allDesignMode.behaviorMode.commandMode.cuisine.service.impl;

import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cook.service.ICook;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cuisine.service.ICuisine;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 13:22
* @version 1.0
*/

public class SiChuanCuisine implements ICuisine {
    private ICook cook;

    public SiChuanCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}
