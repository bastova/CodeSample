package project.datacollection.utils;

import project.datacollection.model.Person;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Person serializer
 */
public class PersonTypeAdapterFactory extends DataModelTypeAdapterFactory<Person>{

    public PersonTypeAdapterFactory() {
        super(Person.class);
    }
    
    @Override
    protected void beforeWrite(Person person, JsonElement personJson) {
        if (person == null) {
            return;
        }
        JsonObject personObj = (JsonObject) personJson;
        if (person.getAttributesMap() == null || person.getAttributesMap().isEmpty()) {
            personObj.remove("attributesMap");
        }
    }

}
