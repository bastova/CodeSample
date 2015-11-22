package project.datacollection.providers.interfaces;

import project.datacollection.exceptions.DataAccessException;
import project.datacollection.model.Entity;

/**
 * Entity provider interface.
 */
public interface EntityDataProvider {

    public Entity getAllEntityData(
            final String entityId, final String domainId) throws DataAccessException ;
    
    public Entity getRegistrationData(final String entityId) throws DataAccessException;
}
