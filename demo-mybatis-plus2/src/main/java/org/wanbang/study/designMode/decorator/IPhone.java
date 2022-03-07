package org.wanbang.study.designMode.decorator;

/**
 * IPhone
 * @author MoXingJian
 * @email 939697374@qq.com
 * @date 2016年12月11日 下午9:01:17
 * @version 1.0
 */
public class IPhone implements Phone{
    @Override
    public void call() {
        System.out.println("手机可以打电话了！");
    }
}