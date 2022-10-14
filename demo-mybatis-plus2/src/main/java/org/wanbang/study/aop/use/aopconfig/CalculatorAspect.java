package org.wanbang.study.aop.use.aopconfig;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 四种增强：前置增强，后置增强，返回增强，异常增强
@Order(1)//切片执行顺序，默认为字典顺序
@Aspect
@Component
public class CalculatorAspect {

    @Pointcut("execution(public int org.wanbang.study.aop.use.service.impl.CalculatorService.*(..))")
    public void pointCut(){
    }

    //前置增强：目标方法执行之前先调用增强方法
    @Before("pointCut()")
    public void before(JoinPoint jp){
        // 下面两个数组中，参数值和参数名的个数和位置是一一对应的。
//        Object[] args = joinPoint.getArgs(); // 参数值
//        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames(); // 参数名

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


    //环绕增强
    @Around(value="pointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object result = null;
        Object target = joinPoint.getTarget();//目标对象
        String methodName = joinPoint.getSignature().getName();
        Object[] params = joinPoint.getArgs();

        try{
            try{
                //前置增强
                System.out.println(target.getClass().getName()+": The "+methodName+" method begins.");
                System.out.println(target.getClass().getName()+": Parameters of the "+methodName+"method: ["+params[0]+","+params[1]+"]");
                //执行目标对象内的方法
                result = joinPoint.proceed();
            }finally{
                //后置增强
                System.out.println(target.getClass().getName()+"：The "+methodName+" method ends.");
            }
            //返回增强
            System.out.println(target.getClass().getName()+"：Result of the "+methodName+" method："+result);
        }catch (Throwable e) {
            System.out.println(target.getClass().getName()+"：Exception of the method "+methodName+": "+e);
        }
        return result;
    }

}
