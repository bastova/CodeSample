package project.datacollection.providers.impl;

import javax.inject.Inject;

import lombok.Data;

import org.springframework.stereotype.Component;

import project.datacollection.model.Entity;
import project.datacollection.providers.interfaces.ResponseBuilder;

import com.google.gson.Gson;

/**
 * Response builder.
 */
@Component
@Data
public class ResponseBuilderJSON implements ResponseBuilder {

    @Inject private Gson gson;
    
    public String entityToString(final Entity entity) {
        return gson.toJson(entity);
    }
}
