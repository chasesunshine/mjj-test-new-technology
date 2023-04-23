package com.example.log.collection.zuul.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author :XXX
 * @date :2020-09-08 11:34
 * @description :
 */
@Getter
@Setter
public class HttpEntity {

    // 客户机ip
    private String ip;
    // 不带host
    private String url;
    //  请求类型
    private String method;
    // 返回结果
    private String result;
    // 成功标记
    private Integer success;
    // 共用时长
    private Long duration;
    // 客户端标识
    private String userAgent;
    // 请求时间
    private Date launchTime;

    private String traceId;
    // 参数
    private String parameter;
}