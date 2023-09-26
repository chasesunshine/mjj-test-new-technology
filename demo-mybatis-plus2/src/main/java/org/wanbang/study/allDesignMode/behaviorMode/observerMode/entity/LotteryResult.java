package org.wanbang.study.allDesignMode.behaviorMode.observerMode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/19 15:22
 * @version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LotteryResult {
    private String uId;

    private String msg;

    private Date dateTime;

}
