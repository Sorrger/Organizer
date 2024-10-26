package polsl.pl.view;

import javax.swing.*;
import java.awt.*;

public class BaseView extends JPanel {
    public BaseView(){
        super(new BorderLayout());
        setPreferredSize(new Dimension(800, 500));
    }
}
