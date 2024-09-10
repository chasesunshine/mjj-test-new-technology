package org.wanbang.dto;

import lombok.Data;

/**
 * @author ZhangYu
 * @date 2024/7/18
 */
@Data
public class MQMessageContentDTO {

    /**
     * 消息体
     */
    private String content;

    /**
     * 签名
     */
    private String sign;

    /**
     * 时间戳
     */
    private Long t;

    /**
     * 平台
     */
    private String platform;
}
