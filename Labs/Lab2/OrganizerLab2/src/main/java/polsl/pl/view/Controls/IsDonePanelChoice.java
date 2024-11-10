package polsl.pl.view.Controls;

import javax.swing.*;
import java.awt.*;

/**
 * Representing a panel with 2 JRadioBox and a JLabel.
 * Used for TaskFrame to set/change the isDone option
 * @author Dawid Polczyk
 * @version 1.0
 */
public class IsDonePanelChoice extends javax.swing.JPanel {
    /**
     * JRadioButton that represent if the Task is Done
     */
    private final JRadioButton done;
    /**
     * JRadioButton that represent if the Task is not Done
     */
    private final JRadioButton notDone;
    /**
     * JLabel with text 'isDone' used for description for group
     */
    private final JLabel label;

    /** Creates object of IsDonePanelChoice
     * @param isDone Boolean used to set the value if we re editing a Task
     */
    public IsDonePanelChoice(Boolean isDone) {
        this.setLayout(new GridLayout(1,3));
        label = new JLabel("isDone:");
        done = new JRadioButton("Done");
        notDone = new JRadioButton("Not Done");
        ButtonGroup group = new ButtonGroup();
        group.add(done);
        group.add(notDone);
        if (isDone)
            done.setSelected(true);
        else
            notDone.setSelected(true);

        add(label);
        add(done);
        add(notDone);
    }

    /**
     * @return Boolean that represent isDone Task value
     */
    public boolean isDone() {
        return done.isSelected();
    }
}
