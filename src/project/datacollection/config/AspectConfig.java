package project.datacollection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import project.datacollection.utils.aspects.ExceptionLoggingAspect;
import project.datacollection.utils.aspects.IdVerifierAspect;

/**
 * A bridge for spring and aspects used in this project. 
 */
@Configuration
@EnableAspectJAutoProxy
@Import({
})
public class AspectConfig {
    
    @Bean
    public ExceptionLoggingAspect exceptionMetricsAspect() {
        return new ExceptionLoggingAspect();
    }
    
    @Bean
    public IdVerifierAspect idVerifierAspect() {
        return new IdVerifierAspect();
    }

}
