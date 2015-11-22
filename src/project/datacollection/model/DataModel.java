package project.datacollection.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import lombok.extern.log4j.Log4j;


/**
 * Interface for all model types.
 */
@Log4j
public abstract class DataModel{

    @SuppressWarnings("rawtypes")
    public boolean isEmpty() {
        Field[] fields = this.getClass().asSubclass(this.getClass()).getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(this) instanceof List) {
                    if(!CollectionUtils.isEmpty((List) field.get(this))) {
                        return false;
                    }
                } else if (field.get(this) instanceof Map) {
                    if (((Map) field.get(this)) != null && !((Map) field.get(this)).isEmpty()) {
                        return false;
                    }
                } else if (field.get(this) instanceof DataModel) {
                    if((DataModel) field.get(this) != null && 
                            !((DataModel) field.get(this)).isEmpty()) {
                        return false;
                    }
                } else if (field.get(this) != null) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                log.error("Trying to access a private field: " 
                        + field.toString() 
                        +  ", call 'field.setAccessible(true)'");
            }
        }
        return true;
    }
    
    public abstract HashMap<String, String> getAttributesMap();
    
}
