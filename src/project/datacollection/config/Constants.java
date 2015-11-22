package project.datacollection.config;

import java.util.Set;

import lombok.Getter;

import com.google.common.collect.ImmutableSet;

/**
 * Constants
 */
public class Constants {
    
    /**
     * enum for exceptions.
     */
    public enum ExceptionType {
        METHOD_NOT_IMPLEMENTED("Method not implemented."),
        NO_DOMAIN_FOUND("No domain found for id "),
        NO_EMAIL("No email address: "),
        USER_DOESNT_EXIST("No user found for id: ");
        
        @Getter
        private final String value;

        private ExceptionType(final String value) {
            this.value = value;
        }
    }

    public static final String OPERATION = "Operation";
    
    public static final String START_TIME = "StartTime";
    
    public static final String TIERS_DOMAIN = "Central";
    
    public static final Set<String> TOP_TIERS = 
            (Set<String>) ImmutableSet.of("FIRST", "SECOND", "THIRD");
    public static final Set<String> BOTTOM_TIERS = 
            (Set<String>) ImmutableSet.of("LAST");
    
}
