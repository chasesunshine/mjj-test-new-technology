package org.dongfu.study.allDesignMode.behaviorMode.iteratorMode.group;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 13:47
* @version 1.0
*/

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 雇员
 */
@Data
@AllArgsConstructor
public class Employee {
    private String uId; // ID
    private String name; // 姓名
    private String desc; // 备注

    // ...get/set
}
