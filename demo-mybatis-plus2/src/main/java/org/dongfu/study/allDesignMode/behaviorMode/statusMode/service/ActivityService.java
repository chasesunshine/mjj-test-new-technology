package org.dongfu.study.allDesignMode.behaviorMode.statusMode.service;

import org.dongfu.study.allDesignMode.behaviorMode.statusMode.entity.ActivityInfo;
import org.dongfu.study.allDesignMode.behaviorMode.statusMode.enums.Status;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Date;

/**
 * 类名称:ActivityService
 * 类描述:  活动服务业务类
 *
 * 创建时间:2022/4/3 10:34
 */
public class ActivityService {

    private static Map<String, Enum<Status>> statusMap = new ConcurrentHashMap<>();

    // 初始化活动信息
    public static void init(String activityId, Enum<Status> status) {
        // 模拟活动信息
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("早起学习打卡领奖活动");
        activityInfo.setStatus(status);
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        statusMap.put(activityId, status);
    }

    // 查询活动信息
    public static ActivityInfo queryActivityInfo(String activityId){
        // 模拟查询活动信息
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("早起学习打卡领奖活动");
        activityInfo.setStatus(statusMap.get(activityId));
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        return activityInfo;
    }

    public static Enum<Status> queryActivityStatus(String activityId) {
        return statusMap.get(activityId);
    }

    /**
     *  执行状态变更
     * @param activityId
     * @param beforeStatus
     * @param afterStatus
     */
    public static synchronized void execStatus(String activityId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {
        if (!beforeStatus.equals(statusMap.get(activityId))) return;
        statusMap.put(activityId, afterStatus);
    }
}