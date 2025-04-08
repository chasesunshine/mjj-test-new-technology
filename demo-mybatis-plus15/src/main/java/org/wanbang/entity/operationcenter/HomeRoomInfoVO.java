package org.wanbang.entity.operationcenter;

import lombok.Data;


/**
 * @author sunxiaoxiao
 * @date 2022/7/19
 */
@Data
public class HomeRoomInfoVO {

    /**
     * 家庭id
     */
    private Long homeId;

    /**
     * 房间id
     */
    private Long roomId;

    /**
     * 房间编码
     */
    private String roomCode;

    /**
     * 房间名称
     */
    private String roomName;

    /**
     * 房间和设备关联关系唯一主键
     */
    private Long roomDeviceId;
}
