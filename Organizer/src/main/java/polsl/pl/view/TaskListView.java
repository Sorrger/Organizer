package polsl.pl.view;

import polsl.pl.model.TaskList.Task;
import polsl.pl.view.Controls.ButtonPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * View that represents Task List in the app
 * @author Dawid Polczyk
 * @version 1.0
 */
public class TaskListView extends BaseView {

    /**
     * JTable to display tasks
     */
    private JTable taskTable;

    /**
     * Table model for taskTable
     */
    private DefaultTableModel taskTableModel;

    /**
     * Button panel that contains all buttons used to edit tasks
     */
    private ButtonPanel taskEditButtons;

    /**
     * Creates object of TaskListView
     */
    public TaskListView() {
        String[] columnNames = {"ID", "Name", "Description", "Priority", "Done"};
        taskTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        taskTable = new JTable(taskTableModel);
        JScrollPane scrollPane = new JScrollPane(taskTable);

        taskEditButtons = new ButtonPanel("Add[Alt + A]", "Edit[Alt + F]", "FindTask[Alt + D]", "Delete[Alt + X]");

        taskEditButtons.b1.setToolTipText("Add a new task");
        taskEditButtons.b1.getAccessibleContext().setAccessibleDescription("Button to add a new task");
        taskEditButtons.b1.setMnemonic(KeyEvent.VK_A);

        taskEditButtons.b2.setToolTipText("Edit the selected task");
        taskEditButtons.b2.getAccessibleContext().setAccessibleDescription("Button to edit the selected task");
        taskEditButtons.b2.setMnemonic(KeyEvent.VK_F);

        taskEditButtons.b3.setToolTipText("Find a Task by ID");
        taskEditButtons.b3.getAccessibleContext().setAccessibleDescription("Button to mark the selected task as done");
        taskEditButtons.b3.setMnemonic(KeyEvent.VK_D);

        taskEditButtons.b4.setToolTipText("Delete the selected task");
        taskEditButtons.b4.getAccessibleContext().setAccessibleDescription("Button to delete the selected task");
        taskEditButtons.b4.setMnemonic(KeyEvent.VK_X);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(taskEditButtons, BorderLayout.SOUTH);
    }

    /** Gets the taskTableModel
     * @return DefaultTableModel representing the task table model
     */
    public DefaultTableModel getTaskTableModel() {
        return taskTableModel;
    }

    /** Gets the taskTable
     * @return JTable representing the task table
     */
    public JTable getTaskTable() {
        return taskTable;
    }

    /** Gets the TaskEditButtons
     * @return ButtonPanel representing TaskEditButtons
     */
    public ButtonPanel getTaskEditButtons() {
        return taskEditButtons;
    }
}
