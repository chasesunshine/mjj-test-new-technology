package com.dt.biz.controller;

import com.dt.biz.util.KafkaUtils;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * kafka控制器
 */
@RestController
@RequestMapping("/rest")
public class KafkaController {
    @Autowired
    private KafkaUtils KafkaUtils;

    private final static String TOPIC_NAME = "test";
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/kafka/send")
    public void send() {
        Date date = new Date();
        System.out.println("发送时间：=================" + date);
        kafkaTemplate.send(TOPIC_NAME, "msg:" + date);
    }

    /**
     * 生产者往topic中发送消息demo
     *
     * @param topic
     * @param message
     */
    @PostMapping("kafka/message")
    public void sendMessage(String topic, String message) {
        KafkaUtils.sendMessage(topic, message);
    }

    /**
     * 消费者示例demo
     * <p>
     * 基于注解监听多个topic，消费topic中消息
     * （注意：如果监听的topic不存在则会自动创建）
     */
    @KafkaListener(topics = {"test"})
    public void consume(String message) {
        System.out.println("receive msg: " + message);
    }

    /**
     * 查询topic信息 (支持批量，这里就单个作为演示)
     */
    @PostMapping("/kafka/all")
    public void getAllTopics() {
        List<String> allTopics = KafkaUtils.getAllTopic();
        for (String s : allTopics) {
            System.out.println("getAllTopics:" + s);
        }
    }

    /*
     * 新增topic (支持批量，这里就单个作为演示)
     *
     * @param topic topic
     * @return ResponseVo
     */
    @PostMapping("/newTopic")
    public void add(String topic) {
        NewTopic newTopic = new NewTopic(topic, 1, (short) 1);
        List<NewTopic> list2 = new ArrayList<NewTopic>();
        list2.add(newTopic);
        KafkaUtils.createTopic(list2);
    }

    /**
     * 删除topic (支持批量，这里就单个作为演示)
     * (注意：如果topic正在被监听会给人感觉删除不掉（但其实是删除掉后又会被创建）)
     *
     * @param topic topic
     */
    @DeleteMapping("kafka/{topic}")
    public void delete(@PathVariable String topic) {
        List<String> deleteTopicList = new ArrayList<String>();
        deleteTopicList.add(topic);
        KafkaUtils.deleteTopic(deleteTopicList);
    }

}

