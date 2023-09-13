package org.dongfu.study.allDesignMode.behaviorMode.statusMode.event;

import org.dongfu.study.allDesignMode.behaviorMode.statusMode.enums.Status;
import org.dongfu.study.allDesignMode.behaviorMode.statusMode.handler.Result;
import org.dongfu.study.allDesignMode.behaviorMode.statusMode.handler.State;
import org.dongfu.study.allDesignMode.behaviorMode.statusMode.service.ActivityService;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/23 20:18
 * @version 1.0
 */
public class PassState extends State {

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "已审核状态不可重复提审");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "已审核状态不可重复审核");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Refuse);
        return new Result("0000", "活动审核拒绝完成");
    }

    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "审核通过不可撤销(可先拒绝审核)");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "活动审核关闭完成");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "非关闭活动不可开启");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Doing);
        return new Result("0000", "活动变更活动中完成");
    }

}
