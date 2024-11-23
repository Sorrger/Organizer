package polsl.pl.view;

import javax.swing.*;
import java.awt.*;

/**
 * View that represent the Menu of the app extedning the BaseView
 * @author Dawid Polczyk
 * @version 1.0
 */
public class MenuView extends BaseView{
    /**
     * Creates object of the MenuView
     */
    public MenuView() {
        this.setBackground(Color.BLACK);
        JTextArea textArea = new JTextArea("MENU");
        textArea.setEditable(false);
        textArea.setBackground(Color.WHITE);
        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(textArea);
    }
}
