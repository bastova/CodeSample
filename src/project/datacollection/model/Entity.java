package project.datacollection.model;

import java.util.HashMap;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class Entity extends DataModel {

    private final String entityId;
    private final String domainId;
    private final String status;
    private final String registrationDate;
    private final String defaultLanguageCode;
    private final boolean isTop;
    private Estate estate;
    private final HashMap<String, String> attributesMap = new HashMap<>();
    
}
