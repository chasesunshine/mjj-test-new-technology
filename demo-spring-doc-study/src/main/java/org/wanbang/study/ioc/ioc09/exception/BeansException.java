package org.wanbang.study.ioc.ioc09.exception;
/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:14
* @version 1.0
*/

public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
