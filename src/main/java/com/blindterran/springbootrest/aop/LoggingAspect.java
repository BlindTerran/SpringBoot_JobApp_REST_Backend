package com.blindterran.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.blindterran.springbootrest.service.JobService.getAllJobs(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method Called: " + jp.getSignature().getName());
    }
}
