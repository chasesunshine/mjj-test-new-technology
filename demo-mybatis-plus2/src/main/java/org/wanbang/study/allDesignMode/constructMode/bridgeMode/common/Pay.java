package org.wanbang.study.allDesignMode.constructMode.bridgeMode.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
* @description: ⽀付类型桥接抽象类
* @author majiajian
* @date 2022/8/11 17:04
* @version 1.0
*/

/**
 * 在这个类中定义了⽀付⽅式的需要实现的划账接⼝： transfer ，以及桥接接⼝； IPayMode ，
 * 并在构造函数中⽤户⽅⾃⾏选择⽀付⽅式。
 * 如果没有接触过此类实现，可以᯿点关注 IPayMode payMode ，这部分是桥接的核⼼。
 */
public abstract class Pay {
    protected Logger logger = LoggerFactory.getLogger(Pay.class);
    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
