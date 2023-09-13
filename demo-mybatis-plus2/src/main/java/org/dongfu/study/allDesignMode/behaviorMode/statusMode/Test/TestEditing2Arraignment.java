package org.dongfu.study.allDesignMode.behaviorMode.statusMode.Test;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dongfu.study.allDesignMode.behaviorMode.statusMode.enums.Status;
import org.dongfu.study.allDesignMode.behaviorMode.statusMode.handler.Result;
import org.dongfu.study.allDesignMode.behaviorMode.statusMode.handler.StateHandler;
import org.dongfu.study.allDesignMode.behaviorMode.statusMode.service.ActivityService;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/23 20:14
* @version 1.0
*/
public class TestEditing2Arraignment {
    private static Logger logger = LoggerFactory.getLogger(TestEditing2Arraignment.class);

    public static void main(String[] args) {
        String activityId = "100001";
        ActivityService.init(activityId, Status.Editing);
        StateHandler stateHandler = new StateHandler();
        Result result = stateHandler.arraignment(activityId, Status.Editing);

        logger.info("测试结果(编辑中To提审活动)：{}", JSON.toJSONString(result));
        logger.info("活动信息：{} 状态：{}", JSON.toJSONString(ActivityService.queryActivityInfo(activityId)), JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));

    }
}
