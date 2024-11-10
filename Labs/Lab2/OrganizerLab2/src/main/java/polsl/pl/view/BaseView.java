package polsl.pl.view;

import javax.swing.*;
import java.awt.*;

/**
 * Base class for main panel of the app that will contain content extending a JPanel
 * @author Dawid Polczyk
 * @version 1.0
 */
public class BaseView extends JPanel {
    /**
     * Creates object of BaseView with preferred size
     */
    public BaseView(){
        super(new BorderLayout());
        setPreferredSize(new Dimension(800, 500));
    }
}
