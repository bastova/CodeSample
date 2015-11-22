package project.datacollection.providers.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import project.datacollection.config.Constants;
import project.datacollection.exceptions.DataAccessException;
import project.datacollection.model.Person;
import project.datacollection.providers.impl.PersonDataProviderImpl;

public class PersonDataProviderImplTest {
 
    PersonDataProviderImpl personService = new PersonDataProviderImpl();
    
    @Test
    public void GetBOsWithAddresses() {
        @SuppressWarnings("unused")
        List<Person> list;
        try {
            list = personService.getSecondaryUsersWithAddresses("", "");
        } catch (DataAccessException e) {
            assertEquals(e.getMessage(), Constants.ExceptionType.METHOD_NOT_IMPLEMENTED.getValue());
        }
    }
    
    @Test
    public void GetPOCsWithAddresses() {
        @SuppressWarnings("unused")
        List<Person> list;
        try {
            list = personService.getPrimaryUsersWithAddresses("", "");
        } catch (DataAccessException e) {
            assertEquals(e.getMessage(), Constants.ExceptionType.METHOD_NOT_IMPLEMENTED.getValue());
        }
    }
    
}
