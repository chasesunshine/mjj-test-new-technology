package org.dongfu.study.designMode.decorator;

/**
 * RingPhoneDecorate
 * 给手机装饰彩铃功能
 * @author MoXingJian
 * @email 939697374@qq.com
 * @date 2016年12月11日 下午9:26:02
 * @version 1.0
 */
public class RingPhoneDecorate extends PhoneDecorate{
    public RingPhoneDecorate(Phone p) {
        super(p);
    }

    @Override
    public void call() {
        System.out.println("手机可以听彩铃");
        super.call();
    }
}
