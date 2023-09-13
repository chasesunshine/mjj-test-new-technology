package org.dongfu.study.allDesignMode.behaviorMode.commandMode.cook.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dongfu.study.allDesignMode.behaviorMode.commandMode.cook.service.ICook;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 13:20
* @version 1.0
*/

/**
 *
 * 这⾥是四类不同菜品的厨师
 * /
 * ，在这个实现的过程是模拟打了⽇志，相当于通知了厨房⾥具体的
 * 厨师进⾏菜品烹饪。
 * 从以上可以看到，当我们需要进⾏扩从的时候是可以⾮常⽅便的进⾏添加的，每⼀个类都具备了单
 * ⼀职责原则。
 *
 */
public class GuangDongCook implements ICook {
    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("⼴东厨师，烹饪鲁菜，宫廷最⼤菜系，以孔府⻛味为⻰头");
    }
}
