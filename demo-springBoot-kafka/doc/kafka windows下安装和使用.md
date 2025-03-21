# zookeeper启动命令
    D:\allSoftwareInstall\workSoftwareInstall\ZookeeperInstallPackage\apache-zookeeper-3.6.4-bin\bin
    命令： zkServer
# kafka启动命令
    D:\kafka_2.12-3.8.0
    命令：.\bin\windows\kafka-server-start.bat .\config\server.properties

# 【Kafka】Windows下安装Kafka（图文记录详细步骤） - 安装的话看这篇就行 （scala不用装）
    https://blog.csdn.net/tttzzzqqq2018/article/details/132127105

# Windows安装Kafka及Springboot整合
    https://blog.csdn.net/davidtio/article/details/131713186

# 遇到的问题点：
    ## windows下 Connection to node -1 (/192.168.15.29:9092) could not be established. Broker may not be available.
        1. 检查 Kafka Broker 是否运行
        确保 Kafka Broker 正在运行：
            登录到 Kafka Broker 所在的服务器。
            检查 Kafka 服务是否启动。如果 Kafka 是通过命令行启动的，确保命令行窗口没有关闭。
            如果没有运行，启动 Kafka：
                bin\windows\kafka-server-start.bat config\server.properties
        2. 检查 Broker 的监听地址
        Kafka Broker 的监听地址配置在 server.properties 文件中。确保以下配置正确：
        打开 Kafka 配置文件（通常位于 config/server.properties）：
            notepad config\server.properties
        检查 listeners 和 advertised.listeners 配置：
        properties
            listeners=PLAINTEXT://0.0.0.0:9092
            advertised.listeners=PLAINTEXT://192.168.15.29:9092
                listeners 是 Broker 实际监听的地址和端口。
                advertised.listeners 是客户端连接的地址和端口。
        确保 advertised.listeners 的地址和端口是客户端可以访问的