package org.wanbang.study.ioc.ioc04.exception;
/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:14
* @version 1.0
*/

public class BeansException extends Throwable{

    public BeansException(String message, Exception e) {
        System.out.println("错误信息 :"+message);
    }

    public BeansException(String message) {
        System.out.println("错误信息 :"+message);
    }

}
