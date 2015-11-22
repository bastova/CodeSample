package project.datacollection.providers.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import project.datacollection.config.Constants;
import project.datacollection.exceptions.DataAccessException;
import project.datacollection.model.Estate;
import project.datacollection.providers.impl.EstateDataProviderImpl;

public class BusinessDataProviderImplTest {

    EstateDataProviderImpl businessService = new EstateDataProviderImpl();
    
    @Test
    public void GetAllBusinessData() {
        try {
            @SuppressWarnings("unused")
            Estate business = businessService.getAllEstateData("", "");
        } catch (DataAccessException e) {
            assertEquals(e.getMessage(), Constants.ExceptionType.METHOD_NOT_IMPLEMENTED.getValue());
        }
    }
}
