package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 家庭房间设备关系
 *
 * @author majiajian
 * @date 2022/7/19
 */
@Data
public class HomeRoomDeviceVO {

    /**
     * 设备Key
     */
    @ApiModelProperty(value = "设备Key")
    private String deviceKey;

    /**
     * 设备Key
     */
    @ApiModelProperty(value = "父设备设备Key")
    private String parentDeviceKey;

    /**
     * 房间id
     */
    @ApiModelProperty(value = "设备Key")
    private Long roomId;

    /**
     * 房间名称
     */
    @ApiModelProperty("房间名称")
    private String roomName;

    /**
     * 家庭id
     */
    @ApiModelProperty(value = "家庭id")
    private Long homeId;
}
