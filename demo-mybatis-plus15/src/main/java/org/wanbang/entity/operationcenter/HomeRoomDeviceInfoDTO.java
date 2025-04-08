package org.wanbang.entity.operationcenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;


/**
 * 家庭下房间及房间附属表
 * @author PB086664
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HomeRoomDeviceInfoDTO {

    /**
     * 房间编码
     */
    private String roomCode;

    /**
     * 房间名称
     */
    private String roomName;

    /**
     * 关联设备列表
     */
    private List<String> relDevices;

}
