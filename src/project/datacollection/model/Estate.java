package project.datacollection.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.datacollection.utils.DataModelArrayList;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Estate.
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class Estate extends DataModel {

    private final String estateType;
    private final String dateOfEstablishment;
    private final String name;
    
    private transient final String designation;
    private transient final String representative;
    private transient final Map<String, List<String>> websiteURLDetails;
    private transient final String addressId;
    
    private final List<Person> primaryUserList = new DataModelArrayList<Person>();
    private final List<Person> secondaryUserList = new DataModelArrayList<Person>();
    private final HashMap<String, String> attributesMap = new HashMap<>();

}
