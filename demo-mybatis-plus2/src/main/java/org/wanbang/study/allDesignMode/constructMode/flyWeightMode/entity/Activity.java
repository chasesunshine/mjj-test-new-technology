package org.wanbang.study.allDesignMode.constructMode.flyWeightMode.entity;

import lombok.Data;
import org.wanbang.study.allDesignMode.constructMode.flyWeightMode.design.Stock;

import java.util.Date;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/17 17:53
* @version 1.0
*/

@Data
public class Activity {
    private Long id; // 活动ID
    private String name; // 活动名称
    private String desc; // 活动描述
    private Date startTime; // 开始时间
    private Date stopTime; // 结束时间
    private Stock stock; // 活动库存

    // ...get/set
}
