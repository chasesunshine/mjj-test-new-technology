package org.wanbang.study.disruptorStudy.disruptorOwnerPackage.operateutils;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.stereotype.Component;
import org.wanbang.study.disruptorStudy.disruptorOwnerPackage.event.MessageEventOwner;
import org.wanbang.study.disruptorStudy.disruptorOwnerPackage.translate.MessageEventTranslator;

import javax.annotation.Resource;

/**
* @description: Disruptor 操作类
* @author majiajian
* @date 2022/8/29 15:02
* @version 1.0
*/

@Component
public class DisruptorOperate {
    @Resource
    private Disruptor disruptor;

    /**
     * 推送消息
     *
     * @param messsge
     */
    public void publishEvent(String messsge){
        RingBuffer ringBuffer;
        try {
            // 判断 disruptor 是否启动
            ringBuffer = disruptor.start();
        }catch (Exception e ){
            // 获取 初始化完成的  RingBuffer 对象
            ringBuffer = disruptor.getRingBuffer();
        }

        // 将接收到的消息输出到ringBuffer
        EventTranslatorOneArg<MessageEventOwner,String> translator = new MessageEventTranslator();
        ringBuffer.publishEvent(translator,messsge);
    }

    public void shutDown(){
        disruptor.shutdown();
    }

}
