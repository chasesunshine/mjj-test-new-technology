package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 家庭管理列表 入参 - 2.5
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class SpecificationManageHtmlListDTO{

    /**
     * 产品型号
     */
    @ApiModelProperty(value = "产品型号")
    private String model;

    /**
     * 说明书类型 0：使用说明书 1：安装说明书 2：程序员手册
     */
    @ApiModelProperty(value = "说明书类型 0：使用说明书 1：安装说明书 2：程序员手册")
    private Integer type;
}
