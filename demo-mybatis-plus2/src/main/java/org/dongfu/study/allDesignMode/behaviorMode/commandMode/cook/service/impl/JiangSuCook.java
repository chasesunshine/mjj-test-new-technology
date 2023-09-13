package org.dongfu.study.allDesignMode.behaviorMode.commandMode.cook.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dongfu.study.allDesignMode.behaviorMode.commandMode.cook.service.ICook;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 13:21
* @version 1.0
*/

public class JiangSuCook implements ICook {
    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("江苏厨师，烹饪苏菜，宫廷第⼆⼤菜系，古今国宴上最受⼈欢迎的菜系。");
    }
}
