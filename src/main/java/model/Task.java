package model;

import lombok.Getter;
import lombok.Setter;
import model.Exceptions.TaskValueCannotBeEmptyException;

/**
 * The Task class models a task with attributes such as name, description, priority, and completion status.
 * Each task is assigned a unique ID upon creation.
 * @author Dawid Polczyk
 * @version 1.0
 */
public class Task {

    /**
     * Static counter to generate unique IDs for each task.
     */
    private static int idCounter = 0;

    /**
     * The unique ID of the task.
     */
    @Getter @Setter
    private int id;

    /**
     * The name of the task. Cannot be null or empty.
     */
    @Getter
    private String name;

    /**
     * The description of the task. Cannot be null or empty.
     */
    @Getter
    private String description;

    /**
     * The priority level of the task. Defaults to LOW if not specified.
     */
    @Getter @Setter
    private Priority priority = Priority.LOW;

    /**
     * The completion status of the task. Defaults to false if not specified.
     */
    @Getter @Setter
    private boolean isDone;

    /**
     * Default constructor. Automatically assigns a unique ID to the task.
     */
    public Task() {
        id = idCounter++;
    }

    /**
     * Parameterized constructor to initialize a task with the given attributes.
     *
     * @param name The name of the task. Cannot be null or empty.
     * @param description The description of the task. Cannot be null or empty.
     * @param priority The priority level of the task.
     * @param isDone The completion status of the task.
     * @throws TaskValueCannotBeEmptyException if the name or description is null or empty.
     */
    public Task(String name, String description, Priority priority, boolean isDone) {
        if (name == null || name.isEmpty()) {
            throw new TaskValueCannotBeEmptyException("Task name cannot be empty or null", "name");
        }
        if (description == null || description.isEmpty()) {
            throw new TaskValueCannotBeEmptyException("Task description cannot be empty or null", "description");
        }
        id = idCounter++;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isDone = isDone;
    }

    /**
     * Sets the name of the task.
     *
     * @param name The name to set. Cannot be null or empty.
     * @throws TaskValueCannotBeEmptyException if the name is null or empty.
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new TaskValueCannotBeEmptyException("Task name cannot be empty or null", "name");
        }
        this.name = name;
    }

    /**
     * Sets the description of the task.
     *
     * @param description The description to set. Cannot be null or empty.
     * @throws TaskValueCannotBeEmptyException if the description is null or empty.
     */
    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new TaskValueCannotBeEmptyException("Task description cannot be empty or null", "description");
        }
        this.description = description;
    }

    /**
     * Returns a string representation of the task, including its ID, name, description, priority, and status.
     *
     * @return A string representation of the task.
     */
    @Override
    public String toString() {
        return "Task[" + id + "]{" + name + ", description=" + description +
                ", priority=" + priority + ", isDone=" + isDone + "}";
    }
}