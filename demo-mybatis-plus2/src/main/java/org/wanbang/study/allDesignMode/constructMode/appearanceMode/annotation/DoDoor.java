package org.wanbang.study.allDesignMode.constructMode.appearanceMode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/12 19:24
* @version 1.0
*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoDoor {
    String key() default "";
    String returnJson() default "";
}
