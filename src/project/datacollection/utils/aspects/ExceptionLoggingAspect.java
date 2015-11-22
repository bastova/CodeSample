package project.datacollection.utils.aspects;

import lombok.extern.log4j.Log4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging exceptions
 */
@Log4j
@Aspect
@Component
public class ExceptionLoggingAspect {
    
    @Pointcut("execution(** project.datacollection..*.*(..)) "
          + "&& !execution(** project.datacollection.providers.impl.ResponseBuilderJSON.*(..))")
    public void interceptException() {}
  
    @AfterThrowing(pointcut = "interceptException()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) throws Exception {
        log.info(exception);
        throw exception;
    }
    
}