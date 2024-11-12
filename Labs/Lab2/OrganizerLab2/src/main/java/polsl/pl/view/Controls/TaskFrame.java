package polsl.pl.view.Controls;

import polsl.pl.model.TaskList.Priority;
import polsl.pl.model.TaskList.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * JDialog window that contain all Controls that allow to set/edit data
 * of a Task added/selected in TaskListView
 * @author Dawid Polczyk
 * @version 1.0
 */
public class TaskFrame extends JDialog {
    /**
     * Used to show id of a Task set automatically
     */
    private JTextField id;
    /**
     * Used to show/edit name of a Task
     */
    private JTextArea name;
    /**
     * Used to show/edit description of a Task
     */
    private JTextArea description;
    /**
     * Used to show/set Priority value of a Task
     */
    private PriorityPanelChoice priorityPanelChoice;
    /**
     * Used to show/set isDone value of a Task
     */
    private IsDonePanelChoice isDonePanelChoice;
    /**
     * Used to submit data of Task in JDialog
     */
    private JButton submitButton;
    /**
     * Used to cancel data of Task in JDialog
     */
    private JButton cancelButton;

    /** Creates object of TaskFrame
     * @param task Used to access data of a task created in controller
     * @param title String representing tittle of the window
     */
    public TaskFrame(Task task, String title) {
        setModal(true);
        setTitle(title + " Task");
        setLayout(new GridLayout(6, 1));

        id = new JTextField(String.valueOf(task.getId()));
        name = new JTextArea(task.getName());
        description = new JTextArea(task.getDescription());
        priorityPanelChoice = new PriorityPanelChoice(task.getPriority());
        isDonePanelChoice = new IsDonePanelChoice(task.getIsDone());
        submitButton = new JButton(title + "[Alt + E]");
        cancelButton = new JButton("Cancel [Alt + Q]");

        id.setEditable(false);
        id.setFocusable(false);

        id.setToolTipText("Unique ID of the task (not editable)");
        name.setToolTipText("Enter or edit the task name");
        description.setToolTipText("Enter or edit the task description");
        priorityPanelChoice.setToolTipText("Select the task priority level");
        isDonePanelChoice.setToolTipText("Mark if the task is completed");
        submitButton.setToolTipText("Submit the changes");
        cancelButton.setToolTipText("Cancel the operation");

        id.getAccessibleContext().setAccessibleDescription("Read-only text field displaying the task ID");
        name.getAccessibleContext().setAccessibleDescription("Text area to enter or edit the task name");
        description.getAccessibleContext().setAccessibleDescription("Text area to enter or edit the task description");
        priorityPanelChoice.getAccessibleContext().setAccessibleDescription("Dropdown to select the task priority level");
        isDonePanelChoice.getAccessibleContext().setAccessibleDescription("Checkbox to indicate if the task is done");
        submitButton.getAccessibleContext().setAccessibleDescription("Button to submit changes to the task");
        cancelButton.getAccessibleContext().setAccessibleDescription("Button to cancel the operation");


        submitButton.setMnemonic(KeyEvent.VK_E);
        cancelButton.setMnemonic(KeyEvent.VK_Q);

        JPanel idPanel = new JPanel(new GridLayout());
        idPanel.add(new JLabel("ID:"));
        idPanel.add(id);

        JPanel namePanel = new JPanel(new GridLayout());
        namePanel.add(new JLabel("Name:"));
        namePanel.add(new JScrollPane(name));

        JPanel descriptionPanel = new JPanel(new GridLayout());
        descriptionPanel.add(new JLabel("Description:"));
        descriptionPanel.add(new JScrollPane(description));

        JPanel buttonPanel = new JPanel(new GridLayout());
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        add(idPanel);
        add(namePanel);
        add(descriptionPanel);
        add(priorityPanelChoice);
        add(isDonePanelChoice);
        add(buttonPanel);

        setSize(500, 300);
        setLocationRelativeTo(null);
    }


    /** Gets SubmitButton
     * @return JButton representing SubmitButton
     */
    public JButton getSubmitButton() {
        return submitButton;
    }

    /** Gets CancelButton
     * @return JButton representing CancelButton
     */
    public JButton getCancelButton() {
        return cancelButton;
    }

    /** Gets the name of a Task
     * @return String representing Task name
     */
    public String getTaskName() {
        return name.getText();
    }

    /** Gets the description of a Task
     * @return String representing Task description
     */
    public String getTaskDescription() {
        return description.getText();
    }

    /** Gets the priority value of a Task
     * @return Priority representing the Task Priority
     */
    public Priority getTaskPriority() {
        return priorityPanelChoice.getPriority();
    }

    /** Gets the isDone value of a Task
     * @return boolean value of the Task isDone
     */
    public boolean isTaskDone() {
        return isDonePanelChoice.isDone();
    }
}
