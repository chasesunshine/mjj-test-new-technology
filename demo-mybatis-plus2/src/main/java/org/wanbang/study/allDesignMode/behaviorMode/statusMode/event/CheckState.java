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
public class CheckState extends State {

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "待审核状态不可重复提审");
    }

    @Override
    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Pass);
        return new Result("0000", "活动审核通过完成");
    }

    @Override
    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Refuse);
        return new Result("0000", "活动审核拒绝完成");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Editing);
        return new Result("0000", "活动审核撤销回到编辑中");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "活动审核关闭完成");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "非关闭活动不可开启");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "待审核活动不可执行活动中变更");
    }

}
