package org.wanbang.study.allDesignMode.behaviorMode.statusMode.event;
/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/23 20:18
 * @version 1.0
 */

import org.wanbang.study.allDesignMode.behaviorMode.statusMode.enums.Status;
import org.wanbang.study.allDesignMode.behaviorMode.statusMode.handler.Result;
import org.wanbang.study.allDesignMode.behaviorMode.statusMode.handler.State;
import org.wanbang.study.allDesignMode.behaviorMode.statusMode.service.ActivityService;

public class EditingState extends State {

    @Override
    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        // 活动编辑状态 变为提审状态
        ActivityService.execStatus(activityId, currentStatus, Status.Check);
        return new Result("0000", "活动提审成功");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中不可审核通过");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中不可审核拒绝");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中不可撤销审核");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "活动关闭成功");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "非关闭活动不可开启");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "编辑中活动不可执行活动中变更");
    }
}