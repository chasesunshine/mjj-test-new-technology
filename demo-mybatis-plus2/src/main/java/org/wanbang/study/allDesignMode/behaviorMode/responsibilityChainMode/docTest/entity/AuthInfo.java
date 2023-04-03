package org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.entity;

import lombok.Data;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/18 18:03
* @version 1.0
*/

/**
 *
 * 这个类的是包装了责任链处理过程中返回结果的类，⽅⾯处理每个责任链的返回信息
 *
 */
@Data
public class AuthInfo {
    private String code;
    private String info = "";

    public AuthInfo(String code, String ...infos) {
        this.code = code;
        for (String str:infos){
            this.info = this.info.concat(str);
        }
    }

    // ...get/set
}
