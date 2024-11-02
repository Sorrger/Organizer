package polsl.pl.view.Controls;

import javax.swing.*;
import java.awt.*;

public class IsDonePanelChoice extends javax.swing.JPanel {
    private JRadioButton done, notDone;
    private JLabel label;
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

    public boolean isDone() {
        return done.isSelected();
    }
}
