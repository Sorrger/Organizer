package polsl.pl;


import polsl.pl.controller.TaskListController;
import polsl.pl.model.Priority;
import polsl.pl.model.Task;
import polsl.pl.model.TaskListManager;
import polsl.pl.view.TaskListView;

public class Main {
    public static void main(String[] args) {
        TaskListView view = new TaskListView();
        TaskListManager model = new TaskListManager();

        //Example data for test
        model.addTask(new Task("Task", "opis 1", Priority.LOW, false));
        model.addTask(new Task("Task", "opis 2", Priority.MEDIUM, false));
        model.addTask(new Task("Task", "opis 3", Priority.HIGH, false));


        TaskListController controller = new TaskListController(model, view);

        controller.TaskListLoop();
    }
}