package org.wanbang.study.designMode.decorator;

/**
 * PhoneDecotate
 * 创建抽象的手机装饰类
 * @author MoXingJian
 * @email 939697374@qq.com
 * @date 2016年12月11日 下午9:03:29
 * @version 1.0
 */
public abstract class PhoneDecorate implements Phone{
    private Phone p;
    public PhoneDecorate(Phone p){
        this.p = p;
    }
    @Override
    public void call() {
        p.call();
    }
}
