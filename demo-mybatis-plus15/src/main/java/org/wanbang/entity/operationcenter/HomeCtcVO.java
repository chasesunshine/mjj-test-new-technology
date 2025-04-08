package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author sunxiaoxiao
 * @date 2022/7/19
 */
@Data
public class HomeCtcVO {

    /**
     * 设备Key
     */
    @ApiModelProperty(value = "设备Key")
    private String deviceKey;

    /**
     * 家庭id
     */
    private Long homeId;

    /**
     * 家庭名称
     */
    private String homeName;

    /**
     * 产品型号
     */
    private String model;

    /**
     * 产品ID
     */
    private String productId;

    /**
     * 家庭下所有集控器的deviceKey
     */
    private List<String> ctcList;

    /**
     * 集控器的子设备列表
     */
    private List<String> subDeviceList;

}
