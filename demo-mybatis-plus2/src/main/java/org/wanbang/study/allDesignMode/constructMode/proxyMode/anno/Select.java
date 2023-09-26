package org.wanbang.study.allDesignMode.constructMode.proxyMode.anno;

import java.lang.annotation.*;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/18 16:08
* @version 1.0
*/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {
    String value() default ""; // sql语句
}
