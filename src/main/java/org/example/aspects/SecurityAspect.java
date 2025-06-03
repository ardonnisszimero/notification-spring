package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class SecurityAspect {
    Logger logger = Logger.getLogger(SecurityAspect.class.getName());

    @Around("@annotation(org.example.configuration.ProjectConfig.checkAccess))")
    public Object getAccess(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.log(Level.INFO, "Entering SecurityAspect.getAccess()");
        if (true) {
            throw new SecurityException("Access denied");
        }
        logger.log(Level.INFO, "Access Granted. SecurityAspect.getAccess()");
        return joinPoint.proceed();
    }

    /*
        @before annotation cannot handle procedding joint points.
        It is not set up that way :(.
     */
}
