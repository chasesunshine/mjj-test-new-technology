package org.wanbang.study.allDesignMode.behaviorMode.commandMode.cuisine.service.impl;

import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cook.service.ICook;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cuisine.service.ICuisine;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 13:22
* @version 1.0
*/

/**
 *
 * 以上是四种菜品的实现，在实现的类中都有添加了⼀个厨师类( ICook )，并通过这个类提供的⽅法
 * 进⾏操作命令(烹饪菜品) cook.doCooking() 。
 * 命令的实现过程可以是按照逻辑进⾏添加补充，⽬前这⾥抽象的⽐较简单，只是模拟⼀个烹饪的过
 * 程，相当于同时厨师进⾏菜品烹饪
 *
 */
public class GuangDoneCuisine implements ICuisine {
    private ICook cook;

    public GuangDoneCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}
