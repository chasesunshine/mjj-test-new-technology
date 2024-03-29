package org.wanbang.study.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义@Resource注解 注入bean容器
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RUNTIME)
public @interface ExtResource {

}