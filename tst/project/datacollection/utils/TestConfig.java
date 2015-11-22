package project.datacollection.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class TestConfig {

    @Bean
    public AspectUtil aspectUtil() {
        return new AspectUtil();
    }
    
    @Bean
    public AspectUtilClient aspectClient() {
        return new AspectUtilClient();
    }

}
