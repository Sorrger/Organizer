package polsl.pl.view.Controls;

import javax.swing.*;
import java.awt.*;

/**
 * Represents a panel with 4 buttons in one row used for reducing code
 * @author Dawid Polczyk
 * @version 1.0
 */
public class ButtonPanel extends JPanel{
    /**
     * JButton first button in ButtonPanel button group
     */
    public JButton b1;
    /**
     * JButton second button in ButtonPanel button group
     */
    public JButton b2;
    /**
     * JButton third button in ButtonPanel button group
     */
    public JButton b3;
    /**
     * JButton fourth button in ButtonPanel button group
     */
    public JButton b4;

    /** Creates object of the ButtonPanel
     * @param b1 String representing b1 JButton text
     * @param b2 String representing b2 JButton text
     * @param b3 String representing b3 JButton text
     * @param b4 String representing b4 JButton text
     */
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
