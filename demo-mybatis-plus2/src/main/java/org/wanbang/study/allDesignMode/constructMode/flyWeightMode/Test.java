package org.wanbang.study.allDesignMode.constructMode.flyWeightMode;

import com.alibaba.fastjson.JSON;
import org.wanbang.study.allDesignMode.constructMode.flyWeightMode.controller.ActivityController;
import org.wanbang.study.allDesignMode.constructMode.flyWeightMode.entity.Activity;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/17 17:41
 * @version 1.0
 */

/**
 * 可以仔细看下 stock 部分的库存是⼀直在变化的，其他部分是活动信息，是固定的，所以我们使
 * ⽤享元模式来将这样的结构进⾏拆分
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        ActivityController activityController = new ActivityController();
        for (int idx = 0; idx < 10; idx++) {
            Long req = 10001L;
            Activity activity = activityController.queryActivityInfo(req);
            System.out.println("测试结果："+"req "+ JSON.toJSONString(activity));
            Thread.sleep(1200);
        }

    }

}
