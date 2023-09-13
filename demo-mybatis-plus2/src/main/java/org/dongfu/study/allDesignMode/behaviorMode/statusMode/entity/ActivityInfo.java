package org.dongfu.study.allDesignMode.behaviorMode.statusMode.entity;

import lombok.Data;
import org.dongfu.study.allDesignMode.behaviorMode.statusMode.enums.Status;
import java.util.Date;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/23 20:26
* @version 1.0
*/
@Data
public class ActivityInfo {

    private String activityId; // 活动ID

    private String activityName; // 活动名称

    private Enum<Status> status; // 活动状态

    private Date beginTime; // 开始时间

    private Date endTime; // 结束时间

}

