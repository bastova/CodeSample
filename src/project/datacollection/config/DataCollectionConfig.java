package project.datacollection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import project.datacollection.providers.impl.*;
import project.datacollection.providers.interfaces.*;
import project.datacollection.service.DataCollectionService;
import project.datacollection.utils.EstateTypeAdapterFactory;
import project.datacollection.utils.EntityTypeAdapterFactory;
import project.datacollection.utils.PersonTypeAdapterFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Configuration class.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {
        "project.datacollection"
})
@Import({
    ServiceClientsConfig.class,
    AspectConfig.class
})
public class DataCollectionConfig {

    @Bean
    public EstateDataProvider estateService() {
        return new EstateDataProviderImpl();
    }

    @Bean
    public EntityDataProvider entityService() {
        return new EntityDataProviderImpl();
    }

    @Bean
    public PersonDataProvider personService() {
        return new PersonDataProviderImpl();
    }
    
    @Bean
    public Gson gson(){
        return new GsonBuilder()
        .registerTypeAdapterFactory(new PersonTypeAdapterFactory())
        .registerTypeAdapterFactory(new EstateTypeAdapterFactory())
        .registerTypeAdapterFactory(new EntityTypeAdapterFactory())
        .create();
    }
    
    @Bean
    public ResponseBuilderJSON responseBuilderJson() {
        ResponseBuilderJSON responseBuilderJson = new ResponseBuilderJSON();
        responseBuilderJson.setGson(gson());
        return responseBuilderJson;
    }
    
    @Bean
    public ResponseBuilder response() {
        return responseBuilderJson();
    }
    
    @Bean
    public DataCollectionService dataCollectionService() {
        return new DataCollectionService();
    }
    
    @Bean
    public EntityDataBuilder entityDataBuilder() {
        return new EntityDataBuilder();
    }

}
