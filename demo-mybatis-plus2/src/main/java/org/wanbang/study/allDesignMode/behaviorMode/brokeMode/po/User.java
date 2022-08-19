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
public class User {
    private Long id;
    private String name;
    private Integer age;
    private Date createTime;
    private Date updateTime;

    // ... get/set
}
