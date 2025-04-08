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
public class SpecificationManageUploadDTO {

    /**
     * OBS文件url
     */
    @ApiModelProperty("OBS文件url")
    private String fileUrl;

    /**
     * OBS文件ObjectKey
     */
    @ApiModelProperty("OBS文件ObjectKey")
    private String fileObjectKey;

    /**
     * 文件大小
     */
    @ApiModelProperty("文件大小")
    private String fileSize;

}
