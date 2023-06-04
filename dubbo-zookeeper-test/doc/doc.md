#个人测试dubbo-zookeeper demo案例
## springboot集成dubbo+zookeeper简单搭建（细到你没有感觉）
    https://blog.csdn.net/weixin_44231805/article/details/126144762
## Windows下安装zookeeper
    https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper
## Bug解决：Dubbo注册者注册不上（@Reference失效 ）
    https://blog.csdn.net/lufeia/article/details/126132499
## 个人github项目
    git@github.com:chasesunshine/dubbo_ex.git
    
    
#这篇文章讲的也很细
    dubbo+zookeeper+springboot整合(全)
    https://blog.csdn.net/qq_21561501/article/details/105307130?spm=1001.2101.3001.6650.7&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-7-105307130-blog-126144762.235%5Ev36%5Epc_relevant_default_base3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-7-105307130-blog-126144762.235%5Ev36%5Epc_relevant_default_base3&utm_relevant_index=14
    流程分析
    服务提供者将服务发布到注册中心（整合了dubbo和zookeeper前提下）
    
    即启动服务提供者项目，dubbo会扫描指定的包下带有@component注解的服务将它发布到注册中心中。
    需要注意zookeeper新版本的坑，需要解决日志冲突，即剔除日志依赖。
    
    注意，本来正常的步骤是需要将服务提供者的接口打包，然后用Pom文件导入，我们这里使用j简单的方式，
    直接将服务的接口拿过来，路径必须保证正确，即和服务提供者相同
    
    服务消费者将从注册中心拿到所需的服务（整合了dubbo和zookeeper前提下）
    
    reference远程引用指定的服务，它会按照全类名进行匹配，看谁的注册中心注册了这个全类名
    
