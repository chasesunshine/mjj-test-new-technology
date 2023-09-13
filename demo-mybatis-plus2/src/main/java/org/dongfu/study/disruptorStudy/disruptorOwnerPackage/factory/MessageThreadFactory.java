package org.dongfu.study.disruptorStudy.disruptorOwnerPackage.factory;
/**
* @description: 消费者线程工厂类
* @author majiajian
* @date 2022/8/29 13:39
* @version 1.0
*/

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;

@Slf4j
public class MessageThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        log.info("消费者线程工厂类  \n");
        return new Thread(r,"Simple Disruptor Test Thread");
    }

}
