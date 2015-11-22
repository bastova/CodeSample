package project.datacollection.exceptions;

/**
 * Exception to indicate problem with a dependent service. 
 */
public class DependencyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DependencyException(final String message) {
        super(message);
    }

    public DependencyException(final Exception ex) {
        super(ex);
    }
}
