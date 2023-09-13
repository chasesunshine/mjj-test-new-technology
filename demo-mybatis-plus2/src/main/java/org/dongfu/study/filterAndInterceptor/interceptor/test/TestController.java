package org.dongfu.study.filterAndInterceptor.interceptor.test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.cnblogs.com/nihilwater/p/13447023.html
 *
 * @Author mjj
 * @Date 17:11 2022/2/22
 * @Param
 * @return
 **/

@RestController
// canload用于检测拦截器是否正常工作
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/canload")
    public Map<String, Object> canLoad(){
        Map<String, Object> res = new HashMap<>();
        res.put("state", "ok");
        res.put("msg", "you can load");
        return res;
    }

    // login模拟登录时token返回
    @RequestMapping(value = "/login")
    public String login(){
        return "111";
    }
}
