package polsl.pl.controller;

import polsl.pl.view.BaseView;
import polsl.pl.view.MenuView;
import polsl.pl.view.TaskListView;


import javax.swing.*;
import java.awt.*;

/**
 * Controller used for containing cardLayout panels in app.
 * Used for navigation
 * @author Dawid Polczyk
 * @version 1.0
 */
public class NavigationController {

    /**
     * BaseView abstract object for polymorphism
     */
    private BaseView baseView;
    /**
     * Layout object
     */
    private CardLayout cardLayout;

    /**
     * TaskListView object inheriting after baseView
     */
    private TaskListView taskListView;
    /**
     * MenuView object inheriting after baseView
     */
    private MenuView menuView;

    /**
     * Used for creating object of NavigationController.
     * Declaring baseView, cardLayout,setting layout.
     * adding to baseView taskListView, MenuView
     */
    public NavigationController() {
        baseView = new BaseView();
        cardLayout = new CardLayout();
        baseView.setLayout(cardLayout);

        taskListView = new TaskListView();
        menuView = new MenuView();

        baseView.add(taskListView, "taskListView");
        baseView.add(menuView, "menuView");
    }

    /** Returning Main Panel - base one
     * @return BaseView object representing BaseView
     */
    public JPanel getMainPanel() {
        return baseView;
    }

    /**
     * @return TaskListView object representing VIew of TaskList
     */
    public TaskListView getTaskListView() {
        return taskListView;
    }

    /** used to change the view is showing
     * @param viewName String representing the name of the view
     */
    public void showView(String viewName) {
        cardLayout.show(baseView, viewName);
    }
}
