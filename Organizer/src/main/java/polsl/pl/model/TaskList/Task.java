package polsl.pl.model.TaskList;

import lombok.Getter;
import lombok.Setter;
import polsl.pl.model.Exceptions.EmptyValueException;

/**
 * Represent a Task
 * @author Dawid Polczyk
 * @version 1.0
 */
public class Task {

    /**
     * Used for auto incrementing id key
     */

    private static int idCounter = 0;
    /**
     * Representing Task's id
     */
    @Getter @Setter
    private int id;
    /**
     * Representing Task's name
     */
    @Getter
    private String name;
    /**
     * Representing Task's description
     */
    @Getter
    private String description;
    /**
     * Represents task's priority
     */
    @Getter @Setter
    private Priority priority = Priority.LOW;
    /**
     * Representing Task's done value
     */
    @Getter @Setter
    private boolean isDone;

    /**
     * Creates Task with auto Increment id
     */
    public Task() {
        id = idCounter++;
    }

    /** Creates Task with auto Increment id
     * @param name Task's name
     * @param description Task's description
     * @param priority Task's priority
     * @param isDone Task's status if it is done
     */
    public Task(String name, String description, Priority priority, boolean isDone) {
        id = idCounter++;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isDone = isDone;
    }

    /** Sets the Task's name
     * @param name a String representing Task's name
     */
    public void setName(String name) {
        if (name.isBlank())
            throw new EmptyValueException("Name cannot be blank.");
        else
            this.name = name;
    }


    /** Sets Task's description
     * @param description a String representing Task's description
     */
    public void setDescription(String description) {
        if (description.isBlank())
            throw new EmptyValueException("Description cannot be blank.");
        else
            this.description = description;
    }

    /**
     * @return String Representation of full Task's description
     */
    @Override
    public String toString() {
        return "Task"+"[" + id + "]" +"{\n" +  name + "description = " + description +
                " priority = " + priority + ", isDone = " + isDone + " }";
    }
}