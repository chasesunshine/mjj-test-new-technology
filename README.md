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
              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
              `uri` varchar(255) DEFAULT NULL COMMENT '调用的接口',
              `dao_method_name` varchar(1000) DEFAULT NULL COMMENT 'DAO层执行的方法名称',
              `ip` varchar(100) DEFAULT NULL COMMENT 'ip地址',
              `whole_sql` mediumtext COMMENT '完整SQL语句',
              `remark` varchar(255) DEFAULT NULL COMMENT '描述',
              `create_date` datetime DEFAULT NULL COMMENT '创建时间',
              PRIMARY KEY (`id`) USING BTREE
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;
            
            CREATE TABLE `world_user` (
              `id` bigint(20) NOT NULL AUTO_INCREMENT,
              `age` int(11) DEFAULT NULL,
              `name` varchar(255) DEFAULT NULL,
              PRIMARY KEY (`id`) USING BTREE
            ) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;
         （ 注 ： 只能 记录 mybqtis 手写的sql，不支持 mybatisplus的自动生成语句的sql（也就是快捷sql） ）
         
    - Java代理设计模式(Proxy)的四种具体实现：静态代理和动态代理
        网址 ： https://www.cnblogs.com/wangenxian/p/10885309.html
        项目地址 ： org.wanbang.study.proxy
        1. 问题 ： 
            面试问题：Java里的代理设计模式（Proxy Design Pattern）一共有几种实现方式？这个题目很像孔乙己问“茴香豆的茴字有哪几种写法？
            所谓代理模式，是指客户端(Client)并不直接调用实际的对象(下图右下角的RealSubject)，而是通过调用代理(Proxy)，来间接的调用实际的对象。
            代理模式的使用场合，一般是由于客户端不想直接访问实际对象，或者访问实际的对象存在技术上的障碍，因而通过代理对象作为桥梁，来完成间接访问。
            
    - 细说JDK动态代理的实现原理 
        网址 ： https://blog.csdn.net/mhmyqn/article/details/48474815
    - spring 事务控制 设置手动回滚
        https://blog.csdn.net/liuming690452074/article/details/107931852
        
        当我们需要在事务控制的service层类中使用try catch 去捕获异常后，就会使事务控制失效，因为该类的异常并没有抛出，就不是触发事务管理机制。
        怎样才能即使用try catch去捕获异常，而又让出现异常后spring回滚呢，这里就要用到
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        完美解决问题。并且能够使该方法执行完。
    - aop切面（测试的类：TransactionDemo）(完整的 ： org.wanbang.study.aop)
        aop 切面能切 cglib代理 和 jdk动态代理（实现了接口的类）
        网址 ： AOP五种执行时机 https://www.cnblogs.com/yimengxianzhi/p/12261963.html
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
        </dependency>
        
