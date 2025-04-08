package org.wanbang.entity.operationcenter;

import lombok.Data;

import java.util.Date;

/**
 * 全屋设备信息
 *
 * @author zhaozhen
 * @date 2024/7/23 10:18
 */
@Data
public class HomeDeviceInfoVO {

    /**
     * 设备key
     */
    private String deviceKey;

    /**
     * 产品型号
     */
    private String model;

    /**
     * 产品ID
     */
    private String productId;

    /**
     * 设备所属平台标识
     */
    private Integer datasource;


    /**
     * 第三方平台唯一标识:初始设备key
     */
    private String originalKey;

    /**
     * 第三方设备入网时间
     */
    private Date startDt;

}
