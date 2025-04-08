package org.wanbang.entity.operationcenter;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 家庭管理列表 家庭成员 出参 - 2.5
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HomeManageListDetailMemberVO {

    /**
     * 用户id（管理员账号）
     */
    @ApiModelProperty(value = "用户id（管理员账号）")
    private String nlcId;

    /**
     * 0-普通账号 1-管理员账号
     */
    @ApiModelProperty(value = "0-普通账号 1-管理员账号")
    private Integer managerFlag;

}
