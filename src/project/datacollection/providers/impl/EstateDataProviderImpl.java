package project.datacollection.providers.impl;

import org.springframework.stereotype.Component;

import project.datacollection.config.Constants;
import project.datacollection.exceptions.DataAccessException;
import project.datacollection.model.Estate;
import project.datacollection.providers.interfaces.EstateDataProvider;

/**
 * Estate provider.
 */
@Component
public class EstateDataProviderImpl implements EstateDataProvider {
    
    public Estate getAllEstateData(final String estateId, 
            final String domainId) throws DataAccessException{
        throw new DataAccessException(Constants.ExceptionType.METHOD_NOT_IMPLEMENTED.getValue());
    }

}
