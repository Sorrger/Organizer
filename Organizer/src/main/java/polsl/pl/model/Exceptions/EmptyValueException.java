package polsl.pl.model.Exceptions;

/**
 * Exception that is used when a component should contain some data, but it is empty
 * @author Dawid Polczyk
 * @version 1.0
 */
public class EmptyValueException extends RuntimeException {
    public EmptyValueException(String message) {
        super(message);
    }
}
