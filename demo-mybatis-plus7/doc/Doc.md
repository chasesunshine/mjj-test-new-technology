# sql:
    CREATE TABLE `user` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `age` int(5) DEFAULT NULL,
      `name` varchar(255) DEFAULT NULL,
      `password` varchar(255) DEFAULT NULL,
      `sex` varchar(255) DEFAULT NULL,
      PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;
    
    
# JWT的基本使用
    https://blog.csdn.net/weixin_45081813/article/details/114321013
    一.什么是JWT
        首先jwt其实是三个英语单词JSON Web Token的缩写。通过全名你可能就有一个基本的认知了。token一般都是用来认证的，比如我们系统中常用的用户登录token可以用来认证该用户是否登录。jwt也是经常作为一种安全的token使用。
    
        1.JWT的定义
        JWT是一种用于双方之间传递安全信息的简洁的、URL安全的表述性声明规范。JWT作为一个开放的标准（RFC 7519），定义了一种简洁的，自包含的方法用于通信双方之间以Json对象的形式安全的传递信息。因为数字签名的存在，这些信息是可信的，JWT可以使用HMAC算法或者是RSA的公私秘钥对进行签名。
        
        2.JWT特点
        简洁(Compact) : 可以通过URL，POST参数或者在HTTP header发送，因为数据量小，传输速度也很快
        自包含(Self-contained) ：负载中包含了所有用户所需要的信息，避免了多次查询数据库
        
        3.JWT作用
        授权
        
        这是使用JWT的最常见方案。一旦用户登录，每个后续请求将包括JWT,从而允许用户访问该令牌允许的路由，服务和资源。单点登录是今广泛使用JWT的一项功能。因为它的开销很小并且可以在不同的域中轻松使用
        
        信息交换
        
        JSON Web Token是在各方之间安全地传输信息的好方法。因为可以对JWT进行签名（例如，使用公钥/私钥对），所以您可以确保发件人是他们所说的人。此外，由于签名是使用标头和有效负载计算的，因此您还可以验证内容是否遭到篡改。
        
        4.JWT优点
        因为json的通用性，所以JWT是可以进行跨语言支持的，像JAVA,JavaScript,NodeJS,PHP等很多语言都可以使用。
        因为有了payload部分，所以JWT可以在自身存储一些其他业务逻辑所必要的非敏感信息。
        便于传输，jwt的构成非常简单，字节占用很小，所以它是非常便于传输的。
        它不需要在服务端保存会话信息, 所以它易于应用的扩展
        5.JWT缺点
        占带宽： 正常情况下要比 session_id 更大，需要消耗更多流量，挤占更多带宽，假如你的网站每月有 10 万次的浏览器，就意味着要多开销几十兆的流量。听起来并不多，但日积月累也是不小一笔开销。实际上，许多人会在 JWT 中存储的信息会更多。
        
        无法在服务端注销，那么就很难解决劫持问题
        
        性能问题： JWT 的卖点之一就是加密签名，由于这个特性，接收方得以验证 JWT 是否有效且被信任。但是大多数 Web 身份认证应用中，JWT 都会被存储到 Cookie 中，这就是说你有了两个层面的签名。听着似乎很牛逼，但是没有任何优势，为此，你需要花费两倍的 CPU 开销来验证签名。对于有着严格性能要求的 Web 应用，这并不理想，尤其对于单线程环境。
        
        6.JWT安全性
        不应该在jwt的payload部分存放敏感信息，因为该部分是客户端可解密的部分。
        保护好secret私钥，该私钥非常重要。
        如果可以，请使用https协议
        
    3.基于token的鉴权机制
    基于token的鉴权机制类似于http协议也是无状态的，它不需要在服务端去保留用户的认证信息或者会话信息。这就意味着基于token认证机制的应用不需要去考虑用户在哪一台服务器登录了，这就为应用的扩展提供了便利。
 
    流程：    
    首先，前端通过Web表单将自己的用户名和密码发送到后端的接口。这一过程一般是一个HTTP POST请求。建议的方式是通过SSL加密的传输(https协议)，从而避免敏感信息被嗅探。
    
    后端核对用户名和密码成功后，将用户的id等其他信息作为 JWT-Payload（负载)，将其与头部分别进行Base64编码拼接后签名形成一个JWT。形成的JWT就是一个形同111.zzz.xxx的字符串。
    
    后端将JWT字符串作为登录成功的返回结果返回给前端。前端可以将返回的结果保存在localStorage或sessionStorage上，退出登录时前端删除保存的JWT即可。
    
    前端在每次请求时将JWT放入HTTP Header中的Authorization位。(解决XSS和XSRF问题)
    
    后端检查是否存在，如存在验证JWT的有效性。例如，检查签名是否正确；检查Token是否过期；检查Token的接收方是否是自己(可选)。
    
    验证通过后后端使用JWT中包含的用户信息进行其他逻辑操作，返回相应结果。

            基于session和基于jwt的方式的主要区别就是用户的状态保存的位置，session是保存在服务端的，而jwt是保存在客户端的。
