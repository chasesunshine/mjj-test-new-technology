package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.wanbang.entity.User;
import org.wanbang.service.UserService;
import org.wanbang.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@Slf4j
@RestController
@RequestMapping("springWordTest7")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private JwtUtil jwtUtil;

    @GetMapping("/selectOne")
    public String selectOne() {
        User user = userService.queryById((long) 1);
        return JSON.toJSONString(user);
    }

    //登录后返回token
    @GetMapping("/user/login")
    public Map<String,Object> login(User user){
        //打印输入的用户名和密码
        log.info("用户名：[{}]",user.getName());
        log.info("密码：[{}]",user.getPassword());
        //创建map，作为返回值
        HashMap<String, Object> map = new HashMap<>();
        try {
            User login = userService.login(user);
            //存储载荷声明参数map
            HashMap<String, String> plMap = new HashMap<>();
            plMap.put("username", login.getName());
            //生成JWT令牌
            String token = jwtUtil.getToken(plMap);
            //通过验证，将相关用户信息及token等存入map，用于返回
            map.put("state", true);
            map.put("msg", "认证成功");
            map.put("token", token);
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }


    //传入token，验证是否通过
    @PostMapping("/user/test1")
    public Map<String,Object> test1(String token){
        //创建map，作为返回值
        HashMap<String, Object> map = new HashMap<>();
        //打印输入的token
        log.info("当前的token为：[{}]",token);
        try {
            //通过验证，将相关用户信息及token等存入map，用于返回
            DecodedJWT verify = jwtUtil.getTokenInfo(token);   //验证令牌
            map.put("state",true);
            map.put("msg","请求成功！");
            return map;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg","无效签名");
        }catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("msg","token过期！");
        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            map.put("msg","token无效！");
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","token无效！");
        }
        //无法通过验证
        map.put("state",false);
        return map;
    }


    //添加拦截器后，不需要编写验证token的代码
    @PostMapping("/user/test")
    public Map<String,Object> test(HttpServletRequest request){
        HashMap<String, Object> map = new HashMap<>();
        //处理自己的业务逻辑
        //获取请求头中携带的token
        String token = request.getHeader("token");
        //验证token，获取token中的相关信息
        DecodedJWT verify = jwtUtil.getTokenInfo(token);
        log.info("用户名：[{}]",verify.getClaim("username").asString());
        log.info("密码：[{}]",verify.getClaim("password").asString());
        map.put("state",true);
        map.put("msg","请求成功！");
        return map;

    }


    public static void main(String[] args) {
        int[] ints = new int[10];
        System.out.println(ints[9]);

        Segment<String,String>[] segments = (Segment<String,String>[]) new Segment<?,?>[10];
        Segment<String, String> segment = segments[0];
    }

    public static class Segment<K,V> extends ReentrantLock implements Serializable {
        private static final long serialVersionUID = 2249069246763182397L;
        final float loadFactor;
        Segment(float lf) { this.loadFactor = lf; }
    }
}

