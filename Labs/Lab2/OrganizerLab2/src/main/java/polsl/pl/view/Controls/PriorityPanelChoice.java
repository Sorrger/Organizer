package polsl.pl.view.Controls;

import polsl.pl.model.TaskList.Priority;

import javax.swing.*;

public class PriorityPanelChoice extends javax.swing.JPanel {
    private JRadioButton low, medium, high;
    public PriorityPanelChoice(Priority priority) {
        this.add(low = new JRadioButton("Low"));
        this.add(medium = new JRadioButton("Medium"));
        this.add(high = new JRadioButton("High"));
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
