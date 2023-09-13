package org.dongfu.study.allDesignMode.behaviorMode.memorandumMode;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dongfu.study.allDesignMode.behaviorMode.memorandumMode.design.Admin;
import org.dongfu.study.allDesignMode.behaviorMode.memorandumMode.design.ConfigFile;
import org.dongfu.study.allDesignMode.behaviorMode.memorandumMode.design.ConfigOriginator;

import java.util.Date;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/19 14:53
 * @version 1.0
 */

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        Admin admin = new Admin();
        ConfigOriginator configOriginator = new ConfigOriginator();

        configOriginator.setConfigFile(new ConfigFile("1000001", "配置内容A=哈哈", new Date(), "⼩傅哥"));
        admin.append(configOriginator.saveMemento()); // 保存配置

        configOriginator.setConfigFile(new ConfigFile("1000002", "配置内容A=嘻嘻", new Date(), "⼩傅哥"));
        admin.append(configOriginator.saveMemento()); // 保存配置

        configOriginator.setConfigFile(new ConfigFile("1000003", "配置内容A=么么", new Date(), "⼩傅哥"));
        admin.append(configOriginator.saveMemento()); // 保存配置

        configOriginator.setConfigFile(new ConfigFile("1000004", "配置内容A=嘿嘿", new Date(), "⼩傅哥"));
        admin.append(configOriginator.saveMemento()); // 保存配置


        // 历史配置(回滚)
        configOriginator.getMemento(admin.undo());
        logger.info("历史配置(回滚) undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置(回滚)
        configOriginator.getMemento(admin.undo());
        logger.info("历史配置(回滚) undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置(前进)
        configOriginator.getMemento(admin.redo());
        logger.info("历史配置(前进) redo：{}", JSON.toJSONString(configOriginator.getConfigFile()));

        // 历史配置(获取)
        configOriginator.getMemento(admin.get("1000002"));
        logger.info("历史配置(获取) get：{}", JSON.toJSONString(configOriginator.getConfigFile()));
    }
}
