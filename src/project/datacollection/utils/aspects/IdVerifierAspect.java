package project.datacollection.utils.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import project.datacollection.exceptions.InputValidationException;

/**
 * Aspect for verifying user id
 */
@Aspect
@Component
public class IdVerifierAspect {
    
    @Pointcut("execution(** project.datacollection.service.DataCollectionService.*(..)) && args(id,..)")
    public void verifyUserId(String id) {}
    
    /**
     * Verify that the incoming Id is encrypted
     * @param id - user id.
     * @return the encrypted id.
     * @throws DataAccessException - if it can't be parsed or if it's decrypted.
     */
    public String getUserId(String id) throws InputValidationException {
        try {
            Uid.decryptUserID(id);
            return id.toUpperCase();
        } catch (UidException e) {
            throw new InputValidationException(String.format("Unable to decrypt user ID %s", id));
        }
    }
    
    @Around("verifyUserId(id)")
    public Object verify(ProceedingJoinPoint pjp, String id) throws Throwable, InputValidationException{
        id = getUserId(id);
        return pjp.proceed(new Object[] {id});
    }
}
