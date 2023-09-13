package org.dongfu.study.allDesignMode.behaviorMode.visitorMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dongfu.study.allDesignMode.behaviorMode.visitorMode.common.DataView;
import org.dongfu.study.allDesignMode.behaviorMode.visitorMode.visitor.impl.Parent;
import org.dongfu.study.allDesignMode.behaviorMode.visitorMode.visitor.impl.Principal;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 13:30
* @version 1.0
*/
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        DataView dataView = new DataView();

        logger.info("\r\n家⻓视⻆访问：");
        dataView.show(new Parent()); // 家⻓

        logger.info("\n");

        logger.info("\r\n校⻓视⻆访问：");
        dataView.show(new Principal()); // 校⻓
    }
}
