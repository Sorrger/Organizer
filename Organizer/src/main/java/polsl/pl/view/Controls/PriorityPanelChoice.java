package polsl.pl.view.Controls;

import polsl.pl.model.TaskList.Priority;

import javax.swing.*;
import java.awt.*;

/**
 * Representing a JPanel that contains 3 JRadioButtons in one Buttongroup that is used for
 * setting/editing Priority of a Task in TaskFrame
 * @author Dawid Polczyk
 * @version 1.0
 */
public class PriorityPanelChoice extends javax.swing.JPanel {
    private JRadioButton low, medium, high;
    private ButtonGroup buttonGroup;
    private JLabel label;

    /** Creates object of a PriorityPanelChoice
     * @param priority Priority that is used to set the start value of a Priority
     */
    public PriorityPanelChoice(Priority priority) {

        this.setLayout(new GridLayout(1,4));

        low = new JRadioButton("Low");
        medium = new JRadioButton("Medium");
        high = new JRadioButton("High");
        label = new JLabel("Priority:");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(low);
        buttonGroup.add(medium);
        buttonGroup.add(high);

        this.add(label);
        this.add(low);
        this.add(medium);
        this.add(high);

        switch (priority) {
            case LOW -> low.setSelected(true);
            case MEDIUM -> medium.setSelected(true);
            case HIGH -> high.setSelected(true);
        }
    }

    /** Gets value of the selected JRadioButton in buttonGroup
     * @return Priority that represent the value of Task Priority
     */
  public Priority getPriority() {
      if (low.isSelected())
          return Priority.LOW;
      else if (medium.isSelected())
          return Priority.MEDIUM;
      else if (high.isSelected())
          return Priority.HIGH;
      return null;
  }
}
