package polsl.pl.view.Controls;

import javax.swing.*;

public class IsDonePanelChoice extends javax.swing.JPanel {
    private JRadioButton done, notDone;
    public IsDonePanelChoice(Boolean isDone) {
        done = new JRadioButton("Done");
        notDone = new JRadioButton("Not Done");
        if (isDone)
            done.setSelected(true);
        else
            notDone.setSelected(true);
    }

    public boolean isDone() {
        return done.isSelected();
    }
}
