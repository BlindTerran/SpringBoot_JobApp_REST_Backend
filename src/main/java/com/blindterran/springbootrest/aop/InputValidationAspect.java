package com.blindterran.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InputValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(InputValidationAspect.class);

    @Around("execution(* com.blindterran.springbootrest.service.JobService.getJobById(..)) && args(postId)")
    public Object validateAndUpdateGetJobPost(ProceedingJoinPoint pjp, int postId) throws Throwable {
        if (postId < 0) {
            LOGGER.info("Input before: " + postId);
            postId = -postId;
            LOGGER.info("Input after: " + postId);
        }

        Object obj = pjp.proceed(new Object[]{postId});

        return obj;
    }
}
