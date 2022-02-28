package org.wanbang.study.disruptorStudy.disruptor3Main;

import com.lmax.disruptor.RingBuffer;

import java.util.HashMap;

public class ThreadLocalDisruptor {
    private static ThreadLocal< HashMap<Object,RingBuffer<DisruptorTest.MessageEvent>>  > threadLocal = new ThreadLocal<>();

    public static void setRingBuffer(Object t){
        HashMap<Object, RingBuffer<DisruptorTest.MessageEvent>> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("ringBuffer",(RingBuffer<DisruptorTest.MessageEvent>) t);
        threadLocal.set(objectObjectHashMap);
    }

    public static RingBuffer<DisruptorTest.MessageEvent> getRingBuffer(){
        HashMap<Object, RingBuffer<DisruptorTest.MessageEvent>> objectRingBufferHashMap = threadLocal.get();
        return objectRingBufferHashMap.get("ringBuffer");
    }
}
