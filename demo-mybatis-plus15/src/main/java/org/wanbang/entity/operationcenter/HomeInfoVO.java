package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 家庭管理列表 根据设备id列表获取所属家庭 出参 - 2.5
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HomeInfoVO {

    /**
     * 家庭id
     */
    @ApiModelProperty(value = "家庭id")
    private String homeId;

    /**
     * 家庭名称
     */
    @ApiModelProperty(value = "家庭名称")
    private String homeName;

    /**
     * 设备id
     */
    @ApiModelProperty("设备唯一key - 转化为云端的key")
    private String deviceKey;

    /**
     * 设备名称
     */
    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    /**
     * 房间编码
     */
    @ApiModelProperty(value = "房间编码")
    private String roomCode;

    /**
     * 房间名称
     */
    @ApiModelProperty("房间名称")
    private String roomName;

}
