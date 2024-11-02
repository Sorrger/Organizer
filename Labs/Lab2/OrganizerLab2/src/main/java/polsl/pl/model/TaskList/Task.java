package polsl.pl.model.TaskList;

import polsl.pl.model.Exceptions.EmptyValueException;

/**
 * Represent a Task
 */
public class Task {
    /**
     * Representing Task's id
     */
    private int id;
    /**
     * Representing Task's name
     */
    private String name;
    /**
     * Representing Task's description
     */
    private String description;
    /**
     * Represents task's priority
     */
    private Priority priority = Priority.LOW;
    /**
     * Representing Task's done value
     */
    private boolean isDone;

    /**
     * Creates Task with auto Increment id
     */
    public Task() {
    }

    /** Creates Task with auto Increment id
     * @param name Task's name
     * @param description Task's description
     * @param priority Task's priority
     * @param isDone Task's status if it is done
     */
    public Task(String name, String description, Priority priority, boolean isDone) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isDone = isDone;
    }

    /** Gets Task's id
     * @return Int representation of id
     */
    public int getId() {
        return id;
    }

    /** Gets Task's name
     * @return String representation of Task's name
     */
    public String getName() {
        return name;
    }

    /** Gets Task's description
     * @return String representation of Task's description
     */
    public String getDescription() {
        return description;
    }

    /** Gets Task's priority
     * @return Priority ENUM representation of Task's priority
     */
    public Priority getPriority() {
        return priority;
    }

    /** Gets Task's done
     * @return Booleans representation of Task's done value
     */
    public boolean getIsDone() {
        return isDone;
    }

    /** Sets the task id value
     * @param id Int representation of Task's Id
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Sets the Task's done value
     * @param done a boolean representing Task's done value
     */
    public void setDone(boolean done) {
        isDone = done;
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

    /** Sets Task's priority
     * @param priority Priority ENUM representing Task's priority
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
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