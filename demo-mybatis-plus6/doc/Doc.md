# sql:
    CREATE TABLE `spring_world` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `age` int(5) DEFAULT NULL,
      `name` varchar(3) DEFAULT NULL,
      `sex` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;
    
    
# MDC是什么鬼？用法、源码一锅端
    https://blog.csdn.net/javaforwork/article/details/105631342?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522168224519416800180631595%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=168224519416800180631595&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-105631342-null-null.142^v86^control,239^v2^insert_chatgpt&utm_term=MDC&spm=1018.2226.3001.4187

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
    
# 链路日志中追踪traceId
    https://blog.csdn.net/sfb749277979/article/details/126725871
    
    二，请求的源头
    1，http请求
    思路
    在最开始请求系统时候生成一个全局唯一的traceId，放在http 请求header中，系统接收到请求后，从header中取出这个traceId，
    放入MDC中，这个traceId伴随着这整个请求的调用周期，即当一个服务调用另外一个服务的时候，需要将traceId往下传递，
    从而形成一条链路。
    
    三，MDC实现链路追踪的原理
    1，概述
    MDC（Mapped Diagnostic Contexts），是Slf4J类日志系统中实现分布式多线程日志数据传递的重要工具，用户可利用MDC将一些运行时的上下文数据打印出来。目前只有log4j和logback提供原生的MDC支持
    2，使用（具体不同场景使用见（二，请求源头））
    在logback配置文件中配置MDC容器中的变量%X{trackId}
    %d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %X{trackId} [%15.15t] %class{39}.%method[%L] : %m%n
    UTF-8f
    
    四，MDC使用总结
    mdc就是基于Threadlocal进行的一个流程周转的标志物的传递，就是根据这种标志，可以追踪到日志的整体请求记录，
    便于进行定位到问题所在，而且对于用户的影响极小