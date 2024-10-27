package polsl.pl.controller;

import polsl.pl.model.TaskList.Priority;
import polsl.pl.model.TaskList.Task;
import polsl.pl.model.TaskList.TaskList;
import polsl.pl.view.Controls.TaskFrame;
import polsl.pl.view.TaskListView;

import javax.swing.*;


public class TaskListController {


    private TaskListView taskListView;
    private TaskList taskList;

    public TaskListController(TaskListView taskListView) {
        this.taskListView = taskListView;
        taskList = new TaskList();


        //przykladowe dane bo nie ma bazy dannych
        taskList.addTask(new Task("Task", "opis 1", Priority.LOW, false));
        taskList.addTask(new Task("Task", "opis 2", Priority.MEDIUM, false));
        taskList.addTask(new Task("Task", "opis 3", Priority.HIGH, false));

        DefaultListModel<Task> taskListModel = taskListView.getTaskListModel();
        for (Task task : taskList.getTaskList()) {
            taskListModel.addElement(task);
        }

        taskListView.getTaskEditButtons().b1.addActionListener(e -> {
            Task task = new Task();
            TaskFrame taskFrame = new TaskFrame(task,"Add");
            if (taskFrame.isTaskConfirmed()) {
                taskList.addTask(task);
                taskListView.getTaskListModel().addElement(task);
            }
        });
        taskListView.getTaskEditButtons().b2.addActionListener(e -> {
            int selectedIndex = taskListView.getTaskJList().getSelectedIndex();
            Task selectedTask = taskList.getTaskList().get(selectedIndex);

            TaskFrame taskEditFrame = new TaskFrame(selectedTask,"Edit");
            if (taskEditFrame.isTaskConfirmed()) {
                taskListModel.set(selectedIndex, selectedTask);
            }
        });
        taskListView.getTaskEditButtons().b3.addActionListener(e -> {
            if(taskListModel.getElementAt(taskListView.getTaskJList().getSelectedIndex()).getIsDone())
                taskListModel.getElementAt(taskListView.getTaskJList().getSelectedIndex()).setDone(false);
            else
                taskListModel.getElementAt(taskListView.getTaskJList().getSelectedIndex()).setDone(true);

            taskListView.getTaskJList().repaint();
        });
        taskListView.getTaskEditButtons().b4.addActionListener(e -> {
            taskListModel.remove(taskListView.getTaskJList().getSelectedIndex());
        });

    }

}
