package org.wanbang.config;

import lombok.extern.slf4j.Slf4j;
import javax.annotation.PostConstruct;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MqttProviderConfig {
    @Value("${spring.mqtt.username}")
    private String username;

    @Value("${spring.mqtt.password}")
    private String password;

    @Value("${spring.mqtt.url}")
    private String hostUrl;

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;

    /**
     * 客户端对象
     */
    private MqttClient client;

    /**
     * 在bean初始化后连接到服务器
     */
    @PostConstruct
    public void init(){
        connect();
    }

    /**
     * 客户端连接服务端
     */
    public void connect(){
        try{
            //创建MQTT客户端对象
            client = new MqttClient(hostUrl,clientId,new MemoryPersistence());
            //连接设置
            MqttConnectOptions options = new MqttConnectOptions();
            //是否清空session，设置false表示服务器会保留客户端的连接记录（订阅主题，qos）,客户端重连之后能获取到服务器在客户端断开连接期间推送的消息
            //设置为true表示每次连接服务器都是以新的身份
            options.setCleanSession(true);
            //设置连接用户名
            options.setUserName(username);
            //设置连接密码
            options.setPassword(password.toCharArray());
            //设置超时时间，单位为秒
            options.setConnectionTimeout(100);
            //设置心跳时间 单位为秒，表示服务器每隔 1.5*20秒的时间向客户端发送心跳判断客户端是否在线
            options.setKeepAliveInterval(20);
            //设置遗嘱消息的话题，若客户端和服务器之间的连接意外断开，服务器将发布客户端的遗嘱信息
            options.setWill("willTopic",(clientId + "与服务器断开连接").getBytes(),0,false);
            //设置回调
            client.setCallback(new MqttProviderCallBack());
            client.connect(options);
        } catch(MqttException e){
            e.printStackTrace();
        }

    }
    public void publish(int qos,boolean retained,String topic,String message){
        MqttMessage mqttMessage = new MqttMessage();
//        ① QoS 0 至多一次
//        这一级别会发生消息丢失或重复，消息发布依赖于底层TCP/IP网络。即：<=1
//        ② QoS 1 最少一次
//        QoS 1 承诺消息将至少传送一次给订阅者。
//        ③ QoS 2 只有一次
//        使用 QoS 2，我们保证消息仅传送到目的地一次。为此，带有唯一消息 ID 的消息会存储两次，首先来自发送者，然后是接收者。
//        QoS 级别 2 在网络中具有最高的开销，因为在发送方和接收方之间需要两个流。
        mqttMessage.setQos(qos);
//        消息传递引擎是否应保留发布消息。发送一条消息，
//        将 retained 设置为 <code>true<code>，并使用空字节数组作为有效负载，
//        例如 <code>new byte[0]<code>，将从服务器中清除保留的消息。
//        无论<code><code>消息传递引擎是否应保留消息，@param保留的默认值为 false。 @throws IllegalStateException（如果无法编辑此消息）
        mqttMessage.setRetained(retained);
//        将此消息的有效负载设置为指定的字节数组。
        mqttMessage.setPayload(message.getBytes());
        //主题的目的地，用于发布/订阅信息
        MqttTopic mqttTopic = client.getTopic(topic);
        //提供一种机制来跟踪消息的传递进度
        //用于在以非阻塞方式（在后台运行）执行发布是跟踪消息的传递进度
        MqttDeliveryToken token;
        try {
            //将指定消息发布到主题，但不等待消息传递完成，返回的token可用于跟踪消息的传递状态
            //一旦此方法干净地返回，消息就已被客户端接受发布，当连接可用，将在后台完成消息传递。
            token = mqttTopic.publish(mqttMessage);
//            token.waitForCompletion();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

}
