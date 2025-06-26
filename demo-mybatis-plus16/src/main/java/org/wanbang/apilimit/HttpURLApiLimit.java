package org.wanbang.apilimit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * 1. 使用HttpURLConnection设置超时
 */
public class HttpURLApiLimit {
    public void invokeApi(){
        try {
            URL url = new URL("https://api.example.com/endpoint");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 设置连接超时和读取超时均为3秒
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);

            // 发送请求
            int responseCode = connection.getResponseCode();

            // 处理响应...
        } catch (SocketTimeoutException e) {
            System.out.println("API调用超时，超过3秒未响应");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
