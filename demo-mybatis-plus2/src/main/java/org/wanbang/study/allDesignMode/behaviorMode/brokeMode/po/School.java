package org.wanbang.study.allDesignMode.behaviorMode.brokeMode.po;

import lombok.Data;

import java.util.Date;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 14:05
* @version 1.0
*/

@Data
public class School {
    private Long id;
    private String name;
    private String address;
    private Date createTime;
    private Date updateTime;

    // ... get/set
}
