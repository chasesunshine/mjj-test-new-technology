package org.wanbang.common.anno;

import java.lang.annotation.*;

/**
 * 使用此注解标识DAO层不需要日记记录的方法
 *
 * @Author mjj
 * @Date 17:48 2021/11/30
 * @Param
 * @return
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UnRecordLog {
}

