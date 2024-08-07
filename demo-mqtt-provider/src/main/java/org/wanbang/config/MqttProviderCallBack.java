package org.wanbang.config;

import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttProviderCallBack implements MqttCallback{

    @Value("${spring.mqtt.client.id}")
    private String clientId;
    /**
     * 与服务器断开的回调
     */
    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("与服务器断开的回调 "+clientId+"与服务器断开连接");
    }

    /**
     * 消息到达的回调
     */
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("消息到达的回调");
    }

    /**
     * 消息发布成功的回调
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        IMqttAsyncClient client = token.getClient();
        System.out.println("消息发布成功的回调 "+client.getClientId()+"发布消息成功！");
    }

}
