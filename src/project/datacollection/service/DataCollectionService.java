package project.datacollection.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import project.datacollection.config.Constants;
import project.datacollection.exceptions.DataAccessException;
import project.datacollection.model.Estate;
import project.datacollection.model.Entity;
import project.datacollection.model.Person;
import project.datacollection.providers.interfaces.EstateDataProvider;
import project.datacollection.providers.interfaces.EntityDataProvider;
import project.datacollection.providers.interfaces.PersonDataProvider;
import project.datacollection.providers.interfaces.ResponseBuilder;
import lombok.Getter;
import lombok.Setter;

/**
 * Entry class being called from EntityToolsService's REST call.
 */
@Getter
@Setter
@Component
public class DataCollectionService {

    @Inject @NonNull
    private EntityDataProvider entityService;
    @Inject @NonNull
    private EstateDataProvider estateService;
    @Inject @NonNull
    private PersonDataProvider personService;
    @Inject @NonNull
    private ResponseBuilder response;
    
    @Availability
    @Latency
    @Timeout
    public String getAllEntityData(final String entityId, 
            final String domainId) throws DataAccessException {
        throw new DataAccessException(Constants.ExceptionType.METHOD_NOT_IMPLEMENTED.getValue());
    }
    
    @Availability
    @Latency
    @Timeout
    public String getRegistrationData(
            final String entityId) throws DataAccessException {
        Entity entity = entityService.getRegistrationData(entityId);
        Estate estate = Estate.builder().build();
        List<Person> primaryUsers = personService.getPersonWithEmailOnly(entityId, entity.getDomainId());
        
        estate.getPrimaryUserList().addAll(primaryUsers);
        entity.setEstate(estate);
        
        return response.entityToString(entity);
    }
}
