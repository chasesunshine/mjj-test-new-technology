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
public class OpenState extends State {

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可提审");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可审核通过");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可审核拒绝");
    }

    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动开启不可撤销审核");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Close);
        return new Result("0000", "活动关闭完成");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动不可重复开启");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.Doing);
        return new Result("0000", "活动变更活动中完成");
    }
}