package project.datacollection.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectUtil {
    
    public static final String MESSAGE = "World";
    
    @Around("execution (* project.datacollection..utils.AspectUtilClient.applyMessage(..)) && args(s)")
    public Object aopSetMessage(ProceedingJoinPoint pjp, String s) throws Throwable {
        pjp.proceed();
        return MESSAGE;
    }

}
