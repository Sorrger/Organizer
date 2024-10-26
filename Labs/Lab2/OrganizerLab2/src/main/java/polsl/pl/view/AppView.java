package polsl.pl.view;

import polsl.pl.controller.AppController;
import polsl.pl.controller.TaskListController;
import polsl.pl.controller.ViewNavigation;
import polsl.pl.view.Controls.ButtonPanel;

import javax.swing.*;
import java.awt.*;

public class AppView extends JFrame {

    private TaskListController taskListController;
    private ViewNavigation viewNavigation;
    private ButtonPanel buttonPanel;

    public AppView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Organizer");
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());

        viewNavigation = new ViewNavigation();
        buttonPanel = new ButtonPanel("Task List","Task List", "Inne 1", "Inne 2");

        add(viewNavigation.getMainPanel(), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        viewNavigation.showView("menuView");

        AppController appController = new AppController(this);
        taskListController = new TaskListController(viewNavigation.getTaskListView());
    }
    public ViewNavigation getViewNavigation() {
        return viewNavigation;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }
}
