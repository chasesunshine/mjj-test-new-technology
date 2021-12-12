package com.example.rocketmq.common.anno;

import java.lang.annotation.*;

/**
 * 使用此注解标识DAO层需要日记记录的方法
 *
 * @Author mjj
 * @Date 17:47 2021/11/30
 * @Param 
 * @return 
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordLog {
    /**
     * 日志记录描述
     *
     * @return
     */
    String desc() default "";
}
