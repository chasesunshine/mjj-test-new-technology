package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * 使用说明书、安装说明书扫码、程序员手册扫码 入参
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SpecificationManagScanCodeDTO{

    /**
     * 说明书图号
     */
    @ApiModelProperty("说明书图号")
    @NotBlank(message = "MD5校验信息不能为空")
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
