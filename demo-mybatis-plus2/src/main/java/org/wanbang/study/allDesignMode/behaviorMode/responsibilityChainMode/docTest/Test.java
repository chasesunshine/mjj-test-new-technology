package org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.entity.AuthLink;
import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.service.AuthService;
import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.service.impl.Level1AuthLink;
import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.service.impl.Level2AuthLink;
import org.wanbang.study.allDesignMode.behaviorMode.responsibilityChainMode.docTest.service.impl.Level3AuthLink;

import java.text.ParseException;
import java.util.Date;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/18 18:09
 * @version 1.0
 */

@Slf4j
public class Test {
    public static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws ParseException {
//        AuthLink appendNext = new Level2AuthLink("1000012", "张经理");
//        appendNext.appendNext(new Level1AuthLink("1000011", "段总"));
//
//        AuthLink authLink = new Level3AuthLink( "1000013", "王⼯" );
//        authLink.appendNext(appendNext);


        AuthLink authLink = new Level3AuthLink( "1000013", "王⼯" )
                .appendNext( new Level2AuthLink("1000012", "张经理")
                        .appendNext( new Level1AuthLink("1000011", "段总") )
                );
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("⼩傅哥", "1000998004813441", new Date())));

        // 模拟三级负责⼈审批
        AuthService.auth("1000013", "1000998004813441");
        logger.info("测试结果：{}", "模拟三级负责⼈审批，王⼯");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("⼩傅哥", "1000998004813441", new Date())));

        // 模拟⼆级负责⼈审批
        AuthService.auth("1000012", "1000998004813441");
        logger.info("测试结果：{}", "模拟⼆级负责⼈审批，张经理");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("⼩傅哥", "1000998004813441", new Date())));

        // 模拟⼀级负责⼈审批
        AuthService.auth("1000011", "1000998004813441");
        logger.info("测试结果：{}", "模拟⼀级负责⼈审批，段总");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("⼩傅哥", "1000998004813441", new Date())));

    }
}
