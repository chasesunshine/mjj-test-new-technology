package org.wanbang.study.disruptorStudy.disruptor2.util;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

// Event
@Data
public class Trade {

    private String id;//ID
    private String name;
    private double price;//金额
    private AtomicInteger count = new AtomicInteger(0);

    // 省略getter/setter
}
