package polsl.pl.controller;

import polsl.pl.model.Exceptions.EmptyValueException;
import polsl.pl.model.TaskList.Priority;
import polsl.pl.model.TaskList.Task;
import polsl.pl.model.TaskList.TaskList;
import polsl.pl.view.Controls.TaskFrame;
import polsl.pl.view.TaskListView;

import javax.swing.*;


/**
 * Controller for Task List in App
 * @author Dawid Polczyk
 * @version 1.0
 */
public class TaskListController {


    /**
     * TaskListView object used for accesing view
     */
    private TaskListView taskListView;
    /**
     * TaskList model
     */
    private TaskList taskList;

    /** Used for making TaskListController object
     * @param taskListView Tasklist view
     */
    public TaskListController(TaskListView taskListView) {
        this.taskListView = taskListView;
        taskList = new TaskList();


        //przykladowe dane bo nie ma bazy dannych
        Task t1 = new Task("Task", "opis 1", Priority.LOW, false);
        Task t2 = new Task("Task", "opis 2", Priority.MEDIUM, false);
        Task t3 = new Task("Task", "opis 3", Priority.HIGH, false);
        t2.setId(1);
        t3.setId(2);
        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);

        DefaultListModel<Task> taskListModel = taskListView.getTaskListModel();
        for (Task task : taskList.getTaskList()) {
            taskListModel.addElement(task);
        }

        taskListView.getTaskEditButtons().b1.addActionListener(e -> {
            Task task = new Task();
            task.setId(taskList.getTaskList().size());
            TaskFrame taskAddFrame = new TaskFrame(task, "Add");

            taskAddFrame.getSubmitButton().addActionListener(a -> {
                boolean isValid = true;

                try {
                    task.setName(taskAddFrame.getTaskName());
                } catch (EmptyValueException e1) {
                    isValid = false;
                    JOptionPane.showMessageDialog(taskAddFrame, "Task name cannot be empty.");
                }

                try {
                    task.setDescription(taskAddFrame.getTaskDescription());
                } catch (EmptyValueException e1) {
                    isValid = false;
                    JOptionPane.showMessageDialog(taskAddFrame, "Task description cannot be empty.");
                }
                task.setPriority(taskAddFrame.getTaskPriority());
                task.setDone(taskAddFrame.isTaskDone());
                if (isValid) {
                    taskList.addTask(task);
                    taskListView.getTaskListModel().addElement(task);
                    taskAddFrame.dispose();
                }
            });

            taskAddFrame.getCancelButton().addActionListener(a -> {
                taskAddFrame.dispose();
            });

            taskAddFrame.setVisible(true);
        });




        taskListView.getTaskEditButtons().b2.addActionListener(e -> {
            int selectedIndex = taskListView.getTaskJList().getSelectedIndex();
            if (selectedIndex != -1) {
                Task selectedTask = taskList.getTaskList().get(selectedIndex);
                TaskFrame taskEditFrame = new TaskFrame(selectedTask, "Edit");

                taskEditFrame.getSubmitButton().addActionListener(a -> {
                    boolean isValid = true;

                    try {
                        selectedTask.setName(taskEditFrame.getTaskName());
                    } catch (EmptyValueException e1) {
                        isValid = false;
                        JOptionPane.showMessageDialog(taskEditFrame, "Task name cannot be empty.");
                    }

                    try {
                        selectedTask.setDescription(taskEditFrame.getTaskDescription());
                    } catch (EmptyValueException e1) {
                        isValid = false;
                        JOptionPane.showMessageDialog(taskEditFrame, "Task description cannot be empty.");
                    }

                    if (isValid) {
                        selectedTask.setPriority(taskEditFrame.getTaskPriority());
                        selectedTask.setDone(taskEditFrame.isTaskDone());

                        taskListView.getTaskListModel().set(selectedIndex, selectedTask);
                        taskEditFrame.dispose();
                    }
                });

                taskEditFrame.getCancelButton().addActionListener(a -> {
                    taskEditFrame.dispose();
                });

                taskEditFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "No task selected for editing.");
            }
        });



        taskListView.getTaskEditButtons().b3.addActionListener(e -> {
            if (taskListView.getTaskJList().getSelectedIndex() != -1) {
                if (taskListModel.getElementAt(taskListView.getTaskJList().getSelectedIndex()).getIsDone())
                    taskListModel.getElementAt(taskListView.getTaskJList().getSelectedIndex()).setDone(false);
                else
                    taskListModel.getElementAt(taskListView.getTaskJList().getSelectedIndex()).setDone(true);

                taskListView.getTaskJList().repaint();
            }else{
                JOptionPane.showMessageDialog(null, "No task selected for editing.");
            }
        });
        taskListView.getTaskEditButtons().b4.addActionListener(e -> {
            if (taskListView.getTaskJList().getSelectedIndex() != -1) {
                taskListModel.remove(taskListView.getTaskJList().getSelectedIndex());

            }else{
                JOptionPane.showMessageDialog(null, "No task selected to remove.");
            }

        });

    }


}
