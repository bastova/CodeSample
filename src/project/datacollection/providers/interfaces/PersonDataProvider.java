package project.datacollection.providers.interfaces;

import java.util.List;

import project.datacollection.exceptions.DataAccessException;
import project.datacollection.model.Person;

/**
 * Person provider interface
 */
public interface PersonDataProvider {

    public List<Person> getPrimaryUsersWithAddresses(final String entityId, 
            final String estateId) throws DataAccessException;

    public List<Person> getSecondaryUsersWithAddresses(final String entityId, 
            final String estateId) throws DataAccessException;
    
    public List<Person> getPersonWithEmailOnly(final String entityId, 
            final String estateId) throws DataAccessException;
}
