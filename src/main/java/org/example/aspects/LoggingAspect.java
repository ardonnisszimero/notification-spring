package org.example.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Order(1)
    @Around("execution(* org.example.service.CommentService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.log(Level.INFO, "Entering " + joinPoint.getTarget().getClass().getName() + "\n");
        Object object = joinPoint.proceed();
        logger.log(Level.INFO, "Exiting " + joinPoint.getTarget().getClass().getName() + "\n");
        return object;
    }
}
