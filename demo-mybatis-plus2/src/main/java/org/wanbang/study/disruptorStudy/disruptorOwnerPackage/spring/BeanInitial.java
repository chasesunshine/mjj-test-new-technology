package org.wanbang.study.disruptorStudy.disruptorOwnerPackage.spring;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wanbang.study.disruptorStudy.disruptorOwnerPackage.event.MessageEventOwner;
import org.wanbang.study.disruptorStudy.disruptorOwnerPackage.factory.MessageEventFactory;
import org.wanbang.study.disruptorStudy.disruptorOwnerPackage.factory.MessageThreadFactory;
import org.wanbang.study.disruptorStudy.disruptorOwnerPackage.handler.MessageEventHandler;
import org.wanbang.study.disruptorStudy.disruptorOwnerPackage.handler.MessageExceptionHandler;


/**
* @description: TODO
* @author majiajian
* @date 2022/8/29 14:19
* @version 1.0
*/

@Configuration
public class BeanInitial {

    @Bean
    public Disruptor<MessageEventOwner> getDisruptor(){
        //必须是2的N次方
        int ringBufferSize = 8;

        Disruptor<MessageEventOwner> disruptor = new Disruptor<>(
                new MessageEventFactory(),
                ringBufferSize,
                new MessageThreadFactory(),

                ProducerType.SINGLE,
                new BlockingWaitStrategy()
        );

        // 设置 - 消息事件处理类
        disruptor.handleEventsWith(new MessageEventHandler());

        // 设置 异常处理类
        disruptor.setDefaultExceptionHandler(new MessageExceptionHandler());

        // 启动disruptor
        disruptor.start();

        return disruptor;
    }

}
