package project.datacollection.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import project.datacollection.model.Person;
import project.datacollection.utils.PersonTypeAdapterFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PersonTypeAdapterFactoryTest {

    PersonTypeAdapterFactory factory = new PersonTypeAdapterFactory();
    
    Gson gson = new GsonBuilder().registerTypeAdapterFactory(factory).create();
    
    @Test
    public void ShouldRemoveEmtpyAttributeMap() {
        Person person = Person.builder().build();
        String jsonString = gson.toJson(person);
        assertFalse(jsonString.contains("attributesMap"));
    }
    
    @Test
    public void ShouldInlcudeNonEmptyAttributeMap() {
        Person person = Person.builder().build();
        person.getAttributesMap().put("testKey", "testValue");
        String jsonString = gson.toJson(person);
        assertTrue(jsonString.contains("testKey"));
        assertTrue(jsonString.contains("testValue"));
    }
}
