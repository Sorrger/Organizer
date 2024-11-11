package polsl.pl.view;

import polsl.pl.model.TaskList.Task;
import polsl.pl.view.Controls.ButtonPanel;

import javax.swing.*;
import java.awt.*;

/**
 * View that represents Task List in the app
 * @author Dawid Polczyk
 * @version 1.0
 */
public class TaskListView extends BaseView {

    /**
     * JList that contains all tasks
     */
    private JList taskJList;
    /**
     * taskListModel used in taskJList
     */
    private DefaultListModel taskListModel;
    /**
     * Button panel that contains all buttons used to edit tasks:
     * 1 -> ADD - open new TaskFrame.java that allow us to set data of new added task
     * 1 -> EDIT - open new TaskFrame.java that allow us to edit data of selected Task in taskJList
     * 1 -> DONE - change the value of isDone of the selected Task
     * 1 -> DELETE - remove selected Task from the TaskList and the taskJList
     */
    private ButtonPanel taskEditButtons;

    /**
     * Creates object of TaskListView
     */
    public TaskListView() {
        taskListModel = new DefaultListModel();
        taskJList = new JList(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskJList);

        taskEditButtons = new ButtonPanel("Add","Edit","Done","Delete");

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(taskEditButtons, BorderLayout.SOUTH);
    }

    /** Gets the taskListModel
     * @return DefaultListModel<Task> representing the TaskListModel
     */
    public DefaultListModel<Task> getTaskListModel() {
        return taskListModel;
    }

    /** Gets the TaskJList
     * @return JList<Task> representing TaskJList
     */
    public JList<Task> getTaskJList() {
        return taskJList;
    }

    /** Gets the TaskEditButtons
     * @return ButtonPanel representing TaskEditButtons
     */
    public ButtonPanel getTaskEditButtons() {
        return taskEditButtons;
    }
}
