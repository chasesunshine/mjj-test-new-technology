package org.wanbang.entity.operationcenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 家庭管理列表 设备信息 出参 - 2.5
 *
 * @author majiajian
 * @date 2024/07/10 11:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HomeManageBelongHomeInfoVO {
    /**
     * 家庭id
     */
    private Long homeId;

    /**
     * 家庭名称
     */
    private String homeName;
}
