package org.wanbang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author mjj
 * @Date 14:30 2021/12/17
 * @Param
 * @return
 **/
@Component
@Aspect
public class TransactionDemo {

    // aop 切面能切 cglib代理 和 jdk动态代理（实现了接口的类）
    //@Pointcut("execution(public String org.wanbang.service.impl.CityServiceImpl.*(..))")
    @Pointcut("execution(public String org.wanbang.service.CityServiceTestAop.*(..))")
    public void point(){
    }

    @Before(value="point()")
    public void before(JoinPoint jp){
//        //获取参数
//        Object [] args = jp.getArgs();
//        //获取方法名
//        Signature signature = jp.getSignature();
//        String name = signature.getName();
//
//        System.out.println("The "+ name +" method begins.");
//        System.out.println("Parameters of the "+name+" method["+args[0]+","+args[1]+"]");
        System.out.println("transaction begin");
    }

    @AfterReturning(value = "point()")
    public void after(){
        System.out.println("transaction commit");
    }

    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("transaction begin");
        Object proceed = joinPoint.proceed();
        System.out.println("transaction commit");
        return proceed;
    }
}
