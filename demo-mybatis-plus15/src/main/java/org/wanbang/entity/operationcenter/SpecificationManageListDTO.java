package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 说明书管理 入参
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SpecificationManageListDTO{

    /**
     * 说明书图号
     */
    @ApiModelProperty("说明书图号")
    private String figureNum;

    /**
     * 说明书名称
     */
    @ApiModelProperty("说明书名称")
    private String name;

    /**
     * 说明书类型 0：使用说明书 1：安装说明书 2：程序员手册
     */
    @ApiModelProperty("说明书类型 0：使用说明书 1：安装说明书 2：程序员手册")
    private Integer type;

}
