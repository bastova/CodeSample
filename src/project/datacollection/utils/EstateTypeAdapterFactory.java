package project.datacollection.utils;

import project.datacollection.model.Estate;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Estate serializer
 */
public class EstateTypeAdapterFactory extends DataModelTypeAdapterFactory<Estate>{

    public EstateTypeAdapterFactory() {
        super(Estate.class);
    }
    
    @Override
    protected void beforeWrite(Estate estate, JsonElement estateJson) {
        if (estate == null) {
            return;
        }
        JsonObject estateObj = (JsonObject) estateJson;
        if (estate.getPrimaryUserList() == null || estate.getPrimaryUserList().isEmpty()) {
            estateObj.remove("primaryUserList");
        }
        if (estate.getSecondaryUserList() == null || estate.getSecondaryUserList().isEmpty()) {
            estateObj.remove("secondaryUserList");
        }
        if (estate.getAttributesMap() == null || estate.getAttributesMap().isEmpty()) {
            estateObj.remove("attributesMap");
        }
    }

}
