package polsl.pl.view;

import polsl.pl.model.Task;

import java.util.ArrayList;

/**
 * View representation of a Task List
 * @author Dawid Polczyk
 * @version 1.0
 */
public class TaskListView {

    /**
     * Creates View of a Task List
     */
    public TaskListView() {
    }

    /**Display in console a Task
     * @param val Task object
     */
    public void displayTask(Task val){
        System.out.println(val);
    }

    /**Display in console a Task List
     * @param list ArrayList<Task> Task List
     */
    public void displayTaskList(ArrayList<Task> list){
        System.out.println("Task List :\n");
        for(var val : list){
            System.out.println("->" + val);
        }
    }

    /**
     * Display in console Menu with choices for user
     */
    public void menu() {
        System.out.println("Choose mode:\n");
        System.out.println("1 - Display Tasks");
        System.out.println("2 - Delete Task");
        System.out.println("3 - Add Task");
        System.out.println("4 - Change task Done status");
        System.out.println("5 - Exit program");


    }
}
