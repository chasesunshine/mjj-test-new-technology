package org.dongfu.study.allDesignMode.behaviorMode.brokeMode.mediator;

import lombok.Data;
import org.dongfu.study.allDesignMode.behaviorMode.brokeMode.mapper.XNode;

import java.sql.Connection;
import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 14:03
* @version 1.0
*/

@Data
public class Configuration {

    protected Connection connection;
    protected Map<String, String> dataSource;
    protected Map<String, XNode> mapperElement;

}