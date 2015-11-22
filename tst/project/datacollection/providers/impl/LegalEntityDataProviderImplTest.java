package project.datacollection.providers.impl;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import project.datacollection.config.Constants;
import project.datacollection.exceptions.DataAccessException;
import project.datacollection.model.Entity;
import project.datacollection.providers.impl.EntityDataProviderImpl;

import com.google.common.collect.ImmutableSet;

public class LegalEntityDataProviderImplTest {

    EntityDataProviderImpl legalEntityService = new EntityDataProviderImpl();

    private static final String IS_PRO_KEY = "isPro";
    private static final String IS_PRO_TRUE = "True";
    private static final Set<String> PRO_TIERS = 
            (Set<String>) ImmutableSet.of("PLATINUM", "GOLD", "SILVER", "SILVER_MPBC");
    
    @Test
    public void GetAllBusinessData() {
        try {
            @SuppressWarnings("unused")
            Entity legalEntity = legalEntityService.getAllEntityData("", "");
        } catch (DataAccessException e) {
            assertEquals(e.getMessage(), Constants.ExceptionType.METHOD_NOT_IMPLEMENTED.getValue());
        }
    }
    
    @Test
    public void immutableSetShouldBeNonEmpty() {
        assertFalse(PRO_TIERS.isEmpty());
    }
    
    @Test
    public void proTiersShouldBePresentInTheSet() {
        assertTrue(PRO_TIERS.contains("SILVER"));
        assertTrue(PRO_TIERS.contains("PLATINUM"));
        assertTrue(PRO_TIERS.contains("GOLD"));
        assertTrue(PRO_TIERS.contains("SILVER_MPBC"));
    }
    
    @Test
    public void invalidTiersShouldNotBePresentInTheSet() {
        assertFalse(PRO_TIERS.contains("INDIVIDUAL"));
        assertFalse(PRO_TIERS.contains("INDIVIDUAL_MPBC"));
        assertFalse(PRO_TIERS.contains("INDVALID"));
    }
    
    @Test 
    public void legalEntityAttributesMapShouldNotBeOverwrittenByAddingProTier() {
        Entity legalEntity = Entity.builder().build();
        assertTrue(legalEntity.getAttributesMap().isEmpty());
        if (PRO_TIERS.contains("SILVER")) {
            legalEntity.getAttributesMap().put(IS_PRO_KEY, IS_PRO_TRUE);
        } 
        assertEquals(legalEntity.getAttributesMap().get(IS_PRO_KEY), "True");
    }
}
