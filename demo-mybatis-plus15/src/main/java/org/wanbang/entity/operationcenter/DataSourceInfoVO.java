package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 家庭管理列表 获取所有房间信息 出参 - 2.5
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DataSourceInfoVO {

    /**
     * 数据来源（加在dc_device表）
     */
    @ApiModelProperty("数据来源")
    private Integer dataSource;

    /**
     * 数据来源名称（加在dc_device表）
     */
    @ApiModelProperty("数据来源名称")
    private String dataSourceName;

}
