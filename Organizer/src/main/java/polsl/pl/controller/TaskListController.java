package polsl.pl.controller;

import polsl.pl.model.Exceptions.EmptyValueException;
import polsl.pl.model.TaskList.Priority;
import polsl.pl.model.TaskList.Task;
import polsl.pl.model.TaskList.TaskList;
import polsl.pl.model.TaskList.TaskRecord;
import polsl.pl.view.Controls.TaskFrame;
import polsl.pl.view.TaskListView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Controller for Task List in App
 * @author Dawid Polczyk
 * @version 1.0
 */
public class TaskListController {

    /**
     * TaskList view used by controller to provide user control
     * and backend
     */
    private TaskListView taskListView;
    /**
     * TaskList model used to access models data
     */
    private TaskList taskList;

    /** Used to create TaskListController object
     * @param taskListView view representing Task List Model
     */
    public TaskListController(TaskListView taskListView) {
        this.taskListView = taskListView;
        taskList = new TaskList();

        taskList.addTask(new Task("Task0", "Description 1", Priority.LOW, false));
        taskList.addTask(new Task("Task1", "Description 2", Priority.MEDIUM, false));
        taskList.addTask(new Task("Task2", "Description 3", Priority.HIGH, false));

        refreshTaskTable();

        taskListView.getTaskEditButtons().b1.addActionListener(e -> addTask());
        taskListView.getTaskEditButtons().b2.addActionListener(e -> editTask());
        taskListView.getTaskEditButtons().b3.addActionListener(e -> displayTaskByID());
        taskListView.getTaskEditButtons().b4.addActionListener(e -> deleteTask());
    }

    private void refreshTaskTable() {
        DefaultTableModel model = taskListView.getTaskTableModel();
        model.setRowCount(0);

        taskList.getTaskList().stream()
                .forEach(task -> model.addRow(new Object[]{
                        task.getId(),
                        task.getName(),
                        task.getDescription(),
                        task.getPriority(),
                        task.isDone()
                }));
    }

    /**
     * Action on button to add Task to TaskList
     */
    private void addTask() {
        Task task = new Task();
        TaskFrame taskFrame = new TaskFrame(task, "Add");

        taskFrame.getSubmitButton().addActionListener(a -> {
            try {
                task.setName(taskFrame.getTaskName());
                task.setDescription(taskFrame.getTaskDescription());
                task.setPriority(taskFrame.getTaskPriority());
                task.setDone(taskFrame.isTaskDone());

                taskList.addTask(task);
                refreshTaskTable();
                taskFrame.dispose();
            } catch (EmptyValueException ex) {
                JOptionPane.showMessageDialog(taskFrame, "Task fields cannot be empty!");
            }
        });

        taskFrame.getCancelButton().addActionListener(a -> taskFrame.dispose());
        taskFrame.setVisible(true);
    }

    /**
     * Action on button to edit Task in TaskList
     */
    private void editTask() {
        int selectedRow = taskListView.getTaskTable().getSelectedRow();
        if (selectedRow != -1) {
            Task task = taskList.getTaskList().get(selectedRow);
            TaskFrame taskFrame = new TaskFrame(task, "Edit");

            taskFrame.getSubmitButton().addActionListener(a -> {
                try {
                    task.setName(taskFrame.getTaskName());
                    task.setDescription(taskFrame.getTaskDescription());
                    task.setPriority(taskFrame.getTaskPriority());
                    task.setDone(taskFrame.isTaskDone());

                    refreshTaskTable();
                    taskFrame.dispose();
                } catch (EmptyValueException ex) {
                    JOptionPane.showMessageDialog(taskFrame, "Task fields cannot be empty!");
                }
            });

            taskFrame.getCancelButton().addActionListener(a -> taskFrame.dispose());
            taskFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No task selected for editing!");
        }
    }
    /**
     * Action on button to display Task from TaskList by Task ID
     */
    private void displayTaskByID() {
        int id  = Integer.parseInt(getUserInput());
        Task task;
        try {
            task = taskList.getTaskList().get(id);
            TaskRecord record = new TaskRecord(task.getName(), task.getDescription());
            JOptionPane.showMessageDialog(null, record);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "No task with this id in the task list!");
        }
    }
    /**
     * Action on button to delete Task from TaskList
     */
    private void deleteTask() {
        int selectedRow = taskListView.getTaskTable().getSelectedRow();
        if (selectedRow != -1) {
            taskList.getTaskList().remove(selectedRow);
            refreshTaskTable();
        } else {
            JOptionPane.showMessageDialog(null, "No task selected to delete!");
        }
    }
    /**
     * Method used to create JOption pane to get Task ID from user keyboard
     */
    private String getUserInput() {
        JTextField field = new JTextField();
        String param = "";

        Object[] message = {
                "Task ID:", field};

        int option = JOptionPane.showConfirmDialog(null, message, "Enter ID of a Task", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            param = field.getText();
        } else {
            System.exit(0);
        }
        return param;
    }
}
