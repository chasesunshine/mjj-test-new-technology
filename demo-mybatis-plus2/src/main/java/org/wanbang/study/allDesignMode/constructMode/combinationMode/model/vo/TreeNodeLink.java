package org.wanbang.study.allDesignMode.constructMode.combinationMode.model.vo;

import lombok.Data;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/11 20:19
 * @version 1.0
 */

@Data
public class TreeNodeLink {
    private Long nodeIdFrom;

    private Long nodeIdTo;

    private Integer ruleLimitType;

    private String ruleLimitValue;
}
