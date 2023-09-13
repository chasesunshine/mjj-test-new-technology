package org.dongfu.study.allDesignMode.createMode.buliderMode.service.impl;

import org.dongfu.study.allDesignMode.createMode.buliderMode.service.Matter;

import java.math.BigDecimal;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/11 13:40
 * @version 1.0
 */

public class LiBangCoat implements Matter {
    public String scene() {
        return "涂料";
    }
    public String brand() {
        return "⽴邦";
    }
    public String model() {
        return "默认级别";
    }
    public BigDecimal price() {
        return new BigDecimal(650);
    }
    public String desc() {
        return "⽴邦始终以开发绿⾊产品、注᯿⾼科技、⾼品质为⽬标，以技术⼒量不断推进科研和开发，满⾜消费者需求。";
    }
}