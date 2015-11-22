package project.datacollection.providers.interfaces;

import project.datacollection.model.Entity;

/**
 * Response builder interface
 */
public interface ResponseBuilder {
    
    public String entityToString(final Entity entity);

}
