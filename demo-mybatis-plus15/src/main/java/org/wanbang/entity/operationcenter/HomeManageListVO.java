package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 家庭管理列表 出参 - 2.5
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HomeManageListVO{

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
     * 用户id（管理员账号）
     */
    @ApiModelProperty(value = "用户id（管理员账号）")
    private String nlcId;

    /**
     * 家庭地址
     */
    @ApiModelProperty(value = "家庭地址")
    private String homeAddress;

    /**
     * 家庭成员
     */
    @ApiModelProperty(value = "家庭成员数")
    private int homeMember;

    /**
     * 房间数
     */
    @ApiModelProperty(value = "房间数")
    private int roomNumber;

    /**
     * 设备数
     */
    @ApiModelProperty(value = "设备数")
    private int deviceNumber;

    /**
     * 离线设备数
     */
    @ApiModelProperty(value = "离线设备数")
    private Integer offlineQuantity;

    /**
     * 在线设备数
     */
    @ApiModelProperty(value = "在线设备数")
    private Integer onlineQuantity;

    /**
     * 故障设备数
     */
    @ApiModelProperty(value = "故障设备数")
    private Integer faultQuantity;

}
