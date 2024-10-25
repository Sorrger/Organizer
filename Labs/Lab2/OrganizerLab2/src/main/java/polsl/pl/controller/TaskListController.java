package polsl.pl.controller;

import polsl.pl.view.TaskListView;

public class TaskListController {

    private TaskListView taskListView;
    private boolean end = false;

    public TaskListController(TaskListView taskListView) {
        this.taskListView = taskListView;
    }

}
