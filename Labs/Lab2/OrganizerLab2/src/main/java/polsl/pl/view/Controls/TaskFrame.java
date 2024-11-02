package polsl.pl.view.Controls;

import polsl.pl.model.TaskList.Priority;
import polsl.pl.model.TaskList.Task;

import javax.swing.*;
import java.awt.*;

public class TaskFrame extends JDialog {
    private JTextField id;
    private JTextArea name;
    private JTextArea description;
    private PriorityPanelChoice priorityPanelChoice;
    private IsDonePanelChoice isDonePanelChoice;
    private JButton submitButton, cancelButton;

    private boolean taskConfirmed = false;

    public TaskFrame(Task task, String title) {
        setModal(true);
        setTitle(title + " Task");
        setLayout(new GridLayout(6, 1));

        id = new JTextField(String.valueOf(task.getId()));
        name = new JTextArea(task.getName());
        description = new JTextArea(task.getDescription());
        priorityPanelChoice = new PriorityPanelChoice(task.getPriority());
        isDonePanelChoice = new IsDonePanelChoice(task.getIsDone());
        submitButton = new JButton(title);
        cancelButton = new JButton("Cancel");

        id.setEditable(false);
        id.setFocusable(false);

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


    public boolean isTaskConfirmed() {
        return taskConfirmed;
    }

    public void setTaskConfirmed(boolean taskConfirmed) {
        this.taskConfirmed = taskConfirmed;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public String getTaskName() {
        return name.getText();
    }

    public String getTaskDescription() {
        return description.getText();
    }

    public Priority getTaskPriority() {
        return priorityPanelChoice.getPriority();
    }

    public boolean isTaskDone() {
        return isDonePanelChoice.isDone();
    }
}
