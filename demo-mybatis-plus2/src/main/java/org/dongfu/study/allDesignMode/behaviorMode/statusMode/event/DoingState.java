package org.dongfu.study.allDesignMode.behaviorMode.statusMode.event;

import org.dongfu.study.allDesignMode.behaviorMode.statusMode.enums.Status;
import org.dongfu.study.allDesignMode.behaviorMode.statusMode.handler.Result;
import org.dongfu.study.allDesignMode.behaviorMode.statusMode.handler.State;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/23 20:17
* @version 1.0
*/
public class DoingState extends State {

    @Override
    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return null;
    }

    @Override
    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return null;
    }

    @Override
    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return null;
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return null;
    }

    @Override
    public Result close(String activityId, Enum<Status> currentStatus) {
        return null;
    }

    @Override
    public Result open(String activityId, Enum<Status> currentStatus) {
        return null;
    }

    @Override
    public Result doing(String activityId, Enum<Status> currentStatus) {
        return null;
    }

}
