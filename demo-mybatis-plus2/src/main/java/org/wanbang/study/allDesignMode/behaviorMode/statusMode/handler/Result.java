package org.wanbang.study.allDesignMode.behaviorMode.statusMode.handler;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/23 20:18
* @version 1.0
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类名称:Result
 * 类描述:执行结果
 *
 * 创建时间:2022/4/3 10:51
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {

    // 编码
    private String code;
    // 描述
    private String info;
}