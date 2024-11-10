package polsl.pl.view;

import polsl.pl.controller.AppController;
import polsl.pl.controller.TaskListController;
import polsl.pl.controller.NavigationController;
import polsl.pl.view.Controls.ButtonPanel;

import javax.swing.*;
import java.awt.*;

/**
 * App frame of the application using JFrame
 * @author Dawid Polczyk
 * @version 1.0
 */
public class AppView extends JFrame {

    /**
     * TaskListController object use for connecting view with functionality
     */
    private TaskListController taskListController;
    /**
     * NavigationController object used for navigating between panels in App
     */
    private NavigationController navigationController;
    /**
     * ButtonPanel object that contains buttons with navigation
     */
    private ButtonPanel buttonPanel;

    /** Used for creating object of AppView
     * @param param1 String representing first part added to tittle
     * @param param2 String representing second part added to tittle
     */
    public AppView(String param1, String param2) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Organizer - " + param1 + ", " + param2);
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

    /** Used for returning Navigation Controller
     * @return NavigationController object
     */
    public NavigationController getViewNavigation() {
        return navigationController;
    }

    /** Used for returning ButtonPanel
     * @return ButtonPanel
     */
    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }
}
