package com.example.log.collection.serive1.job;

import com.example.log.collection.serive1.api.service2.DemoApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author :XXX
 * @date :2021-02-08 11:26
 * @description :
 */
@Component
@Slf4j
public class TestJob {

    @Autowired
    private DemoApiClient demoApiClient;

    @Scheduled(fixedRate = 2000)
    public void execute() {
        List<String> result = demoApiClient.getlist2();
        log.info("定时任务执行 打印获取数据结果 {} ", result);

    }


}