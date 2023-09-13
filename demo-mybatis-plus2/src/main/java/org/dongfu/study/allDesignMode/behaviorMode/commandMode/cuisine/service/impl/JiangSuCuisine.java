package org.dongfu.study.allDesignMode.behaviorMode.commandMode.cuisine.service.impl;

import org.dongfu.study.allDesignMode.behaviorMode.commandMode.cook.service.ICook;
import org.dongfu.study.allDesignMode.behaviorMode.commandMode.cuisine.service.ICuisine;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 13:22
* @version 1.0
*/

public class JiangSuCuisine implements ICuisine {
    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}
