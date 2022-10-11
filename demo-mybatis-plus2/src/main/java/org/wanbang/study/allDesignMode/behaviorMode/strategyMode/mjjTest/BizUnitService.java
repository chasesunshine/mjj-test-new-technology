package org.wanbang.study.allDesignMode.behaviorMode.strategyMode.mjjTest;

import org.springframework.stereotype.Service;

/**
 * 提供业务逻辑单元
 */
@Service
public class BizUnitService {

    public Object bizOne(Object order) {
        return order + "各种花式操作1";
    }

    public Object bizTwo(Object order) {
        return order + "各种花式操作2";
    }

    public Object bizThree(Object order) {
        return order + "各种花式操作3";
    }
}
