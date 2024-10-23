package polsl.pl.view;

import polsl.pl.model.Task;

import java.util.ArrayList;

public class TaskListView {

    public TaskListView() {
    }
    public void displayTask(Task val){
        System.out.println(val);
    }
    public void displayTaskList(ArrayList<Task> list){
        System.out.println("Task List :\n");
        for(var val : list){
            System.out.println("->" + val);
        }
    }
    public void menu() {
        System.out.println("Choose mode:\n");
        System.out.println("1 - Display Tasks");
        System.out.println("2 - Delete Task");
        System.out.println("3 - Add Task");
        System.out.println("4 - Change task completion status");
        System.out.println("5 - Exit program");


    }
}
