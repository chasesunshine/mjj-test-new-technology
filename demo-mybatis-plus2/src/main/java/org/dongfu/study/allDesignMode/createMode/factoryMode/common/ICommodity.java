package org.dongfu.study.allDesignMode.createMode.factoryMode.common;

import java.util.Map;

/**
* @description: 通用接口
* @author majiajian
* @date 2022/7/15 16:45
* @version 1.0
*/

/**
 * 从上⾯可以看到每⼀种奖品的实现都包括在⾃⼰的类中，新增、修改或者删除都不会影响其他奖品
 * 功能的测试，降低回归测试的可能。
 * 后续在新增的奖品只需要按照此结构进⾏填充即可，⾮常易于维护和扩展。
 * 在统⼀了⼊参以及出参后，调⽤⽅不在需要关⼼奖品发放的内部逻辑，按照统⼀的⽅式即可处理
 */
public interface ICommodity {
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}
