package org.dongfu.study.allDesignMode.behaviorMode.memorandumMode.design;

import lombok.Data;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/19 14:55
 * @version 1.0
 */

/**
 *
 * 记录者类
 * 除了对 ConfigFile 配置类增加了获取和设置⽅法外，还增加了保存 saveMemento() 、
 * 获取 getMemento(ConfigMemento memento) 。
 * saveMemento ：保存备忘录的时候会创建⼀个备忘录信息，并返回回去，交给管理者处理。
 * getMemento ：获取的之后并不是直接返回，⽽是把备忘录的信息交给现在的配置⽂件
 * this.configFile ，这部分需要注意
 *
 */
@Data
public class ConfigOriginator {
    private ConfigFile configFile;

    public ConfigMemento saveMemento(){
        return new ConfigMemento(configFile);
    }

    public void getMemento(ConfigMemento memento){
        this.configFile = memento.getConfigFile();
    }

}