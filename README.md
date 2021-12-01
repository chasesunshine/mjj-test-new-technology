# 分布式项目
    mybatisplus分布式数据库测试
#test-nacos
    nacos-server 配置列表测试
#springbootDemo-mybatis-plus项目
    - 测试 JAVA里自定义注解来进行数据验证：https://www.cnblogs.com/xz816111/p/9484902.html
    
    - @Retryable的使用 https://www.cnblogs.com/juncaoit/p/11398547.html
         三：说明
         
         1.@Retryable参数的意思说明
         
         value：抛出指定异常才会重试
         include：和value一样，默认为空，当exclude也为空时，默认所以异常
         exclude：指定不处理的异常
         maxAttempts：最大重试次数，默认3次
         backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000L；multiplier（指定延迟倍数）默认为0，表示固定暂停1秒后进行重试，如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒。
         
         2.Recover注解
         　　
         　　当重试耗尽时，RetryOperations可以将控制传递给另一个回调，即RecoveryCallback。Spring-Retry还提供了@Recover注解，用于@Retryable重试失败后处理方法，此方法里的异常一定要是@Retryable方法里抛出的异常，否则不会调用这个方法。
         　　从上面的结果上可以看出来。
         
         四：注意事项
         1.注意
         　　使用了@Retryable的方法在本类中使用没有效果，只有在其他类中使用@Autowired注入或者@Bean才能生效
         　　要触发@Recover方法，@Retryable方法不能存在返回值，只能是void
         　　非幂等下慎用
         　　使用@Retryable的方法里不能使用try  catch包裹，要在方法上抛出异常，不然不会触发
#demo-mybatis-plus2
    - spring boot 2.x 使用mybatis拦截器实现系统日志记录（将完整参数的SQL语句记录到数据库中）   https://blog.csdn.net/C_AJing/article/details/110644477
        1.  sql 
            CREATE TABLE `sys_log` (
              `id` bigint(20) NOT NULL COMMENT '主键',
              `uri` varchar(255) DEFAULT NULL COMMENT '调用的接口',
              `dao_method_name` varchar(1000) DEFAULT NULL COMMENT 'DAO层执行的方法名称',
              `ip` varchar(100) DEFAULT NULL COMMENT 'ip地址',
              `whole_sql` mediumtext COMMENT '完整SQL语句',
              `remark` varchar(255) DEFAULT NULL COMMENT '描述',
              `create_date` datetime DEFAULT NULL COMMENT '创建时间',
              PRIMARY KEY (`id`) USING BTREE
            ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
            
            CREATE TABLE `world_user` (
              `id` bigint(20) NOT NULL AUTO_INCREMENT,
              `age` int(11) DEFAULT NULL,
              `name` varchar(255) DEFAULT NULL,
              PRIMARY KEY (`id`) USING BTREE
            ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
         （ 注 ： 只能 记录 mybqtis 手写的sql，不支持 mybatisplus的自动生成语句的sql（也就是快捷sql） ）
         
    - Java代理设计模式(Proxy)的四种具体实现：静态代理和动态代理
        网址 ： https://www.cnblogs.com/wangenxian/p/10885309.html
        项目地址 ： org.wanbang.proxy
        1. 问题 ： 
            面试问题：Java里的代理设计模式（Proxy Design Pattern）一共有几种实现方式？这个题目很像孔乙己问“茴香豆的茴字有哪几种写法？
            所谓代理模式，是指客户端(Client)并不直接调用实际的对象(下图右下角的RealSubject)，而是通过调用代理(Proxy)，来间接的调用实际的对象。
            代理模式的使用场合，一般是由于客户端不想直接访问实际对象，或者访问实际的对象存在技术上的障碍，因而通过代理对象作为桥梁，来完成间接访问。
            
    - 细说JDK动态代理的实现原理 
        网址 ： https://blog.csdn.net/mhmyqn/article/details/48474815
    