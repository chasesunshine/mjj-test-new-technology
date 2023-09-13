package org.dongfu.study.allDesignMode.behaviorMode.templateMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dongfu.study.allDesignMode.behaviorMode.templateMode.common.NetMall;
import org.dongfu.study.allDesignMode.behaviorMode.templateMode.group.JDNetMall;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 13:15
* @version 1.0
*/

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("测试结果：{}", base64);
    }
}
