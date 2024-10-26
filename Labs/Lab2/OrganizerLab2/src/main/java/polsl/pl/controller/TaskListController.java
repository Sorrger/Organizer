package polsl.pl.controller;

import polsl.pl.model.TaskList.Priority;
import polsl.pl.model.TaskList.Task;
import polsl.pl.model.TaskList.TaskList;
import polsl.pl.view.TaskListView;

import javax.swing.*;


public class TaskListController {

    private TaskListView taskListView;
    private TaskList taskList;

    public TaskListController(TaskListView taskListView) {
        this.taskListView = taskListView;
        taskList = new TaskList();


        //przykladowe bo nie ma bazty dannych
        taskList.addTask(new Task("Task", "opis 1", Priority.LOW, false));
        taskList.addTask(new Task("Task", "opis 2", Priority.MEDIUM, false));
        taskList.addTask(new Task("Task", "opis 3", Priority.HIGH, false));

        DefaultListModel<Task> taskListModel = taskListView.getTaskListModel();
        for (Task task : taskList.getTaskList()) {
            taskListModel.addElement(task);
        }

    }

}
