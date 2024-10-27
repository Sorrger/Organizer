package polsl.pl.view.Controls;

import polsl.pl.model.TaskList.Priority;

import javax.swing.*;

public class PriorityPanelChoice extends javax.swing.JPanel {
    private JRadioButton low, medium, high;
    private ButtonGroup buttonGroup;
    public PriorityPanelChoice(Priority priority) {

        low = new JRadioButton("Low");
        medium = new JRadioButton("Medium");
        high = new JRadioButton("High");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(low);
        buttonGroup.add(medium);
        buttonGroup.add(high);

        this.add(low);
        this.add(medium);
        this.add(high);

        switch (priority) {
            case LOW -> low.setSelected(true);
            case MEDIUM -> medium.setSelected(true);
            case HIGH -> high.setSelected(true);
        }
    }

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
