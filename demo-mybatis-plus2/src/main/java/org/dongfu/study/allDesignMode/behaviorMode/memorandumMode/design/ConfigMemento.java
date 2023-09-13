package org.dongfu.study.allDesignMode.behaviorMode.memorandumMode.design;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 14:55
* @version 1.0
*/

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * 备忘录
 * 是对原有配置类的扩展，可以设置和获取配置信息。
 *
 */
@Data
@AllArgsConstructor
public class ConfigMemento {
    private ConfigFile configFile;
}
