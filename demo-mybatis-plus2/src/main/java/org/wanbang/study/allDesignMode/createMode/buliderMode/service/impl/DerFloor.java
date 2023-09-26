package org.wanbang.study.allDesignMode.createMode.buliderMode.service.impl;

import org.wanbang.study.allDesignMode.createMode.buliderMode.service.Matter;

import java.math.BigDecimal;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 13:41
* @version 1.0
*/

public class DerFloor implements Matter {
    public String scene() {
        return "地板";
    }
    public String brand() {
        return "德尔(Der)";
    }
    public String model() {
        return "A+";
    }
    public BigDecimal price() {
        return new BigDecimal(119);
    }
    public String desc() {
        return "DER德尔集团是全球领先的专业⽊地板制造商，北京2008年奥运会家装和公装地板供应商";
    }

}
