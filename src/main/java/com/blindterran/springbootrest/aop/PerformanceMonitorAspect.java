package com.blindterran.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    // Always return the data (the return type of the target object) in Around aspect.
    // Since Spring takeover the execution of the target object (method)

    // Different from Join Point, Proceeding Join Point is only for Around aspect,
    // It allows controlling method execution, it can proceed with method execution via proceed()
    @Around("execution(* com.blindterran.springbootrest.service.JobService.getAllJobs(..))")
    public Object monitorTime(ProceedingJoinPoint pjp) throws Throwable{
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("Time taken: " + (end - start) + " ms");

        return obj;
    }
}
