package org.wanbang.study.allDesignMode.behaviorMode.statusMode.event;

import org.wanbang.study.allDesignMode.behaviorMode.statusMode.enums.Status;
import org.wanbang.study.allDesignMode.behaviorMode.statusMode.handler.Result;
import org.wanbang.study.allDesignMode.behaviorMode.statusMode.handler.State;
import org.wanbang.study.allDesignMode.behaviorMode.statusMode.service.ActivityService;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/23 20:17
 * @version 1.0
 */
public class CloseState extends State {

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可提审");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可审核通过");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可审核拒绝");
    }

    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可撤销审核");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可重复关闭");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Open);
        return new Result("0000", "活动开启完成");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可变更活动中");
    }
}