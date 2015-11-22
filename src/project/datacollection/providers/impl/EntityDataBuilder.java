package project.datacollection.providers.impl;

import java.util.List;

import javax.inject.Inject;

import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Component;

import project.datacollection.config.Constants;
import project.datacollection.model.Entity.LegalEntityBuilder;
import project.datacollection.service.clients.BOSTONServiceDAO;
import project.datacollection.service.clients.UTAHServiceDAO;

/**
 * Helper class to specify which attributes to add to the Entity
 */
@Log4j
@Component
public class EntityDataBuilder {
        
    @Inject
    private BOSTONServiceDAO bostonServiceDao;
    
    @Inject
    private UTAHServiceDAO utahServiceDao;
    
    public Attribute getPrimaryDomainId(String entityId) {
        Attribute attribute = (Attribute) bostonServiceDao.getAttribute(
                entityId, BOSTONServiceDAO.EntityAttribute.DOMAIN_ID);
        return attribute;
    }
    
    public Domain getDomainById(String domainId) {
        return bostonServiceDao.getDomainByDomainId(domainId);
    }
    
    public void addDomainId(EntityBuilder entityBuilder, Domain domain, String entityId) {
        if (domain != null) {
            entityBuilder.domainId(domain.getDomainID());
        }
    }
    
    public void addDefaultLanguageCode(EntityBuilder entityBuilder, Domain domain, String entityId) {
        if (domain != null) {
            entityBuilder.defaultLanguageCode(domain.getDefaultLanguageCode());
        }
    }
    
    public void addStatus(EntityBuilder entityBuilder, Domain domain, String entityId) {
        Attribute status = (Attribute) bostonServiceDao.getAttribute(
                entityId, 
                BOSTONServiceDAO.EntityAttribute.STATUS);
        if (status != null) {
            entityBuilder.status(status.getValue());
        }
    }
    
    public void addTier(EntityBuilder entityBuilder, String entityId, Domain domain) {
        List<TierDetails> tiers = null;
        if (domain != null) {
            tiers = utahServiceDao.getUserTiers(
                    Constants.TIERS_DOMAIN, entityId, domain.getDomainID());
        }
        if (tiers != null && !tiers.isEmpty()) {
            tiers.stream()
                .filter(details -> Constants.TOP_TIERS.contains(details.getTier()))
                .forEach(tier -> entityBuilder.isTop(tier));
        } else if (tiers == null) {
            log.error(String.format("UTAH NullPointerException on getTiers call for entity %s", entityId));
        } else if (tiers.isEmpty()) {
            log.error(String.format("UTAH getTiers returned empty list for entity %s", entityId));
        }
                
    }
    
    public void addAttribute(
            EntityBuilder entityBuilder, Domain domain, String entityId, AttributeMethod method) {
        method.addAttribute(entityBuilder, domain, entityId);
    }
    
    @FunctionalInterface
    public interface AttributeMethod {
        void addAttribute(EntityBuilder entityBuilder, Domain domain, String entityId);
    }
}