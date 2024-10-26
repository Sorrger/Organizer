package polsl.pl.view.Controls;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel{
    public JButton b1, b2, b3, b4;
    public ButtonPanel(String b1, String b2, String b3, String b4) {
        this.setLayout(new GridLayout(1,4));

        this.b1 = new JButton(b1);
        this.b2 = new JButton(b2);
        this.b3 = new JButton(b3);
        this.b4 = new JButton(b4);
        add(this.b1);
        add(this.b2);
        add(this.b3);
        add(this.b4);
    }
}
