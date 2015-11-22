package project.datacollection.providers.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import project.datacollection.config.Constants;
import project.datacollection.exceptions.DependencyException;
import project.datacollection.exceptions.DataAccessException;
import project.datacollection.model.Entity;
import project.datacollection.providers.interfaces.EntityDataProvider;

/**
 * Entity provider
 */
@Component
public class EntityDataProviderImpl implements EntityDataProvider {
    
    @Inject
    private EntityDataBuilder entityDataBuilder;
    
    public Entity getAllEntityData(final String entityId,
            final String domainId) throws DataAccessException {
        throw new DataAccessException(Constants.ExceptionType.METHOD_NOT_IMPLEMENTED.getValue());
    }

    public Entity getRegistrationData(
            final String entityId) throws DataAccessException {
        
        EntityBuilder entityBuilder = Entity.builder().entityId(entityId);
        Domain domain = getPrimaryDomain(entityId);
        
        Entity entity = null;
        
        entityDataBuilder
            .addAttribute(entityBuilder, domain, entityId, entityDataBuilder::addDomainId);
        entityDataBuilder
            .addAttribute(entityBuilder, domain, entityId, entityDataBuilder::addDefaultLanguageCode);
        entityDataBuilder
            .addAttribute(entityBuilder, domain, entityId, entityDataBuilder::addStatus);
        entityDataBuilder
            .addAttribute(entityBuilder, domain, entityId, entityDataBuilder::addTier);
        
        if (entity == null) {
            entity = entityBuilder.build();
        }
        return entity;
    }
    
    private Domain getPrimaryDomain(String entityId) throws DataAccessException {
        Attribute attribute = entityDataBuilder.getPrimaryDomainId(entityId);
        
        if (attribute != null) {
            String domainId = "";
            String primaryDomainId = attribute.getValue();
            try {
                if (primaryDomainId.startsWith(Uid.TOKEN_USER)) {
                    return entityDataBuilder.getDomainById(primaryDomainId);
                } else {
                    long longId = Long.parseLong(primaryDomainId);
                    domainId = Uid.encryptUserId(longId);
                    return entityDataBuilder.getDomainById(domainId);
                }
            } catch (DependencyException e){
                String message = String.format(
                        Constants.ExceptionType.NO_DOMAIN_FOUND + "%s, domain %s.", entityId, domainId);
                throw new DataAccessException(message);
            }
        }
        return null;
    }
    
}
