package org.wanbang.entity.operationcenter;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class SpecificationManageHtmlListVO {
    /**
     * 产品id
     */
    @JsonProperty("pId")
    @ApiModelProperty("产品id")
    private Long pId;
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
     * 说明书管理列表H5 详情
     */
    @ApiModelProperty(value = "说明书管理列表H5 详情")
    private SpecificationManageHtmlDetailVO specificationManageHtmlDetailVO;
}
