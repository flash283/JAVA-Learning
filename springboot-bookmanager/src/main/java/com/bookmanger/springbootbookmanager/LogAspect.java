package com.bookmanger.springbootbookmanager;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {
    private static final Logger log= LoggerFactory.getLogger(LogAspect.class);
    @Around("execution(* com.bookmanger.springbootbookmanager.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        log.info("开始执行：{}", methodName);
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long cost = System.currentTimeMillis() - start;
        log.info("执行结束：{}，耗时 {}ms", methodName, cost);
        return result;
    }
}
