package org.wanbang.redislock.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: huangchuang
 * @CreateTime: 2021-12-03 13:49
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum BizCodeEnum {

    SUCCESS(0, "SUCCESS"),
    FAIL(10000, "FAIL"),

    PARAM_ERROR(11000, "参数错误"),
    ILLEGAL_PARAM(11001, "参数不合法"),

    SERVICE_BUSY(99997,"系统繁忙，请稍后重试"),
    SERVICE_NOT_FOUND(99998,"找不到下游服务器"),
    SYSTEM_ERROR(99999,"系统错误");
    ;
    private Integer code;
    private String message;
}
