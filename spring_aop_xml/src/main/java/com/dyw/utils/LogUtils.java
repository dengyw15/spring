package com.dyw.utils;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class LogUtils {

    public void beforeLogs() {
        System.out.println("begin==========添加日志=============");
    }

    public void afterLogs() {
        System.out.println("after==========添加日志=============");
    }

    public void afterReturningLogs() {
        System.out.println("afterReturning==========添加日志=============");
    }

    public void afterThrowingLogs() {
        System.out.println("afterThrowing==========添加日志=============");
    }

    public Object aroundLogs(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        Arrays.asList(args).stream().forEach(System.out::println);
        Object retVal = null;
        try {
            beforeLogs();
            retVal = pjp.proceed(args);
            afterLogs();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            afterThrowingLogs();
        }
        return retVal;
    }
}
