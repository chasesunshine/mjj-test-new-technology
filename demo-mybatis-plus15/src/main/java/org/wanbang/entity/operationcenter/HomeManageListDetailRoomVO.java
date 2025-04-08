package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 家庭管理列表 房间信息 出参 - 2.5
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class HomeManageListDetailRoomVO {

    @ApiModelProperty("房间id")
    private Long roomId;

    /**
     * 房间编码
     */
    @ApiModelProperty(value = "房间编码")
    private String roomCode;

    /**
     * 房间名称
     */
    @ApiModelProperty(value = "房间名称")
    private String roomName;

    /**
     * 设备信息
     */
    @ApiModelProperty(value = "设备信息")
    private List<HomeManageListDetailDeviceVO> deviceList;

}
