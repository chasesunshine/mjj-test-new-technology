package org.wanbang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * rocketMQ 内容转换类
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class MQContentDTO {

    /**
     * 消息id
     */
    private String msgId;

    /**
     * 平台标识
     */
    private String platform;

    /**
     * 消息产生的时间戳，单位毫秒
     */
    private String time;

    /**
     * 事件消息通知类型，如：绑定 解绑 在线 离线
     */
    private String eventType;

    /**
     * 具体的消息内容
     */
    private Object data;

}
