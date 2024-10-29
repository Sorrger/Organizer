package polsl.pl.view.Controls;

import javax.swing.*;
import java.awt.*;

public class IsDonePanelChoice extends JPanel {
    private JRadioButton done;
    private JRadioButton notDone;
    private ButtonGroup buttonGroup;

    public IsDonePanelChoice(Boolean isDone) {
        this.setLayout(new GridLayout(1,2));
        done = new JRadioButton("Done");
        notDone = new JRadioButton("Not Done");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(done);
        buttonGroup.add(notDone);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(done);
        add(notDone);

        if (isDone) {
            done.setSelected(true);
        } else {
            notDone.setSelected(true);
        }
    }

    public boolean isDone() {
        return done.isSelected();
    }
}
