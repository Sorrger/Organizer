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
    private JButton submitButton;

    private boolean taskConfirmed = false;

    public TaskFrame(Task task, String title) {
        setModal(true);
        setTitle(title + " Task");
        setLayout(new GridLayout(6, 2));


        id = new JTextField(String.valueOf(task.getId()));
        name = new JTextArea(task.getName());
        description = new JTextArea(task.getDescription());
        priorityPanelChoice = new PriorityPanelChoice(task.getPriority());
        isDonePanelChoice = new IsDonePanelChoice(task.getIsDone());
        submitButton = new JButton(title);

        id.setEditable(false);
        id.setFocusable(false);

        add(id);
        add(name);
        add(description);
        add(priorityPanelChoice);
        add(isDonePanelChoice);
        add(submitButton);


        setSize(500, 300);
        setLocationRelativeTo(null);
        submitButton.addActionListener(e -> {
            taskConfirmed = true;
            dispose();
        });

        setVisible(true);
    }

    public boolean isTaskConfirmed() {
        return taskConfirmed;
    }

    public JButton getSubmitButton() {
        return submitButton;
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
