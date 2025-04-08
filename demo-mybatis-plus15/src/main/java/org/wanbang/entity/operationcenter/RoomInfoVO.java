package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 家庭管理列表 获取所有房间信息 出参 - 2.5
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RoomInfoVO {

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
