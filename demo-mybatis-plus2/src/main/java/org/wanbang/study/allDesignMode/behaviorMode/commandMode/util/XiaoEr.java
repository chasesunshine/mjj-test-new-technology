package org.wanbang.study.allDesignMode.behaviorMode.commandMode.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cuisine.service.ICuisine;

import java.util.ArrayList;
import java.util.List;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 13:23
* @version 1.0
*/

/**
 *
 * 在调⽤者的具体实现中，提供了菜品的添加和菜单执⾏烹饪。这个过程是命令模式的具体调⽤，通
 * 过外部将菜品和厨师传递进来⽽进⾏具体的调⽤。
 *
 */
public class XiaoEr {
    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);
    private List<ICuisine> cuisineList = new ArrayList<ICuisine>();

    public void order(ICuisine cuisine) {
        cuisineList.add(cuisine);
    }

    public synchronized void placeOrder() {
        for (ICuisine cuisine : cuisineList) {
            cuisine.cook();
        }
        cuisineList.clear();
    }

}
