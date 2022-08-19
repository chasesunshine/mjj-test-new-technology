package org.wanbang.study.allDesignMode.behaviorMode.observerMode.service.impl;

import org.wanbang.study.allDesignMode.behaviorMode.observerMode.entity.LotteryResult;
import org.wanbang.study.allDesignMode.behaviorMode.observerMode.service.LotteryService;
import org.wanbang.study.allDesignMode.behaviorMode.observerMode.service.MinibusTargetService;

import java.util.Date;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 15:22
* @version 1.0
*/

/**
 * 业务接⼝实现类
 */
public class LotteryServiceImpl extends LotteryService {
    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    public LotteryServiceImpl(){
        System.out.println("子类");
    }

    @Override
    protected LotteryResult doDraw(String uId) {
        // 摇号
        String lottery = minibusTargetService.lottery(uId);

        // 结果
        LotteryResult lotteryResult = new LotteryResult(uId, lottery, new Date());
        return lotteryResult;
    }
}
