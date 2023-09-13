package org.dongfu.study.allDesignMode.constructMode.bridgeMode.common;
/**
* @description: 定义⽀付模式接⼝
* @author majiajian
* @date 2022/8/11 17:05
* @version 1.0
*/

/**
 * 任何⼀个⽀付模式；刷脸、指纹、密码，都会过不同程度的安全⻛控，这⾥定义⼀个安全校验接⼝
 *
 */
public interface IPayMode {
    boolean security(String uId);
}