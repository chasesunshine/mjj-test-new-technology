package org.wanbang.aop.testaop.aopconfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)//切片执行顺序，默认为字典顺序
@Aspect
@Component
public class CalculatorAspect {

    @Pointcut("execution(public int org.wanbang.aop.testaop.service.impl.CalculatorService.*(..))")
    public void pointCut(){

    }

    //前置增强：目标方法执行之前先调用增强方法
    @Before("pointCut()")
    public void before(JoinPoint jp){
        //获取参数
        Object [] args = jp.getArgs();
        //获取方法名
        Signature signature = jp.getSignature();
        String name = signature.getName();

        System.out.println("The "+ name +" method begins.");
        System.out.println("Parameters of the "+name+" method["+args[0]+","+args[1]+"]");
    }

    //后置增强：目标方法执行之后调用增强方法
    @After("pointCut()")
    public void after(JoinPoint jp){
        //获取方法名
        Signature signature = jp.getSignature();
        String name = signature.getName();
        System.out.println("The "+ name +" method ends.");
    }

    //返回增强：目标方法执行return之后返回结果之前调用增强方法，如果出异常则不执行
    @AfterReturning(value="pointCut()",returning = "result")
    public void afterReturning(JoinPoint jp,Object result){
        //获取方法名
        Signature signature = jp.getSignature();
        String name = signature.getName();
        System.out.println("The "+ name +" method results:"+result);
    }

    //异常增强：目标方法执行产生异常调用增强方法
    @AfterThrowing(value="pointCut()",throwing = "e")
    public void afterReturning(JoinPoint jp,Exception e){
        //获取方法名
        Signature signature = jp.getSignature();
        String name = signature.getName();
        System.out.println("The "+ name +" method exception:"+e);
    }
}
