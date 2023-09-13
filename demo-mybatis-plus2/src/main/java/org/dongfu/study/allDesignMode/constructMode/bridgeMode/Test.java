package org.dongfu.study.allDesignMode.constructMode.bridgeMode;

import org.dongfu.study.allDesignMode.constructMode.bridgeMode.common.Pay;
import org.dongfu.study.allDesignMode.constructMode.bridgeMode.channel.WxPay;
import org.dongfu.study.allDesignMode.constructMode.bridgeMode.channel.ZfbPay;
import org.dongfu.study.allDesignMode.constructMode.bridgeMode.mode.PayFaceMode;
import org.dongfu.study.allDesignMode.constructMode.bridgeMode.mode.PayFingerprintMode;

import java.math.BigDecimal;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 17:05
* @version 1.0
*/

public class Test {
    public static void main(String[] args) {
        System.out.println("\r\n模拟测试场景；微信⽀付、⼈脸⽅式。");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；⽀付宝⽀付、指纹⽅式。");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));
    }
}
