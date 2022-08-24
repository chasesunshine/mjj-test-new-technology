package org.wanbang.study.allDesignMode.behaviorMode.statusMode.Test;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.behaviorMode.statusMode.enums.Status;
import org.wanbang.study.allDesignMode.behaviorMode.statusMode.handler.Result;
import org.wanbang.study.allDesignMode.behaviorMode.statusMode.handler.StateHandler;
import org.wanbang.study.allDesignMode.behaviorMode.statusMode.service.ActivityService;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/24 10:47
* @version 1.0
*/

public class TestRefuse2Revoke {
    private static Logger logger = LoggerFactory.getLogger(TestRefuse2Revoke.class);

    public static void main(String[] args) {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Refuse);
        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.checkRevoke(activityId, Status.Refuse);
        logger.info("测试结果(拒绝To撤审)：{}", JSON.toJSONString(result));
        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
    }
}
