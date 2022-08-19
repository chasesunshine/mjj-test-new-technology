package org.wanbang.study.allDesignMode.behaviorMode.commandMode.cook.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.behaviorMode.commandMode.cook.service.ICook;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 13:21
* @version 1.0
*/

public class SiChuanCook implements ICook {
    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("四川厨师，烹饪川菜，中国最有特⾊的菜系，也是⺠间最⼤菜系。");
    }
}
