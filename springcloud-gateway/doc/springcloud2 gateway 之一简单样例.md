springcloud2 gateway 之一：简单样例
https://blog.csdn.net/haveqing/article/details/88424598?spm=1001.2101.3001.6650.3&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-3-88424598-blog-134069767.235%5Ev43%5Epc_blog_bottom_relevance_base9&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-3-88424598-blog-134069767.235%5Ev43%5Epc_blog_bottom_relevance_base9&utm_relevant_index=4

# 项目：springcloud-gateway 、 springboot-demo
# 访问：
    网关： http://localhost:8666/app1/demo/test1
    项目： http://localhost:8555/demo/test1

    总结：
        把以/app1开头的请求，转发到http://localhost:8081
        
        predicates是谓词，
        
        Spring会根据名称去查找对应的FilterFactory，目前支持的名称有：After、Before、Between、Cookie、Header、Host、Method、Path、Query、RemoteAddr。
        
        Spring-Cloud-Gateway之RoutePredicate
        https://www.jianshu.com/p/03d42105f81f
        
        008-spring cloud gateway-路由谓词RoutePredicate、RoutePredicateFactory
        https://www.cnblogs.com/bjlhx/p/9785926.html
    
    
        ————————————————
        
                                    版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
        
        原文链接：https://blog.csdn.net/haveqing/article/details/88424598