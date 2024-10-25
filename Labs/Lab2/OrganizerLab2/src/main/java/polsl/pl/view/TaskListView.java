package polsl.pl.view;

import polsl.pl.model.TaskList.Task;
import polsl.pl.view.Controls.ButtonPanel;

import javax.swing.*;
import java.awt.*;

public class TaskListView extends BaseView {

    private JList taskJList;
    private DefaultListModel taskListModel;
    private ButtonPanel taskEditButtons;

    public TaskListView() {
        //Task list here
        taskListModel = new DefaultListModel();
        taskJList = new JList(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskJList);

        //task list config buttons
        taskEditButtons = new ButtonPanel("Add","Edit","Done","Delete");

        //add to tasklistview items
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(taskEditButtons, BorderLayout.SOUTH);
    }

    public DefaultListModel<Task> getTaskListModel() {
        return taskListModel;
    }

    public JList<Task> getTaskJList() {
        return taskJList;
    }
}
