package project.datacollection.utils;

import project.datacollection.model.Entity;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Entity serializer
 */
public class EntityTypeAdapterFactory extends DataModelTypeAdapterFactory<Entity>{

    public EntityTypeAdapterFactory() {
        super(Entity.class);
    }
    
    @Override
    protected void beforeWrite(Entity entity, JsonElement entityJson) {
        if (entity == null) {
            return;
        }
        JsonObject entityObj = (JsonObject) entityJson;
        if (entity.getEstate() == null || entity.getEstate().isEmpty()) {
            entityObj.remove("estate");
        }
        if (entity.getAttributesMap() == null || entity.getAttributesMap().isEmpty()) {
            entityObj.remove("attributesMap");
        }
    }

}
