package project.datacollection.exceptions;

/**
 * Invalid input exception
 */
public class InputValidationException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public InputValidationException(final String message) {
        super(message);
    }
}
