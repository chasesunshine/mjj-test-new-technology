package org.wanbang.entity.operationcenter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

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
public class SpecificationManageListVO implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long id;

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
    @JsonProperty("pId")
    private Long pId;

    /**
     * 分类id
     */
    @ApiModelProperty("分类id")
    private Long categoryId;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;

    /**
     * 产品型号
     */
    @ApiModelProperty(value = "产品型号")
    private String model;

    /**
     * obs文件url
     */
    @ApiModelProperty("obs文件url")
    private String realFileUrl;

    /**
     * 文件url
     */
    @ApiModelProperty("文件url")
    private String fileUrl;

    /**
     * 文件大小
     */
    @ApiModelProperty("文件大小")
    private String fileSize;

    /**
     * 文件名称
     */
    @ApiModelProperty("文件名称")
    private String fileName;

    /**
     * obs二维码图片地址
     */
    @ApiModelProperty("obs二维码图片地址")
    private String realPicUrl;

    /**
     * 二维码图片地址
     */
    @ApiModelProperty("二维码图片地址")
    private String picUrl;

    /**
     * 最新发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("最新发布时间")
    private Date lastReleaseTime;

    /**
     * 状态 0：草稿 1：已发布
     */
    @ApiModelProperty("状态 0：草稿 1：已发布")
    private Integer status;
}
