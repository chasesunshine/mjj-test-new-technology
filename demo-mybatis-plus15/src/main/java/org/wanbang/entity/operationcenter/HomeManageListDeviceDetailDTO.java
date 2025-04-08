package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 家庭管理列表设备详情 入参 - 2.5
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class HomeManageListDeviceDetailDTO {

    /**
     * 家庭id
     */
    @ApiModelProperty(value = "家庭id")
    private String homeId;

    /**
     * 房间编码
     */
    @ApiModelProperty(value = "房间编码")
    private String roomCode;

    /**
     * 设备名称
     */
    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    /**
     * 设备MAC
     */
    @ApiModelProperty(value = "设备MAC")
    private String mac;

    /**
     * 设备状态
     */
    @ApiModelProperty("设备状态")
    private Integer status;

    /**
     * 设备故障状态
     */
    @ApiModelProperty("设备故障状态")
    private Integer faultStatus;

    /**
     * 数据来源（加在dc_device表）
     */
    @ApiModelProperty("数据来源")
    private Integer dataSource;

}
