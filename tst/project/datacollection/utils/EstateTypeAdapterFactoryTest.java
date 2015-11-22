package project.datacollection.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import project.datacollection.model.Estate;
import project.datacollection.model.Person;
import project.datacollection.utils.EstateTypeAdapterFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EstateTypeAdapterFactoryTest {

    EstateTypeAdapterFactory factory = new EstateTypeAdapterFactory();
 
    Gson gson = new GsonBuilder().registerTypeAdapterFactory(factory).create();
    
    @Test
    public void ShouldRemoveEmtpyPrimaryUserList() {
        Estate estate = Estate.builder().build();
        String jsonString = gson.toJson(estate);
        assertFalse(jsonString.contains("primaryUserList"));
    }
    
    @Test
    public void ShouldInlcudeNonEmptyPrimaryUserList() {
        Estate estate = Estate.builder().build();
        Person person = Person.builder().firstName("testName").build();
        estate.getPrimaryUserList().add(person);
        String jsonString = gson.toJson(business);
        assertTrue(jsonString.contains("testName"));
    }
    
    @Test
    public void ShouldRemoveEmtpyAttributeMap() {
        Estate estate = Estate.builder().build();
        String jsonString = gson.toJson(estate);
        assertFalse(jsonString.contains("attributesMap"));
    }
    
    @Test
    public void ShouldInlcudeNonEmptyAttributeMap() {
        Estate estate = Estate.builder().build();
        business.getAttributesMap().put("testKey", "testValue");
        String jsonString = gson.toJson(estate);
        assertTrue(jsonString.contains("testKey"));
        assertTrue(jsonString.contains("testValue"));
    }
}
