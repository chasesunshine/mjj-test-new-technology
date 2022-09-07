package org.wanbang.study.ioc.ioc03.exception;
/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:14
* @version 1.0
*/

public class BeansException extends Throwable{
    public BeansException(String instantiation_of_bean_failed, ReflectiveOperationException e) {
    }

    public BeansException(String s) {
    }
}
