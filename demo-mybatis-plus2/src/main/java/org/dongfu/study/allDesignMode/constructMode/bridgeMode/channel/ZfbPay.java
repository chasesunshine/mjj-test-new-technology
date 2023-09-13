package org.dongfu.study.allDesignMode.constructMode.bridgeMode.channel;

import org.dongfu.study.allDesignMode.constructMode.bridgeMode.common.Pay;
import org.dongfu.study.allDesignMode.constructMode.bridgeMode.common.IPayMode;

import java.math.BigDecimal;

/**
* @description: ⽀付宝⽀付
* @author majiajian
* @date 2022/8/11 17:04
* @version 1.0
*/

/**
 *
 * 这⾥分别模拟了调⽤第三⽅的两个⽀付渠道；微信、⽀付宝，当然作为⽀付综合平台可能不只是接
 * 了这两个渠道，还会有其很跟多渠道。
 * 另外可以看到在⽀付的时候分别都调⽤了⻛控的接⼝进⾏验证，也就是不同模式的⽀付( 刷脸 、 指
 * 纹 )，都需要过指定的⻛控，才能保证⽀付安全。
 *
 */
public class ZfbPay extends Pay {
    public ZfbPay(IPayMode payMode) {
        super(payMode);
    }

    public String transfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("模拟⽀付宝渠道⽀付划账开始。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        logger.info("模拟⽀付宝渠道⽀付⻛控校验。uId：{} tradeId：{} security：{}", uId, tradeId, security);
        if (!security) {
            logger.info("模拟⽀付宝渠道⽀付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        logger.info("模拟⽀付宝渠道⽀付划账成功。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
        return "0000";
    }

}
