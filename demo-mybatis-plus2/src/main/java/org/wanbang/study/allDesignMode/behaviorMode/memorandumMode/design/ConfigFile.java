package org.wanbang.study.allDesignMode.behaviorMode.memorandumMode.design;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 14:55
* @version 1.0
*/

/**
 *
 * 配置类
 * 可以是任何形式的，这⾥只是简单的描述了⼀个基本的配置内容信息。
 *
 */
@Data
@AllArgsConstructor
public class ConfigFile {
    private String versionNo; // 版本号
    private String content; // 内容
    private Date dateTime; // 时间
    private String operator; // 操作⼈
}
