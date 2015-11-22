package project.datacollection.exceptions;

/**
 * Data exception.
 */
public class DataAccessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataAccessException(final String message) {
        super(message);
    }
}
