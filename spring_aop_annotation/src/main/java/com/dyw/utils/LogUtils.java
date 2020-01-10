package com.dyw.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogUtils {

    @Pointcut("execution(* com..*.*User(..))")
    public void log(){}

    @Before("log()")
    public void beforeLogs(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Arrays.asList(args).stream().forEach(System.out::println);
        System.out.println("begin==========添加日志=============");
    }

    @After("log()")
    public void afterLogs(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Arrays.asList(args).stream().forEach(System.out::println);
        System.out.println("after==========添加日志=============");
    }

    @AfterReturning(pointcut = "log()", returning = "retObj")
    public void afterReturningLogs(Object retObj) {
        System.out.println("afterReturning==========添加日志=============" + retObj);
    }

    @AfterThrowing(pointcut = "log()", throwing = "ex")
    public void afterThrowingLogs(Throwable ex) {
        System.out.println("afterThrowing==========添加日志=============" + ex);
    }

/*    @Around("log()")
    public Object aroundLogs(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        Arrays.asList(args).stream().forEach(System.out::println);
        Object retVal = null;
        try {
            System.out.println("before");
            retVal = pjp.proceed(args);
            System.out.println("after");

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("afterThrowingLogs");
        }
        return retVal;
    }*/
}
