package org.wanbang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.anno.Limit;
import org.wanbang.constant.LimitType;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: majiajian
 * @Description:
 *  我们将@Limit注解作用在需要进行限流的接口方法上，下边我们给方法设置@Limit注解，在10秒内只允许放行3个请求，这里为直观一点用AtomicInteger计数。
 */
@RestController
public class LimiterController {

    private static final AtomicInteger ATOMIC_INTEGER_1 = new AtomicInteger();
    private static final AtomicInteger ATOMIC_INTEGER_2 = new AtomicInteger();
    private static final AtomicInteger ATOMIC_INTEGER_3 = new AtomicInteger();

    /**
     * @author majiajian
     * @description
     * @date 2020/4/8 13:42
     */
    @Limit(key = "limitTest", period = 10, count = 3)
    @GetMapping("/limitTest1")
    public int testLimiter1() {

        return ATOMIC_INTEGER_1.incrementAndGet();
    }

    /**
     * @author majiajian
     * @description
     * @date 2020/4/8 13:42
     */
    @Limit(key = "customer_limit_test", period = 10, count = 3, limitType = LimitType.CUSTOMER)
    @GetMapping("/limitTest2")
    public int testLimiter2() {

        return ATOMIC_INTEGER_2.incrementAndGet();
    }

    /**
     * @author majiajian
     * @description
     * @date 2020/4/8 13:42
     */
    @Limit(key = "ip_limit_test", period = 10, count = 3, limitType = LimitType.IP)
    @GetMapping("/limitTest3")
    public int testLimiter3() {

        return ATOMIC_INTEGER_3.incrementAndGet();
    }

}
