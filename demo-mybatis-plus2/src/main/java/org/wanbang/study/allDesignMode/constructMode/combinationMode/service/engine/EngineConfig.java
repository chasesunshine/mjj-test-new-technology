package org.wanbang.study.allDesignMode.constructMode.combinationMode.service.engine;

import org.wanbang.study.allDesignMode.constructMode.combinationMode.service.logic.LogicFilter;
import org.wanbang.study.allDesignMode.constructMode.combinationMode.service.logic.impl.UserAgeFilter;
import org.wanbang.study.allDesignMode.constructMode.combinationMode.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/11 20:23
* @version 1.0
*/

public class EngineConfig {
    static Map<String, LogicFilter> logicFilterMap;
    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }
    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }
    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        this.logicFilterMap = logicFilterMap;
    }
}
