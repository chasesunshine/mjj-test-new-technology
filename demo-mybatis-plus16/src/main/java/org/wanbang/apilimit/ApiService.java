package org.wanbang.apilimit;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class ApiService {
    public void callApi() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(3000); // 3秒连接超时
        factory.setReadTimeout(3000);      // 3秒读取超时

        RestTemplate restTemplate = new RestTemplate(factory);

        try {
            String result = restTemplate.getForObject("https://api.example.com/endpoint", String.class);
            System.out.println(result);
        } catch (org.springframework.web.client.ResourceAccessException e) {
            System.out.println("API调用超时");
        }
    }
}
