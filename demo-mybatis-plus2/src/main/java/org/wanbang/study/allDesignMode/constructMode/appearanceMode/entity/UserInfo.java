package org.wanbang.study.allDesignMode.constructMode.appearanceMode.entity;

import lombok.Data;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/12 20:01
* @version 1.0
*/

@Data
public class UserInfo {
    private String userId;

    private Integer age;

    private String address;

    public UserInfo(String userId, int age, String address) {
        this.userId = userId;
        this.age = age;
        this.address = address;
    }
}
