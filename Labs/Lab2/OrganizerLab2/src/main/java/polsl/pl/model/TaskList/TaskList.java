package polsl.pl.model.TaskList;

import java.util.ArrayList;

public class TaskList {
    
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }
    public ArrayList<Task> getTaskList() {
        return taskList;
    }    
    public Task getTaskList(int val){
        return taskList.get(val);
    }
    public void setTaskIsDone(int val, boolean isDone){
        taskList.get(val).setDone(isDone);
    }
    public void removeTask(int val){
        taskList.remove(val);
    }
    public void addTask(Task val){
        taskList.add(val);
    }
    
}
