package org.dongfu.study.allDesignMode.behaviorMode.observerMode.service;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 15:28
* @version 1.0
*/

/**
 * ⾮常简单的⼀个模拟摇号接⼝，与真实公平的摇号是有差别的。
 */
public class MinibusTargetService {

    /**
     * 模拟摇号，但不是摇号算法
     *
     * @param uId ⽤户编号
     * @return 结果
     */
    public String lottery(String uId) {
        return Math.abs(uId.hashCode()) % 2 == 0 ?
                "恭喜你，编码".concat(uId).concat("在本次摇号中签")
                : "很遗憾，编码".concat(uId).concat("在本次摇号未中签或摇号资格已过期");
    }

}

