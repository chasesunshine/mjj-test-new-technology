package org.wanbang.hystrixTest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class ExternalServiceCaller {
    public static void main(String[] args) {
        processBusinessLogic("qwer");
    }

    // 主业务方法
    public static String processBusinessLogic(String input) {
        // 主业务逻辑处理...
        System.out.println("Processing main business logic with input: " + input);

        // 调用外部服务
        String externalResult = callExternalApi(input);

        // 继续处理业务逻辑
        System.out.println("Continuing main business logic with external result: " + externalResult);
        return "Processed: " + externalResult;
    }

    /**
     * 使用线程池隔离的外部调用方法
     * 配置了专用的线程池(externalServicePool)，核心线程20个，最大队列100
     */
    @HystrixCommand(
            threadPoolKey = "externalServicePool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "100")
            },
            fallbackMethod = "externalApiFallback"
    )
    public static String callExternalApi(String param) {
        // 模拟外部API调用
        System.out.println("Calling external API with param: " + param +
                " on thread: " + Thread.currentThread().getName());

        // 模拟网络延迟
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 模拟外部API响应
        return "ExternalResponse-";
    }
}