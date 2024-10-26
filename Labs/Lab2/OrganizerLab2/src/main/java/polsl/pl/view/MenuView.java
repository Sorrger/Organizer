package polsl.pl.view;

import javax.swing.*;
import java.awt.*;

public class MenuView extends BaseView{
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
