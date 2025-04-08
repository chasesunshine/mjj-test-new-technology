package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

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
public class SpecificationManageAddOldDTO {

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

    /**
     * 产品id
     */
    @ApiModelProperty("产品id")
    private Long pId;

    /**
     * OBS文件url
     */
    @ApiModelProperty("OBS文件url")
    @NotBlank(message = "文件url不能为null")
    private String fileUrl;

    /**
     * OBS文件ObjectKey
     */
    @ApiModelProperty("OBS文件ObjectKey")
    @NotBlank(message = "文件ObjectKey不能为null")
    private String fileObjectKey;

    /**
     * 文件大小
     */
    @ApiModelProperty("文件大小")
    @NotBlank(message = "文件大小不能为null")
    private String fileSize;

}
