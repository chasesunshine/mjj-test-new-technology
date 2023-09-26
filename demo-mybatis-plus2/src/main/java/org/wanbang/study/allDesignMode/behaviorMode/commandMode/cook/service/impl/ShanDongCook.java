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

public class ShanDongCook implements ICook {
    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("⼭东厨师，烹饪鲁菜，宫廷最⼤菜系，以孔府⻛味为⻰头");
    }
}
