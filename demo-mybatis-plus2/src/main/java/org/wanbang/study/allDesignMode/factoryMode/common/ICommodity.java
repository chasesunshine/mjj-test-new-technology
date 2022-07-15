package org.wanbang.study.allDesignMode.factoryMode.common;

import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/7/15 16:45
* @version 1.0
*/

public interface ICommodity {
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
