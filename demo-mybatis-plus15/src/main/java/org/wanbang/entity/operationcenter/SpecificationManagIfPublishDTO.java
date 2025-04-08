package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 说明书管理-说明书发布(生成二维码)/撤销发布 入参
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SpecificationManagIfPublishDTO{

    /**
     * 说明书图号
     */
    @ApiModelProperty("说明书图号")
    @NotBlank(message = "MD5校验信息不能为空")
    private String figureNum;

    /**
     * 状态 0：草稿 1：已发布
     */
    @ApiModelProperty("状态 0：草稿 1：已发布")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
