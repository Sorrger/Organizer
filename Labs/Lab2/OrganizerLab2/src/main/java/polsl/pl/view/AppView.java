package polsl.pl.view;

import polsl.pl.controller.AppController;
import polsl.pl.controller.TaskListController;
import polsl.pl.controller.NavigationController;
import polsl.pl.view.Controls.ButtonPanel;

import javax.swing.*;
import java.awt.*;

public class AppView extends JFrame {

    private TaskListController taskListController;
    private NavigationController navigationController;
    private ButtonPanel buttonPanel;

    public AppView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Organizer");
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        navigationController = new NavigationController();
        buttonPanel = new ButtonPanel("Menu","Task List", "Inne 1", "Inne 2");

        add(navigationController.getMainPanel(), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        navigationController.showView("menuView");

        AppController appController = new AppController(this);
        taskListController = new TaskListController(navigationController.getTaskListView());
    }
    public NavigationController getViewNavigation() {
        return navigationController;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }
}
