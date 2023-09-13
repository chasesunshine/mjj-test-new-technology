package org.dongfu.study.allDesignMode.constructMode.flyWeightMode.design;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/17 17:54
* @version 1.0
*/

import org.dongfu.study.allDesignMode.constructMode.flyWeightMode.entity.Activity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成⻓，让⾃⼰和他⼈都能有所收获！
 * 公众号：bugstack⾍洞栈
 * Create by ⼩傅哥(fustack) @2020
 */

/**
 * 这⾥提供的是⼀个享元⼯⼚ ，通过 map 结构存放已经从库表或者接⼝中查询到的数据，存放到
 * 内存中，⽤于下次可以直接获取。
 * 这样的结构⼀般在我们的编程开发中还是⽐较常⻅的，当然也有些时候为了分布式的获取，会把数
 * 据存放到redis中，可以按需选择。
 *
 */
public class ActivityFactory {
    static Map<Long, Activity> activityMap = new HashMap<Long, Activity>();

    public static Activity getActivity(Long id) {
        Activity activity = activityMap.get(id);

        if (null == activity) {
            // 模拟从实际业务应⽤从接⼝中获取活动信息
            activity = new Activity();
            activity.setId(10001L);
            activity.setName("图书嗨乐");
            activity.setDesc("图书优惠券分享激励分享活动第⼆期");
            activity.setStartTime(new Date());
            activity.setStopTime(new Date());
            activityMap.put(id, activity);
        }

        return activity;
    }
}
