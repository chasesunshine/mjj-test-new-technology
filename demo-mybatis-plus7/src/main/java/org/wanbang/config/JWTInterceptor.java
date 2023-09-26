package org.wanbang.config;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.wanbang.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 在 TokenInterceptor.java 中输入以下代码，以下的代码将生成一个在请求到达controller前进行拦截的拦截器
 */
public class JWTInterceptor implements HandlerInterceptor {
    /**
     * 这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        //获取存放在请求头中的token
        String token = request.getHeader("token");
        try {
            JwtUtil.getTokenInfo(token);   //验证令牌，验证通过则返回true
            return true;
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


        //验证令牌不通过，返回false
        map.put("state",false);
        //将map转化为json，相应给前端
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }



//    public interface HandlerInterceptor {
//
//        /**
//         * 预处理回调方法，实现处理器的预处理（如检查登陆），第三个参数为响应的处理器，自定义Controller
//         * 返回值：true表示继续流程（如调用下一个拦截器或处理器）；false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
//         */
//        boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//                throws Exception;
//
//        /**
//         * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时我们可以通过modelAndView（模型和视图对象）对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
//         */
//        void postHandle(
//                HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
//                throws Exception;
//
//        /**
//         * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间，还可以进行一些资源清理，类似于try-catch-finally中的finally，但仅调用处理器执行链中
//         */
//        void afterCompletion(
//                HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//                throws Exception;
//
//    }

}

