package org.dongfu.study.disruptorStudy.disruptor3Main;

import com.lmax.disruptor.RingBuffer;
import org.dongfu.study.disruptorStudy.disruptor3Main.event.MessageEvent;

import java.util.HashMap;

public class ThreadLocalDisruptor {
    private static ThreadLocal< HashMap<Object,RingBuffer<MessageEvent>>  > threadLocal = new ThreadLocal<>();

    public static void setRingBuffer(Object t){
        HashMap<Object, RingBuffer<MessageEvent>> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("ringBuffer",(RingBuffer<MessageEvent>) t);
        threadLocal.set(objectObjectHashMap);
    }

    public static RingBuffer<MessageEvent> getRingBuffer(){
        HashMap<Object, RingBuffer<MessageEvent>> objectRingBufferHashMap = threadLocal.get();
        return objectRingBufferHashMap.get("ringBuffer");
    }
}
