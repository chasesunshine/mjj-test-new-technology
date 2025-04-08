package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
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
public class HomeManageListDTO{

    /**
     * 家庭id
     */
    @ApiModelProperty(value = "家庭id")
    private String homeId;

    /**
     * 家庭名称
     */
    @ApiModelProperty(value = "家庭名称")
    private String homeName;

    /**
     * 用户id（管理员账号）
     */
    @ApiModelProperty(value = "用户id（管理员账号）")
    private String nlcId;

    /**
     * 家庭地址
     */
    @ApiModelProperty(value = "家庭地址")
    private String homeAddress;
}
