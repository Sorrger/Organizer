package polsl.pl.model.TaskList;

import java.util.ArrayList;

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
     * Creates a TaskList with TaskList array definition
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /** Gets TaskList taskList array
     * @return ArrayList<Task> representing TaskList list of all Task's
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**Gets Task from TaskList with number in TaskList equal to the val
     * @param val int representing id of Task
     * @return Task with id equal to the val
     */
    public Task getTask(int val){

        for (Task task : taskList) {
            if (task.getId() == val) {  // Assuming Task class has getId() method
                return task;
            }
        }
        return null;
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