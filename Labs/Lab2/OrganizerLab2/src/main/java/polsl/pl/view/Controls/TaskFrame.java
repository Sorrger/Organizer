package polsl.pl.view.Controls;

import polsl.pl.model.TaskList.Task;

import javax.swing.*;
import java.awt.*;

public class TaskFrame extends JDialog {
    private JTextField id;
    private JTextArea name;
    private JTextArea description;
    private PriorityPanelChoice priorityPanelChoice;
    private IsDonePanelChoice isDonePanelChoiceone;
    private JButton editButton;

    private boolean taskConfirmed = false;

    public TaskFrame(Task task, String title) {
        this.setModal(true);

        this.setTitle(title + " Task");
        this.setLayout(new GridLayout(6, 1));

        this.id = new JTextField(task.getId());
        this.name = new JTextArea(task.getName());
        this.description = new JTextArea(task.getDescription());
        this.priorityPanelChoice = new PriorityPanelChoice(task.getPriority());
        this.isDonePanelChoiceone = new IsDonePanelChoice(task.getIsDone());
        this.editButton = new JButton(title);

        this.add(id);
        this.add(name);
        this.add(description);
        this.add(priorityPanelChoice);
        this.add(isDonePanelChoiceone);
        this.add(editButton);

        // Action listener to save changes and close the dialog
        this.editButton.addActionListener(e -> {
            task.setName(name.getText());
            task.setDescription(description.getText());
            task.setPriority(priorityPanelChoice.getPriority());
            task.setDone(isDonePanelChoiceone.isDone());

            taskConfirmed = true;
            this.dispose();
        });

        // Set dialog size and make it visible
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Getter to check if task was confirmed
    public boolean isTaskConfirmed() {
        return taskConfirmed;
    }
}
