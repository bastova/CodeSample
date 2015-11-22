package project.datacollection.model;

import java.util.HashMap;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Person.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class Person extends DataModel {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String name;
    private final String title;
    private final String phoneNumber;
    private final String email;
    
    private final HashMap<String, String> attributesMap = new HashMap<>();

}
