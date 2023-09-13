package org.dongfu.study.allDesignMode.behaviorMode.iteratorMode.group;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 13:49
* @version 1.0
*/

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 树节点链路
 */
@Data
@AllArgsConstructor
public class Link {
    private String fromId; // 雇员ID
    private String toId; // 雇员ID

    // ...get/set
}