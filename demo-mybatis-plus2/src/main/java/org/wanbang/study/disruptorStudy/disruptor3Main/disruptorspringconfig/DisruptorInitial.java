package org.wanbang.study.disruptorStudy.disruptor3Main.disruptorspringconfig;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wanbang.study.disruptorStudy.disruptor3Main.event.MessageEvent;
import org.wanbang.study.disruptorStudy.disruptor3Main.factory.MessageEventFactory;
import org.wanbang.study.disruptorStudy.disruptor3Main.factory.MessageThreadFactory;
import org.wanbang.study.disruptorStudy.disruptor3Main.handler.MessageEventHandler;
import org.wanbang.study.disruptorStudy.disruptor3Main.handler.MessageExceptionHandler;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/29 14:19
* @version 1.0
*/

@Configuration
public class DisruptorInitial {

    @Bean
    public Disruptor<MessageEvent> getDisruptor(){
        //必须是2的N次方
        int ringBufferSize = 8;

        Disruptor<MessageEvent> disruptor = new Disruptor<>(
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

        return disruptor;
    }

}
