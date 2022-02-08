# rocketmq
    - p12  12.集群搭建1
        在第一台虚拟机上
            1. Host添加信息
                ```bash
                vim /etc/hosts
                配置如下:
                    ```bash
                    # nameserver
                    47.101.44.136 rocketmq-nameserver1
                    192.168.146.130 rocketmq-nameserver2
                    # broker
                    47.101.44.136 rocketmq-master1
                    47.101.44.136 rocketmq-slave2
                    192.168.146.130 rocketmq-master2
                    192.168.146.130 rocketmq-slave1
                配置完成后, 重启网卡
                    ```bash
                    systemctl restart network
            2. 防火墙配置
                宿主机需要远程访问虚拟机的rocketmq服务和web服务，需要开放相关的端口号，简单粗暴的方式是直接关闭防火墙
                    ```bash
                    # 关闭防火墙
                    systemctl stop firewalld.service
                    # 查看防火墙的状态
                    firewall-cmd --state 
                    # 禁止firewall开机启动
                    systemctl disable firewalld.service
                    # 重启防火墙
                    firewall-cmd --reload
            3. 环境变量配置
                ```bash
                vim /etc/profile
                在profile文件的末尾加入如下命令
                    ```bash
                    #set rocketmq
                    ROCKETMQ_HOME=/usr/local/src/rocketmq/rocketmq-all-4.4.0-bin-release
                    PATH=$PATH:$ROCKETMQ_HOME/bin
                    export ROCKETMQ_HOME PATH
                输入:wq! 保存并退出， 并使得配置立刻生效：
                    ```bash
                    source /etc/profile
            4.  创建消息存储路径
                    ```bash
                    mkdir /usr/local/src/common/rocketmq/store
                    mkdir /usr/local/src/common/rocketmq/store/commitlog
                    mkdir /usr/local/src/common/rocketmq/store/consumequeue
                    mkdir /usr/local/src/common/rocketmq/store/index
        第二台上也要做同样的操作
            注意点：centos6 上操作是不一致的
                1. centos6的网卡重启方法：service network restart
                    关闭防火墙：service iptables stop
                    开启防火墙：service iptables start
                    重启防火墙：service iptables restart
                    查看防火墙状态：service iptables status
                2. Bringing up interface eth0: Error: No suitable device found: no device found for connection 'System
                    https://blog.csdn.net/weibin_6388/article/details/84821760
                3. Shutting down interface Auto_eth1:  Device has MAC address 00:00:00:00:00:00 00:0C:29:3A:EB:99, instead of configured address 00:0C:29:00:1D:E8. Ignoring.
                    https://blog.csdn.net/hepannnn/article/details/78159857
                    修改 /etc/network-scripts/ifcfg-Auto_eth1 文件
                    
                    
    - p13  13.集群搭建2                    
            1）master1
                 服务器：192.168.25.135
                 ```sh
                 vi /usr/soft/rocketmq/conf/2m-2s-sync/broker-a.properties
                     修改配置如下：
                         ```bash
                         #所属集群名字
                         brokerClusterName=rocketmq-cluster
                         #broker名字，注意此处不同的配置文件填写的不一样
                         brokerName=broker-a
                         #0 表示 Master，>0 表示 Slave
                         brokerId=0
                         #nameServer地址，分号分割
                         namesrvAddr=rocketmq-nameserver1:9876;rocketmq-nameserver2:9876
                         #在发送消息时，自动创建服务器不存在的topic，默认创建的队列数
                         defaultTopicQueueNums=4
                         #是否允许 Broker 自动创建Topic，建议线下开启，线上关闭
                         autoCreateTopicEnable=true
                         #是否允许 Broker 自动创建订阅组，建议线下开启，线上关闭
                         autoCreateSubscriptionGroup=true
                         #Broker 对外服务的监听端口
                         listenPort=10911
                         #删除文件时间点，默认凌晨 4点
                         deleteWhen=04
                         #文件保留时间，默认 48 小时
                         fileReservedTime=120
                         #commitLog每个文件的大小默认1G
                         mapedFileSizeCommitLog=1073741824
                         #ConsumeQueue每个文件默认存30W条，根据业务情况调整
                         mapedFileSizeConsumeQueue=300000
                         #destroyMapedFileIntervalForcibly=120000
                         #redeleteHangedFileInterval=120000
                         #检测物理文件磁盘空间
                         diskMaxUsedSpaceRatio=88
                         #存储路径
                         storePathRootDir=/usr/local/src/common/rocketmq/store
                         #commitLog 存储路径
                         storePathCommitLog=/usr/local/src/common/rocketmq/store/commitlog
                         #消费队列存储路径存储路径
                         storePathConsumeQueue=/usr/local/src/common/rocketmq/store/consumequeue
                         #消息索引存储路径
                         storePathIndex=/usr/local/src/common/rocketmq/store/index
                         #checkpoint 文件存储路径
                         storeCheckpoint=/usr/local/src/common/rocketmq/store/checkpoint
                         #abort 文件存储路径
                         abortFile=/usr/local/src/common/rocketmq/store/abort
                         #限制的消息大小
                         maxMessageSize=65536
                         #flushCommitLogLeastPages=4
                         #flushConsumeQueueLeastPages=2
                         #flushCommitLogThoroughInterval=10000
                         #flushConsumeQueueThoroughInterval=60000
                         #Broker 的角色
                         #- ASYNC_MASTER 异步复制Master
                         #- SYNC_MASTER 同步双写Master
                         #- SLAVE
                         brokerRole=SYNC_MASTER
                         #刷盘方式
                         #- ASYNC_FLUSH 异步刷盘
                         #- SYNC_FLUSH 同步刷盘
                         flushDiskType=SYNC_FLUSH
                         #checkTransactionMessageEnable=false
                         #发消息线程池数量
                         #sendMessageThreadPoolNums=128
                         #拉消息线程池数量
                         #pullMessageThreadPoolNums=128
            2）slave2
                服务器：192.168.25.135
                ```sh
                vi /usr/soft/rocketmq/conf/2m-2s-sync/broker-b-s.properties
                修改配置如下：
                        #所属集群名字
                        brokerClusterName=rocketmq-cluster
                        #broker名字，注意此处不同的配置文件填写的不一样
                        brokerName=broker-b
                        #0 表示 Master，>0 表示 Slave
                        brokerId=1
                        #nameServer地址，分号分割
                        namesrvAddr=rocketmq-nameserver1:9876;rocketmq-nameserver2:9876
                        #在发送消息时，自动创建服务器不存在的topic，默认创建的队列数
                        defaultTopicQueueNums=4
                        #是否允许 Broker 自动创建Topic，建议线下开启，线上关闭
                        autoCreateTopicEnable=true
                        #是否允许 Broker 自动创建订阅组，建议线下开启，线上关闭
                        autoCreateSubscriptionGroup=true
                        #Broker 对外服务的监听端口
                        listenPort=11011
                        #删除文件时间点，默认凌晨 4点
                        deleteWhen=04
                        #文件保留时间，默认 48 小时
                        fileReservedTime=120
                        #commitLog每个文件的大小默认1G
                        mapedFileSizeCommitLog=1073741824
                        #ConsumeQueue每个文件默认存30W条，根据业务情况调整
                        mapedFileSizeConsumeQueue=300000
                        #destroyMapedFileIntervalForcibly=120000
                        #redeleteHangedFileInterval=120000
                        #检测物理文件磁盘空间
                        diskMaxUsedSpaceRatio=88
                        #存储路径
                        storePathRootDir=/usr/local/src/common/rocketmq/store-c
                        #commitLog 存储路径
                        storePathCommitLog=/usr/local/src/common/rocketmq/store-c/commitlog
                        #消费队列存储路径存储路径
                        storePathConsumeQueue=/usr/local/src/common/rocketmq/store-c/consumequeue
                        #消息索引存储路径
                        storePathIndex=/usr/local/src/common/rocketmq/store-c/index
                        #checkpoint 文件存储路径
                        storeCheckpoint=/usr/local/src/common/rocketmq/store-c/checkpoint
                        #abort 文件存储路径
                        abortFile=/usr/local/src/common/rocketmq/store-c/abort
                        #限制的消息大小
                        maxMessageSize=65536
                        #flushCommitLogLeastPages=4
                        #flushConsumeQueueLeastPages=2
                        #flushCommitLogThoroughInterval=10000
                        #flushConsumeQueueThoroughInterval=60000
                        #Broker 的角色
                        #- ASYNC_MASTER 异步复制Master
                        #- SYNC_MASTER 同步双写Master
                        #- SLAVE
                        brokerRole=SLAVE
                        #刷盘方式
                        #- ASYNC_FLUSH 异步刷盘
                        #- SYNC_FLUSH 同步刷盘
                        flushDiskType=ASYNC_FLUSH
                        #checkTransactionMessageEnable=false
                        #发消息线程池数量
                        #sendMessageThreadPoolNums=128
                        #拉消息线程池数量
                        #pullMessageThreadPoolNums=128
            3）master2
                服务器：192.168.25.138
                ```sh
                vi /usr/soft/rocketmq/conf/2m-2s-sync/broker-b.properties
                    修改配置如下：
                    ```bash
                        #所属集群名字
                        brokerClusterName=rocketmq-cluster
                        #broker名字，注意此处不同的配置文件填写的不一样
                        brokerName=broker-b
                        #0 表示 Master，>0 表示 Slave
                        brokerId=0
                        #nameServer地址，分号分割
                        namesrvAddr=rocketmq-nameserver1:9876;rocketmq-nameserver2:9876
                        #在发送消息时，自动创建服务器不存在的topic，默认创建的队列数
                        defaultTopicQueueNums=4
                        #是否允许 Broker 自动创建Topic，建议线下开启，线上关闭
                        autoCreateTopicEnable=true
                        #是否允许 Broker 自动创建订阅组，建议线下开启，线上关闭
                        autoCreateSubscriptionGroup=true
                        #Broker 对外服务的监听端口
                        listenPort=10911
                        #删除文件时间点，默认凌晨 4点
                        deleteWhen=04
                        #文件保留时间，默认 48 小时
                        fileReservedTime=120
                        #commitLog每个文件的大小默认1G
                        mapedFileSizeCommitLog=1073741824
                        #ConsumeQueue每个文件默认存30W条，根据业务情况调整
                        mapedFileSizeConsumeQueue=300000
                        #destroyMapedFileIntervalForcibly=120000
                        #redeleteHangedFileInterval=120000
                        #检测物理文件磁盘空间
                        diskMaxUsedSpaceRatio=88
                        #存储路径
                        storePathRootDir=/usr/local/src/java/rocketmq/store
                        #commitLog 存储路径
                        storePathCommitLog=/usr/local/src/java/rocketmq/store/commitlog
                        #消费队列存储路径存储路径
                        storePathConsumeQueue=/usr/local/src/java/rocketmq/store/consumequeue
                        #消息索引存储路径
                        storePathIndex=/usr/local/src/java/rocketmq/store/index
                        #checkpoint 文件存储路径
                        storeCheckpoint=/usr/local/src/java/rocketmq/store/checkpoint
                        #abort 文件存储路径
                        abortFile=/usr/local/src/java/rocketmq/store/abort
                        #限制的消息大小
                        maxMessageSize=65536
                        #flushCommitLogLeastPages=4
                        #flushConsumeQueueLeastPages=2
                        #flushCommitLogThoroughInterval=10000
                        #flushConsumeQueueThoroughInterval=60000
                        #Broker 的角色
                        #- ASYNC_MASTER 异步复制Master
                        #- SYNC_MASTER 同步双写Master
                        #- SLAVE
                        brokerRole=SYNC_MASTER
                        #刷盘方式
                        #- ASYNC_FLUSH 异步刷盘
                        #- SYNC_FLUSH 同步刷盘
                        flushDiskType=SYNC_FLUSH
                        #checkTransactionMessageEnable=false
                        #发消息线程池数量
                        #sendMessageThreadPoolNums=128
                        #拉消息线程池数量
                        #pullMessageThreadPoolNums=128
            4）slave1
                服务器：192.168.25.138
                ```sh
                vi /usr/soft/rocketmq/conf/2m-2s-sync/broker-a-s.properties
                    修改配置如下：
                    ```bash
                        #所属集群名字
                        brokerClusterName=rocketmq-cluster
                        #broker名字，注意此处不同的配置文件填写的不一样
                        brokerName=broker-a
                        #0 表示 Master，>0 表示 Slave
                        brokerId=1
                        #nameServer地址，分号分割
                        namesrvAddr=rocketmq-nameserver1:9876;rocketmq-nameserver2:9876
                        #在发送消息时，自动创建服务器不存在的topic，默认创建的队列数
                        defaultTopicQueueNums=4
                        #是否允许 Broker 自动创建Topic，建议线下开启，线上关闭
                        autoCreateTopicEnable=true
                        #是否允许 Broker 自动创建订阅组，建议线下开启，线上关闭
                        autoCreateSubscriptionGroup=true
                        #Broker 对外服务的监听端口
                        listenPort=11011
                        #删除文件时间点，默认凌晨 4点
                        deleteWhen=04
                        #文件保留时间，默认 48 小时
                        fileReservedTime=120
                        #commitLog每个文件的大小默认1G
                        mapedFileSizeCommitLog=1073741824
                        #ConsumeQueue每个文件默认存30W条，根据业务情况调整
                        mapedFileSizeConsumeQueue=300000
                        #destroyMapedFileIntervalForcibly=120000
                        #redeleteHangedFileInterval=120000
                        #检测物理文件磁盘空间
                        diskMaxUsedSpaceRatio=88
                        #存储路径
                        storePathRootDir=/usr/local/src/java/rocketmq/store-c
                        #commitLog 存储路径
                        storePathCommitLog=/usr/local/src/java/rocketmq/store-c/commitlog
                        #消费队列存储路径存储路径
                        storePathConsumeQueue=/usr/local/src/java/rocketmq/store-c/consumequeue
                        #消息索引存储路径
                        storePathIndex=/usr/local/src/java/rocketmq/store-c/index
                        #checkpoint 文件存储路径
                        storeCheckpoint=/usr/local/src/java/rocketmq/store-c/checkpoint
                        #abort 文件存储路径
                        abortFile=/usr/local/src/java/rocketmq/store-c/abort
                        #限制的消息大小
                        maxMessageSize=65536
                        #flushCommitLogLeastPages=4
                        #flushConsumeQueueLeastPages=2
                        #flushCommitLogThoroughInterval=10000
                        #flushConsumeQueueThoroughInterval=60000
                        #Broker 的角色
                        #- ASYNC_MASTER 异步复制Master
                        #- SYNC_MASTER 同步双写Master
                        #- SLAVE
                        brokerRole=SLAVE
                        #刷盘方式
                        #- ASYNC_FLUSH 异步刷盘
                        #- SYNC_FLUSH 同步刷盘
                        flushDiskType=ASYNC_FLUSH
                        #checkTransactionMessageEnable=false
                        #发消息线程池数量
                        #sendMessageThreadPoolNums=128
                        #拉消息线程池数量
                        #pullMessageThreadPoolNums=128
                     
                     
    - p14  14.集群搭建3
        修改启动脚本文件
            1）runbroker.sh
                ```sh
                vi /usr/local/rocketmq/bin/runbroker.sh
                
                需要根据内存大小进行适当的对JVM参数进行调整：
                ```bash
                #===================================================
                # 开发环境配置 JVM Configuration
                JAVA_OPT="${JAVA_OPT} -server -Xms256m -Xmx256m -Xmn128m"
            2）runserver.sh
                ```sh
                vim /usr/local/rocketmq/bin/runserver.sh
                ```bash
                JAVA_OPT="${JAVA_OPT} -server -Xms256m -Xmx256m -Xmn128m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=320m"
        服务启动
            1）启动NameServe集群
            分别在192.168.25.135和192.168.25.138启动NameServer
                ```bash
                    cd /usr/local/rocketmq/bin
                    nohup sh mqnamesrv &
                关闭 NameServer
                     sh mqshutdown namesrv
                关闭 Broker
                     sh mqshutdown broker
            2）启动Broker集群
            * 在192.168.25.135上启动master1和slave2
                master1：
                ```bash
                    cd /usr/local/rocketmq/bin
                    nohup sh mqbroker -c /usr/local/src/common/rocketmq/rocketmq-all-4.4.0-bin-release/conf/2m-2s-sync/broker-a.properties &
                slave2：
                ```sh
                    cd /usr/local/rocketmq/bin
                    nohup sh mqbroker -c /usr/local/src/common/rocketmq/rocketmq-all-4.4.0-bin-release/conf/2m-2s-sync/broker-b-s.properties &
            * 在192.168.25.138上启动master2和slave2
                master2
                ```sh
                    cd /usr/local/rocketmq/bin
                    nohup sh mqbroker -c /usr/local/src/java/rocketmq/rocketmq-all-4.4.0-bin-release/conf/2m-2s-sync/broker-b.properties &
                slave1
                ```sh
                    cd /usr/local/rocketmq/bin
                    nohup sh mqbroker -c /usr/local/src/java/rocketmq/rocketmq-all-4.4.0-bin-release/conf/2m-2s-sync/broker-a-s.properties &
            3）网址 ：
                注意要开放两个服务器的8080端口
                http://47.101.44.136:8080/
                http://192.168.146.130:8080/
            查看日志
            ```sh
                查看nameServer日志
                    tail -500f ~/logs/rocketmqlogs/namesrv.log
                查看broker日志
                    tail -500f ~/logs/rocketmqlogs/broker.log