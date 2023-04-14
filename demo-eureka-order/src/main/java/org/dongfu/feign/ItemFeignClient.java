package org.dongfu.feign;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/14 13:56
* @version 1.0
*/

import org.dongfu.rpc.entity.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 申明这是一个Feign客户端，并且指明服务id
 *
 * 由于我们在入口程序使用了@EnableFeignClients注解，Spring启动后会扫描标注了@FeignClient注解的接口，然后生成代理类。
 *
 * 我们在@FeignClient接口中指定了value，其实就是指定了在Eureka中的服务名称。
 *
 * 在FeignClient中的定义方法以及使用了SpringMVC的注解，Feign就会根据注解中的内容生成对应的URL，
 * 然后基于Ribbon的负载均衡去调用REST服务。
 *
 *
 * 实际开发中ItemFeignClient一般直接继承(extends)服务提供方的接口以避免代码重复
 * （例如Item工程会以jar包的形式提供ItemService接口）
 *
 */
@FeignClient(value = "app-item")
public interface ItemFeignClient {
    /**
     * 这里定义了类似于SpringMVC用法的方法，就可以进行RESTful方式的调用了
     *
     *
     * 为什么使用的是SpringMVC的注解？
     *
     * 其实，Feign是有自己的注解的@RequestLine，
     * 是因为Spring Cloud对Feign做了增强，
     * 兼容了SpringMVC的注解，使我们的学习成本更低
     *
     * 设置的默认契约是SpringMVC契约。
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    Item queryItemById(@PathVariable("id") Long id);

}