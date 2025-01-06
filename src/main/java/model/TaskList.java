package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represent a Task List Manager used for managing Task List
 * @author Dawid Polczyk
 * @version 1.0
 */
public class TaskList {

    /**
     * Used for storing all Task's
     */
    private ArrayList<Task> taskList;

    /**
     * Stores a history of actions performed on the task list.
     */
    private final ArrayList<String> actionHistory = new ArrayList<>();

    /**
     * Creates a TaskList with TaskList array definition
     */
    public TaskList() {
        this.taskList = new ArrayList<>();

        taskList.add(new Task("Task 1", "Description for Task 1", Priority.HIGH, false));
        taskList.add(new Task("Task 2", "Description for Task 2", Priority.MEDIUM, false));
        taskList.add(new Task("Task 3", "Description for Task 3", Priority.LOW, true));
    }

    /** Gets TaskList taskList array
     *
     * @return ArrayList<Task> representing TaskList list of all Task's
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     * Retrieves the history of actions performed on the task list.
     *
     * @return an ArrayList of action history strings.
     */
    public ArrayList<String> getActionHistory() {
        return actionHistory;
    }

    /**Gets Task from TaskList with number in TaskList equal to the val
     *
     * @param id int representing id of Task
     * @return Task with id equal to the val
     */
    public Task getTaskById(int id) {
        return taskList.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }


    /**Sets the Task in TaskList with number in TaskList equal to the val isDone value
     *
     * @param taskId int representing id of Task
     * @param isDone boolean representing Task's isDone value
     */
    public void setTaskIsDone(int taskId, boolean isDone) {
        for (Task task : taskList) {
            if (task.getId() == taskId) {
                task.setDone(isDone);
                actionHistory.add("Task ID " + taskId + " marked as " + (isDone ? "done" : "not done"));
                break;
            }
        }
    }

    /**Remove a Task from TaskList with id
     *
     * @param id int representing id of Task
     */
    public void removeTask(int id) {
        Iterator<Task> iterator = taskList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
                actionHistory.add("Removed task: " + task.getName());
                break;
            }
        }
    }

    /**Add a Task to TaskList
     *
     * @param task Task to be added
     */
    public void addTask(Task task) {
        taskList.add(task);
        actionHistory.add("Added task: " + task.getName());
    }
}
