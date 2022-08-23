package org.wanbang.study.allDesignMode.behaviorMode.statusMode;

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
* @date 2022/8/23 20:14
* @version 1.0
*/

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);
        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.arraignment(activityId, Status.Editing);
        logger.info("测试结果(编辑中To提审活动)：{}", JSON.toJSONString(result));
        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));

    }
}
