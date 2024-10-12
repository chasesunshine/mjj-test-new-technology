# Redis + Lua 限流实现
    https://mp.weixin.qq.com/s/kyFAWH3mVNJvurQDt4vchA
    ## 8、测试
    测试「预期」：连续请求3次均可以成功，第4次请求被拒绝。接下来看一下是不是我们预期的效果，请求地址：http://127.0.0.1:8080/limitTest1，用postman进行测试，有没有postman url直接贴浏览器也是一样。
    可以看到第四次请求时，应用直接拒绝了请求，说明我们的 Springboot + aop + lua 限流方案搭建成功。

    ## 总结
    以上 springboot + aop + Lua 限流实现是比较简单的，旨在让大家认识下什么是限流？如何做一个简单的限流功能，面试要知道这是个什么东西。上面虽然说了几种实现限流的方案，但选哪种还要结合具体的业务场景，不能为了用而用。