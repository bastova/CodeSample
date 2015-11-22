package project.datacollection.providers.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import lombok.Setter;

import org.springframework.stereotype.Component;

import project.datacollection.config.Constants;
import project.datacollection.exceptions.DataAccessException;
import project.datacollection.model.Person;
import project.datacollection.model.Person.PersonBuilder;
import project.datacollection.providers.interfaces.PersonDataProvider;
import project.datacollection.service.clients.NYCServiceDAO;

/**
 * Person provider.
 */
@Component
public class PersonDataProviderImpl implements PersonDataProvider {

    private static final int PAGE_SIZE = 1;
    
    @Inject @Setter
    private NYCServiceDAO nycServiceDao;
    
    public List<Person> getPersonWithEmailOnly(final String entityId, 
            final String domainId) throws DataAccessException
    {   
        List<Person> primaryUsers = new ArrayList<Person>();
        PersonBuilder personBuilder = Person.builder();
        
        String decryptedEntityId = String.valueOf(Uid.decryptUserID(entityId));
        String decryptedDomainId = String.valueOf(Uid.decryptUserID(domainId));
        
        List<MatchingUser> users = 
                nycServiceDao.searchByEntityDomain(
                        decryptedEntityId, 
                        decryptedDomainId, PAGE_SIZE);
        if (users.size() > 0) {
            if (users.get(0).getEmail().isEmpty()) {
                throw new DataAccessException(Constants.ExceptionType.NO_EMAIL.getValue() + entityId);
            }
            personBuilder.email(users.get(0).getEmail());
        } else {
            throw new DataAccessException(Constants.ExceptionType.USER_DOESNT_EXIST.getValue() + entityId);
        }
        
        Person person = personBuilder.build();
        primaryUsers.add(person);
        
        return primaryUsers;
    }


    @Override
    public List<Person> getPrimaryUsersWithAddresses(String entityId,
            String domainId) throws DataAccessException {
        throw new DataAccessException(Constants.ExceptionType.METHOD_NOT_IMPLEMENTED.getValue());
    }


    @Override
    public List<Person> getSecondaryUsersWithAddresses(String entityId,
            String domainId) throws DataAccessException {
        throw new DataAccessException(Constants.ExceptionType.METHOD_NOT_IMPLEMENTED.getValue());
    }

}
