/**
 * Custom exception thrown when a required task field is empty or null.
 *
 * @author Dawid Polczyk
 * @version 1.0
 */
package model.Exceptions;

public class TaskValueCannotBeEmptyException extends RuntimeException {

  /**
   * The name of the field that caused the exception.
   */
  private final String field;

  /**
   * Constructs a new exception with the specified detail message and field name.
   *
   * @param message the detail message explaining the cause of the exception.
   * @param field the name of the field that is empty or null.
   */
  public TaskValueCannotBeEmptyException(String message, String field) {
    super(message);
    this.field = field;
  }

  /**
   * Retrieves the name of the field that caused the exception.
   *
   * @return the name of the problematic field.
   */
  public String getField() {
    return field;
  }
}
