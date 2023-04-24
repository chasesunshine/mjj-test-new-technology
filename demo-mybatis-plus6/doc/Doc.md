# sql:
    CREATE TABLE `spring_world` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `age` int(5) DEFAULT NULL,
      `name` varchar(3) DEFAULT NULL,
      `sex` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;
    
    
# MDC是什么鬼？用法、源码一锅端
    1. MDC 快速入门
    MDC 全称是 Mapped Diagnostic Context，可以粗略的理解成是一个线程安全的存放诊断日志的容器。
    
    好了，入门程序就这么简单，简单做个小结。
    a）MDC 提供的 put 方法，可以将一个 K-V 的键值对放到容器中，并且能保证同一个线程内，Key 是唯一的，不同的线程 MDC 的值互不影响；
    b)  在 logback.xml 中，在 layout 中可以通过声明 %X{REQ_ID} 来输出 MDC 中 REQ_ID 的信息；
    c）MDC 提供的 remove 方法，可以清除 MDC 中指定 key 对应的键值对信息。
    
    3. MDC 能干什么？
    MDC 的应用场景其实蛮多的，下面简单列举几个。
    a）在 WEB 应用中，如果想在日志中输出请求用户 IP 地址、请求 URL、统计耗时等等，MDC 基本都能支撑；
    b）在 WEB 应用中，如果能画出用户的请求到响应整个过程，势必会快速定位生产问题，那么借助 MDC 来保存用户请求时产生的 reqId，当请求完成后，再将这个 reqId 进行移除，这么一来通过 grep reqId 就能轻松 get 整个请求流程的日志轨迹；
    c）在微服务盛行的当下，链路跟踪是个难题，而借助 MDC 去埋点，巧妙实现链路跟踪应该不是问题。