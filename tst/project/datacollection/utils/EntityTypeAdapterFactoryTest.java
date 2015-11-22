package project.datacollection.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import project.datacollection.model.Entity;
import project.datacollection.utils.EntityTypeAdapterFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EntityTypeAdapterFactoryTest {

    EntityTypeAdapterFactory factory = new EntityTypeAdapterFactory();
    
    Gson gson = new GsonBuilder().registerTypeAdapterFactory(factory).create();
    
    @Test
    public void ShouldRemoveEmtpyAttributeMap() {
        Entity entity = Entity.builder().build();
        String jsonString = gson.toJson(entity);
        assertFalse(jsonString.contains("attributesMap"));
    }
    
    @Test
    public void ShouldInlcudeNonEmptyAttributeMap() {
        Entity entity = Entity.builder().build();
        legalEntity.getAttributesMap().put("testKey", "testValue");
        String jsonString = gson.toJson(entity);
        assertTrue(jsonString.contains("testKey"));
        assertTrue(jsonString.contains("testValue"));
    }
}
