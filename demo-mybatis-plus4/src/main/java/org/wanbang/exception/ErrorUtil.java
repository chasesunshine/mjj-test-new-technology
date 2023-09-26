package org.wanbang.exception;
/**
* @description: TODO
* @author majiajian
* @date 2022/10/15 16:54
* @version 1.0
*/

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 全局捕获异常
 * 原理:使用AOP切面技术
 * 捕捉返回json串
 * @author hzz
 */
@ControllerAdvice(basePackages="com.demo.controller")
public class ErrorUtil {
//    //统一异常处理@ExceptionHandler,主要用于RuntimeException
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody//返回json串
//    public Map<String, Object> errorResoult(){
//        Map<String, Object> errorMap= new HashMap<String, Object>();
//        errorMap.put("errorCode", "500");
//        errorMap.put("errorMsg", "系统错误");
//        return errorMap;
//    }
}