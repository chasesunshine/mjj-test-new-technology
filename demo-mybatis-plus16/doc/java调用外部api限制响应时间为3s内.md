# Java调用外部API限制响应时间为3秒内

在Java中调用外部API时限制响应时间在3秒内，可以通过以下几种方式实现：

## 1. 使用HttpURLConnection设置超时

```java
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
```

## 2. 使用HttpClient (Java 11+)

```java
import java.net.URI;
import java.net.http.*;
import java.time.Duration;

public class ApiCaller {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.example.com/endpoint"))
                .timeout(Duration.ofSeconds(3)) // 设置3秒超时
                .build();
        
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (HttpTimeoutException e) {
            System.out.println("请求超时");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## 3. 使用Spring RestTemplate

```java
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
```

## 4. 使用异步调用和Future

```java
import java.util.concurrent.*;

public class AsyncApiCaller {
    private final ExecutorService executor = Executors.newCachedThreadPool();
    
    public String callApiWithTimeout() {
        Future<String> future = executor.submit(() -> {
            // 这里放置实际的API调用代码
            return callExternalApi();
        });
        
        try {
            return future.get(3, TimeUnit.SECONDS); // 等待最多3秒
        } catch (TimeoutException e) {
            future.cancel(true); // 取消任务
            return "API调用超时";
        } catch (Exception e) {
            return "调用出错: " + e.getMessage();
        }
    }
    
    private String callExternalApi() {
        // 实际的API调用逻辑
        return "API响应";
    }
}
```

## 注意事项

1. 超时设置应包括连接超时和读取超时
2. 正确处理超时异常，避免程序崩溃
3. 考虑重试机制，但要注意不要无限重试
4. 对于关键业务，考虑记录超时日志以便后续分析
5. 在微服务架构中，可以考虑使用断路器模式(Hystrix或Resilience4j)

以上方法都可以确保API调用在3秒内完成，否则会中断连接并抛出超时异常。