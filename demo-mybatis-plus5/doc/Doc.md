# sql:
    CREATE TABLE `spring_world` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `age` int(5) DEFAULT NULL,
      `name` varchar(3) DEFAULT NULL,
      `sex` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;
    
    
# SpringBoot 如何在日志中增加 trace id 用于链路追踪（上）
    (这一节)上节解决了单一线程的 trace id 传递，如果子线程和线程池怎么办呢，还有 rpc 远程调用，怎么玩呢？
    目录
        增加 logback 记录日志
        使用 AOP 统一控制输入输出
        使用 MDC 存储 trace id
    网址： https://www.modb.pro/db/219713
    