package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class SpecificationManageEditDTO {

    /**
     * 说明书图号
     */
    @NotBlank(message = "说明书图号不能为空")
    @ApiModelProperty("说明书图号")
    private String figureNum;

    /**
     * 说明书名称
     */
    @ApiModelProperty("说明书名称")
    @NotBlank(message = "说明书名称不能为空")
    private String name;

    /**
     * MD5校验信息
     */
    @ApiModelProperty("MD5校验信息")
    @NotBlank(message = "MD5校验信息不能为空")
    private String Md5CheckInfo;

    /**
     * 状态 0：草稿 1：已发布
     */
    @ApiModelProperty("状态 0：草稿 1：已发布")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
