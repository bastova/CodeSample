package project.datacollection.providers.interfaces;

import project.datacollection.exceptions.DataAccessException;
import project.datacollection.model.Estate;

/**
 * Estate provider interface
 */
public interface EstateDataProvider {

    public Estate getAllEstateData(final String entityId, 
            final String estateId) throws DataAccessException;
    
}