# rocketmq
    - 视频地址 ：
        https://www.bilibili.com/video/BV1L4411y7mn?from=search&seid=9663894476986529042&spm_id_from=333.337.0.0
    - 各章节概要
        - p1  1. RocketMQ专题大纲介绍
        - p2  2. 第一章知识概要
        - p3  3. MQ作用介绍
                - 优点：系统之间解耦、流量削峰、数据分发
        - p4  4. MQ优缺点比较
            系统可用性降低
            系统复杂度提高
            一致性问题
        - p5  5. 各大MQ产品比较
        - p6  6. Rocketmq的安装
            - 启动命令详见 （rocketmq-doc    RocketMQ-01.md     ## 2.3 启动RocketMQ）
                记住是在 linux 的 bin目录下操作
                # 编辑runbroker.sh和runserver.sh修改默认JVM大小
                    vi runbroker.sh
                    vi runserver.sh
                # 启动NameServer
                    nohup sh mqnamesrv &
                # 查看启动日志
                    tail -f ~/logs/rocketmqlogs/namesrv.log
                # 启动Broker
                    nohup sh mqbroker -n localhost:9876 &
                # 查看启动日志
                    tail -f ~/logs/rocketmqlogs/broker.log 
                # 1.关闭NameServer
                    sh mqshutdown namesrv
                # 2.关闭Broker
                    sh mqshutdown broker
                    
            - 注意点（https://blog.csdn.net/qq173684423/article/details/77930061）
                # tools.sh
                    JAVA_OPT="${JAVA_OPT} -server -Xms1g -Xmx1g -Xmn256m -XX:PermSize=128m -XX:MaxPermSize=128m"
            - 注意点 2（https://blog.csdn.net/yang13563758128/article/details/104224794）
                tail -f nohup.out 用来 查看执行信息
            - 注意点 3 （https://blog.csdn.net/weixin_33929309/article/details/94658754）
                # linux退出状态码及exit命令
                    例如 ： [1]+  Exit 127                nohup sh mqnamesrv
                    表示  127 　　　　　　　没找到命令
                * 注意看 /etc/profile 里面的 ROCKETMQ_HOME 配置是否符合路径信息
        - p7  7. 测试发送消息和接收消息
                bin 目录下两个窗口，一个发送消息，一个接收消息
                # 发送消息iptables restart
                    1.设置环境变量
                      export NAMESRV_ADDR=localhost:9876
                    2.使用安装包的Demo发送消息
                      sh tools.sh org.apache.rocketmq.example.quickstart.Producer
                # 接收消息
                    1.设置环境变量
                        export NAMESRV_ADDR=localhost:9876
                    2.接收消息
                        sh tools.sh org.apache.rocketmq.example.quickstart.Consumer
        - p8  8. RocketMQ各角色介绍
                * Producer：消息的发送者；举例：发信者
                * Consumer：消息接收者；举例：收信者
                * Broker：暂存和传输消息；举例：邮局
                * NameServer：管理Broker；举例：各个邮局的管理机构
                * Topic：区分消息的种类；一个发送者可以发送消息给一个或者多个Topic；一个消息的接收者可以订阅一个或者多个Topic消息
                * Message Queue：相当于是Topic的分区；用于并行发送和接收消息
        - p9  9.RocketMQ集群特点
                - NameServer是一个几乎无状态节点，可集群部署，节点之间无任何信息同步。
                - Broker部署相对复杂，Broker分为Master与Slave，一个Master可以对应多个Slave，
                    但是一个Slave只能对应一个Master，Master与Slave的对应关系通过指定相同的BrokerName，
                    不同的BrokerId来定义，BrokerId为0表示Master，非0表示Slave。Master也可以部署多个。
                    每个Broker与NameServer集群中的所有节点建立长连接，定时注册Topic信息到所有NameServer。
                - Producer与NameServer集群中的其中一个节点（随机选择）建立长连接，定期从NameServer取Topic路由信息，
                    并向提供Topic服务的Master建立长连接，且定时向Master发送心跳。
                    Producer完全无状态，可集群部署。
                - Consumer与NameServer集群中的其中一个节点（随机选择）建立长连接，定期从NameServer取Topic路由信息，
                    并向提供Topic服务的Master、Slave建立长连接，且定时向Master、Slave发送心跳。Consumer既可以从Master订阅消息，
                    也可以从Slave订阅消息，订阅规则由Broker配置决定。
        - p10  10.RocketMQ各种集群模式介绍
                1）单Master模式
                    这种方式风险较大，一旦Broker重启或者宕机时，会导致整个服务不可用。不建议线上环境使用,可以用于本地测试。
                2）多Master模式
                    一个集群无Slave，全是Master，例如2个Master或者3个Master，这种模式的优缺点如下：
                    - 优点：配置简单，单个Master宕机或重启维护对应用无影响，在磁盘配置为RAID10时，
                        即使机器宕机不可恢复情况下，由于RAID10磁盘非常可靠，消息也不会丢（异步刷盘丢失少量消息，同步刷盘一条不丢），性能最高；
                    - 缺点：单台机器宕机期间，这台机器上未被消费的消息在机器恢复之前不可订阅，消息实时性会受到影响。
                3）多Master多Slave模式（异步）
                    每个Master配置一个Slave，有多对Master-Slave，HA采用异步复制方式，主备有短暂消息延迟（毫秒级），这种模式的优缺点如下：
                    - 优点：即使磁盘损坏，消息丢失的非常少，且消息实时性不会受影响，同时Master宕机后，消费者仍然可以从Slave消费，
                        而且此过程对应用透明，不需要人工干预，性能同多Master模式几乎一样；
                    - 缺点：Master宕机，磁盘损坏情况下会丢失少量消息。
                4）多Master多Slave模式（同步）
                    每个Master配置一个Slave，有多对Master-Slave，HA采用同步双写方式，即只有主备都写成功，才向应用返回成功，这种模式的优缺点如下：
                    - 优点：数据与服务都无单点故障，Master宕机情况下，消息无延迟，服务可用性与数据可用性都非常高；
                    - 缺点：性能比异步复制模式略低（大约低10%左右），发送单个消息的RT会略高，且目前版本在主节点宕机后，
                        备机不能自动切换为主机。
        - p11  11.双主双从（2m-2s）集群介绍和工作流程说明
                1. 启动NameServer，NameServer起来后监听端口，等待Broker、Producer、Consumer连上来，相当于一个路由控制中心。
                2. Broker启动，跟所有的NameServer保持长连接，定时发送心跳包。心跳包中包含当前Broker信息(IP+端口等)以及存储所有Topic信息。
                    注册成功后，NameServer集群中就有Topic跟Broker的映射关系。
                3. 收发消息前，先创建Topic，创建Topic时需要指定该Topic要存储在哪些Broker上，也可以在发送消息时自动创建Topic。
                4. Producer发送消息，启动时先跟NameServer集群中的其中一台建立长连接，并从NameServer中获取当前发送的Topic存在哪些Broker上，
                    轮询从队列列表中选择一个队列，然后与队列所在的Broker建立长连接从而向Broker发消息。
                5. Consumer跟Producer类似，跟其中一台NameServer建立长连接，获取当前订阅Topic存在哪些Broker上，然后直接跟Broker建立连接通道，
                    开始消费消息。
        - p12  12.集群搭建1（见   README_集群搭建配置.md）
                在第一台虚拟机上
                    1. Host添加信息
                    2. 防火墙配置
                    3. 环境变量配置
                    4.  创建消息存储路径
                第二台上也要做同样的操作
        - p13  13.集群搭建2（见   README_集群搭建配置.md）
                broker配置文件
        - p14  14.集群搭建3（见   README_集群搭建配置.md）
                修改启动脚本文件
                服务启动
                
                - 注意点 ： 启动失败的话vim nohup.out查看nohup日志，小编是因为jdk版本过低不能识别metaspace参数，改为1.8后即可正常运行。其它问题也可以通过查看日志文件分析，可能是路径错误等原因
                    释放缓存  echo 1 > /proc/sys/vm/drop_caches
                            echo 2 > /proc/sys/vm/drop_caches  
                            echo 0 > /proc/sys/vm/drop_caches 
                    linux杀死进程 
                            解决办法：首先用ps axuf查看进程树
                            杀死该进程的方法为 top -9 进程PID
        - p15  15.集群搭建小结
                总结前面的
        - P16  16.mqadmin命令介绍
                了解即可
        - P17  17.rocketmq-console集群监控
               `RocketMQ`有一个对其扩展的开源项目[incubator-rocketmq-externals](https://github.com/apache/rocketmq-externals)，
               这个项目中有一个子模块叫`rocketmq-console`，这个便是管理控制台项目了，
               先将[incubator-rocketmq-externals](https://github.com/apache/rocketmq-externals)拉到本地，
               因为我们需要自己对`rocketmq-console`进行编译打包运行。
               1. 下载并编译打包
                   git clone https://github.com/apache/rocketmq-externals
                   cd rocketmq-console
                   mvn clean package -Dmaven.test.skip=true
                   * 注意：打包前在```rocketmq-console```中配置```namesrv```集群地址：
                     rocketmq.config.namesrvAddr=192.168.25.135:9876;192.168.25.138:9876
               2. 启动rocketmq-console：
                  java -jar rocketmq-console-ng-1.0.0.jar
                  启动成功后，我们就可以通过浏览器访问`http://localhost:8080`进入控制台界面了
        - P18  18.消息发送样例介绍和步骤分析
                * 消息发送者步骤分析r
                    1.创建消息生产者producer，并制定生产者组名
                    2.指定Nameserver地址
                    3.启动producer
                    4.创建消息对象，指定主题Topic、Tag和消息体
                    5.发送消息
                    6.关闭生产者producer
        -P19  19.发送同步消息
            com.example.rocketmq.test.base.producer.SyncProducer
        -P20  20.发送异步消息
            com.example.rocketmq.test.base.producer.AsyncProducer
        -P21  21.发送单向消息
            com.example.rocketmq.test.base.producer.OnewayProducer
        -P22  22.消息消费基本流程
                 * 消息消费者步骤分析
                    1.创建消费者Consumer，制定消费者组名
                    2.指定Nameserver地址
                    3.订阅主题Topic和Tag
                    4.设置回调函数，处理消息
                    5.启动消费者consumer  
                 com.example.rocketmq.test.base.consumer.Consumer
        -P23  23.消费者广播模式和负载均衡模式（com.example.rocketmq.test.base.consumer.Consumer）
                1）负载均衡模式（默认）
                消费者采用负载均衡方式消费消息，多个消费者共同消费队列消息，每个消费者处理的消息不同
                2）广播模式（要设置）
                消费者采用广播的方式消费消息，每个消费者消费的消息都是相同的
        -P24  24.顺序消息分析
                消息有序指的是可以按照消息的发送顺序来消费(FIFO)。RocketMQ可以严格的保证消息有序，可以分为分区有序或者全局有序。
                顺序消费的原理解析，在默认的情况下消息发送会采取Round Robin轮询方式把消息发送到不同的queue(分区队列)；而消费消息的时候从多个queue上拉取消息，
                    这种情况发送和消费是不能保证顺序。但是如果控制发送的顺序消息只依次发送到同一个queue中，消费的时候只从这个queue上依次拉取，则就保证了顺序。当发送和消费参与的queue只有一个，则是全局有序；如果多个queue参与，则为分区有序，即相对每个queue，消息都是有序的。
                下面用订单进行分区有序的示例。一个订单的顺序流程是：创建、付款、推送、完成。订单号相同的消息会被先后发送到同一个队列中，消费时，同一个OrderId获取到的肯定是同一个队列。
        -P25  25.顺序消息发送者
                com.example.rocketmq.test.order.Producer
                com.example.rocketmq.test.order.OrderStep
        -P26  26.顺序消息消费者
                com.example.rocketmq.test.order.ConsumerInOrder
        -P27  27.延迟消息
                com.example.rocketmq.test.delay.Producer
                com.example.rocketmq.test.delay.Consumer
        -P28  28.发送批量消息
                com.example.rocketmq.test.batch.Producer
                com.example.rocketmq.test.batch.Consumer
        -P29  29.过滤消息的两种方式(支持sql语句)
                发送消息时，你能通过`putUserProperty`来设置消息的属性
                DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
                producer.start();
                Message msg = new Message("TopicTest",
                   tag,
                   ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
                );
                // 设置一些属性
                msg.putUserProperty("a", String.valueOf(i));
                SendResult sendResult = producer.send(msg);
                producer.shutdown();
        -P30  30.Tag过滤
                com.example.rocketmq.test.filter.tag.Producer
                com.example.rocketmq.test.filter.tag.Consumer
        -P31  31.SQL语法过滤
                发送消息时，你能通过`putUserProperty`来设置消息的属性
                消费消息时：用MessageSelector.bySql来使用sql筛选消息
                com.example.rocketmq.test.filter.sql.Producer
                com.example.rocketmq.test.filter.sql.Consumer
        -P32  32.事务消息的流程分析
                