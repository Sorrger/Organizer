package polsl.pl.model;

import java.util.ArrayList;

/**
 * Represent a Task List Manager used for managing Task List
 * @author Dawid Polczyk
 * @version 1.0
 */
public class TaskListManager {

    /**
     * Used for storing all Task's
     */
    private ArrayList<Task> taskList;

    /**
     * Creates a TaskListManager with TaskList definition
     */
    public TaskListManager() {
        this.taskList = new ArrayList<>();
    }

    /** Gets TaskListManager TaskList
     * @return ArrayList<Task> representing TaskListManager list of all Task's
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**Gets Task from TaskList with number in TaskList equal to the val
     * @param val int representing id of Task
     * @return Task with id equal to the val
     */
    public Task getTask(int val){
        return taskList.get(val);
    }

    /**Sets the Task in TaskList with number in TaskList equal to the val isDone value
     * @param val int representing number of Task in TaskList
     * @param isDone boolean representing Task's isDone value
     */
    public void setTaskIsDone(int val, boolean isDone){
        taskList.get(val).setDone(isDone);
    }

    /**Remove a Task from TaskList with number in TaskList equal to the val
     * @param val int representing number of Task in TaskList
     */
    public void removeTask(int val){
        taskList.remove(val);
    }

    /**Add a Task to TaskList with number in TaskList equal to the val
     * @param val int representing number of Task in TaskList
     */
    public void addTask(Task val){
        taskList.add(val);
    }
    
}
