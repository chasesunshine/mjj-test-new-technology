package org.wanbang.exception;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.wanbang.common.Result;

import java.util.HashMap;

/**
 * @description: https://blog.csdn.net/hzz_321/article/details/81280979
 * @author majiajian
 * @date 2022/10/15 16:47
 * @version 1.0
 */

/*
 *@RestControllerAdvice是上边所说的@ResponseBody + @ControllerAdvice的组合注解
 *basePackages ：表明需要扫描当前包下的所有方法
 */
@Slf4j
@RestControllerAdvice(basePackages = "org.wanbang.controller")
public class GulimallExceptionControllerAdvice {

    //自定义校验异常处理方法，一般情况下以json的形式将异常信息返回
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleVaildException(MethodArgumentNotValidException e){
        //将错误的信息封装到map中
        HashMap<String, String> errMap = new HashMap<>();
        //log.error("数据校验出现问题{}，异常类型：{}",e.getMessage(),e.getClass());
        BindingResult result = e.getBindingResult();
        result.getFieldErrors().forEach((item) ->{
            //获取数据校验错误的属性名
            String errorField = item.getField();
            //获取数据校验错误的信息
            String errorMessage = item.getDefaultMessage();
            errMap.put(errorField,errorMessage);
        });
        return Result.error(JSON.toJSONString(errMap));
    }

//    //自定义未知异常
//    @ExceptionHandler(value = Throwable.class)
//    public R handleException(Throwable throwable){
//        log.error("错误：",throwable);
//        return Result.error(JSON.toJSONString(errMap);
//    }
}
