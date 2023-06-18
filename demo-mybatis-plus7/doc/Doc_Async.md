#Springboot @Async 多线程获取返回值
    https://blog.csdn.net/lihaiyong92/article/details/117254607
    用的是同一个方法 （区别就是主线程开启异步注解之后 是否有返回值的区别）
    
    1. 两个都用的是一个线程池执行的
    
    2. service1 单纯执行业务, 不用返回数据, 主线程也不用等待
    
    3. service2 需要返回数据, 主线程需要等待结果( 注意返回值只能是 Future, 最后再 .get()去获取, 否则无法异步执行)
    
    4. service3 也可以返回数据, 但是书写上麻烦一些.  返回值直接是想要的结果, 不像 service2 还需要提取一次数据.
