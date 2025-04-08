package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 家庭管理列表 设备信息 出参 - 2.5
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HomeManageListDetailDeviceVO {

    /**
     * 房间id
     */
    @ApiModelProperty(value = "房间id")
    private Long roomId;

    /**
     * 房间编码
     */
    @ApiModelProperty(value = "房间编码")
    private String roomCode;

    /**
     * 设备id
     */
    @ApiModelProperty(value = "设备id")
    private String deviceId;

    /**
     * 设备类型
     */
    @ApiModelProperty(value = "设备类型")
    private String deviceType;

    /**
     * 设备key
     */
    @ApiModelProperty(value = "设备key")
    private String deviceKey;

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
     * 产品ID
     */
    @ApiModelProperty(value = "产品id，唯一标识，后端自动生成")
    private String productId;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;

    /**
     * 产品型号
     */
    @ApiModelProperty(value = "产品型号")
    private String productModel;

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

    /**
     * 图标 - dc_category（icon_url）
     */
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 产品厂家名称 - dc_product_factory（name）
     */
    @ApiModelProperty("产品厂家名称")
    private String productFactoryName;

}
