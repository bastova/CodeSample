package project.datacollection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import project.datacollection.service.clients.NYCServiceDAO;
import project.datacollection.service.clients.BOSTONServiceDAO;
import project.datacollection.service.clients.UTAHClientFactory;
import project.datacollection.service.clients.UTAHServiceDAO;

/**
 * Services initialization
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {
        "project.datacollection"
})
public class ServiceClientsConfig {
    public static final int DELAY = 100;
    public static final int MAX_ATTEMPTS = 3;
    public static final double BACKOFF_COEFFICIENT = 1.5;

    @Bean
    BOSTONService bostonService() {
        return BOSTONServiceClient.getService();
    }
    
    @Bean
    public BOSTONServiceDAO bostonServiceDao() {
        return new BOSTONServiceDAO();
    }
    
    @Bean
    public UTAHServiceClient utahServiceClient() {
        return UTAHClientFactory.newUtahClient();
    }
    
    @Bean
    public UTAHServiceDAO utahServiceDao() {
        return new UTAHServiceDAO(utahServiceClient());
    }
    
    @Bean
    public NCYService nycService() {
        return NYCServiceClient.getService();
    }
    
    @Bean
    public NYCServiceDAO nycServiceDao() {
        return new NYCServiceDAO();
    }
    
}
