package com.dt.biz.demo;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.TopicPartitionInfo;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 不用spring容器管理
 */
public class KafkaDemo {
    private AdminClient adminClient;

    @Resource
    private KafkaTemplate<String,Object> kafkaTemplate;

    /**
     * 获得kafka操作句柄
     */
    private void initAdminClient() {
        Map<String, Object> props = new HashMap<>(1);
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.56.1:9092");
        adminClient = KafkaAdminClient.create(props);
        System.out.println("adminClient " + adminClient);
    }

    /**
     * 新增topic，支持批量
     */
    public void createTopic(Collection<NewTopic> newTopics) {
        adminClient.createTopics(newTopics);
    }

    /**
     * 删除topic，支持批量
     */
    public void deleteTopic(Collection<String> topics) {
        adminClient.deleteTopics(topics);
    }

    /**
     * 获取指定topic的信息
     */
    public String getTopicInfo(Collection<String> topics) {
        AtomicReference<String> info = new AtomicReference<>("");
        try {
            adminClient.describeTopics(topics).all().get().forEach((topic, description) -> {
                for (TopicPartitionInfo partition : description.partitions()) {
                    info.set(info + partition.toString() + "\n");
                }
            });
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return info.get();
    }

    /**
     * 获取全部topic
     */
    public List<String> getAllTopic() {
        try {
            List<String> list = adminClient.listTopics().listings().get().stream().map(TopicListing::name).collect(Collectors.toList());
            return list;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * 往topic中发送消息
     * @param topic topicName
     * @param message 发送内容
     */
    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public static void main(String[] args) {
        KafkaDemo kafkaDemo = new KafkaDemo();
        //1.获得kafka句柄
        kafkaDemo.initAdminClient();
        //2.创建topic
        NewTopic newTopic = new NewTopic("test2", 1, Short.valueOf("1"));
        List<NewTopic> list2 = new ArrayList<NewTopic>();
        list2.add(newTopic);
        Collection<NewTopic> topics = new ArrayList<NewTopic>(list2);
        // kafkaDemo.createTopic(topics);

        //3.删除索引
        List<String> deleteTopicList = new ArrayList<String>();
        deleteTopicList.add("test");
        Collection<String> deleteCollection = deleteTopicList;
        //删除topic
        //kafkaDemo.deleteTopic(deleteCollection);
        //4.查询指定Topic
        String topicInfo = kafkaDemo.getTopicInfo(deleteTopicList);
        System.out.println("查询指定TopicInfo：" + topicInfo);

        //5.查询所有topic
        List<String> list = kafkaDemo.getAllTopic();
        for (String ss : list) {
            System.out.println("查询所有Topic：" + ss);
        }

        //6.往topic发送内容
//        kafkaDemo.sendMessage("test","kafkaDemo-t1");
    }

}


