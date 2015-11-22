package project.datacollection.service;

import static org.junit.Assert.*;

import org.junit.runners.MethodSorters;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.List;

import javax.inject.Inject;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        DataCollectionService.Config.class
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataCollectionServiceTest {

    @Test
    public void healthTest() {
        assertTrue(1==1);
    }
    @Configuration
    @Import({
        DataCollectionService.class
    })
    public static class Config {
        @Bean
        DataCollectionService dc() {
            
            DataCollectionService dc = mock(DataCollectionService.class);
            LegalEntityDataProvider entityService = mock(EntityDataProviderImpl.class);
            EstateDataProvider estateService = mock(EstateDataProviderImpl.class);
            PersonDataProvider personService = mock(PersonDataProviderImpl.class);
            ResponseBuilder response = mock(ResponseBuilderJSON.class);
            
            dc.setEstateService(estateService);
            dc.setEntityService(entityService);
            dc.setPersonService(personService);
            dc.setResponse(response);
            
            Entity entity = Entity.builder().
                    entityId(TEST_ENTITY_ID).domainId(TEST_DOMAIN_ID).build();
            
            legalEntity.setBusiness(estateEmpty);
            String jsonString1 = gson.toJson(legalEntity);
            
            when(dc.getRegistrationData(TEST_ENTITY_ID, TEST_DOMAIN_ID)).
                thenReturn(jsonString1);
            
            return dc;
        }
        
        @Bean
        EntityDataProvider entityService() {
            return mock(EntityDataProvider.class);
        }
        
        @Bean
        EstateDataProvider estateService() {
            return mock(EstateDataProvider.class);
        }
        
        @Bean
        PersonDataProvider personService() {
            return mock(PersonDataProviderImpl.class);
        }
        
        
        @Bean
        ResponseBuilder response() {
            return mock(ResponseBuilderJSON.class);
        }
        
        
        @Bean
        Gson gson() {
            return new Gson();
        }
    }
    
    private static final String TEST_ENTITY_ID = "1";
    private static final String TEST_DOMAIN_ID = "1";
    
    private static Estate estateEmpty = Estate.builder().build();
    
    
    private static String key = "isTop";
    private static String value = "True";
    
    private static Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(new PersonTypeAdapterFactory())
            .registerTypeAdapterFactory(new EstateTypeAdapterFactory())
            .registerTypeAdapterFactory(new EntityTypeAdapterFactory())
            .setPrettyPrinting()
            .create();
    
    @Inject
    private DataCollectionService dc;
    
    @Test
    public void test1_getRegistrationDataEmptyEstate() {
        String jsonString = dc.getRegistrationData(TEST_ENTITY_ID, TEST_DOMAIN_ID);
        Entity entity = gson.fromJson(jsonString, Entity.class);
        System.out.println(jsonString);
        assertEquals(entity.getEstate().getName(), null);
    }
    
    
}
