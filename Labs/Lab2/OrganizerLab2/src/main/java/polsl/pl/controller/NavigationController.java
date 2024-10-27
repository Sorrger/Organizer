package polsl.pl.controller;

import polsl.pl.view.BaseView;
import polsl.pl.view.MenuView;
import polsl.pl.view.TaskListView;


import javax.swing.*;
import java.awt.*;

public class NavigationController {

    private BaseView baseView;
    private CardLayout cardLayout;

    private TaskListView taskListView;
    private MenuView menuView;

    public NavigationController() {
        baseView = new BaseView();
        cardLayout = new CardLayout();
        baseView.setLayout(cardLayout);

        taskListView = new TaskListView();
        menuView = new MenuView();

        baseView.add(taskListView, "taskListView");
        baseView.add(menuView, "menuView");
    }

    public JPanel getMainPanel() {
        return baseView;
    }

    public TaskListView getTaskListView() {
        return taskListView;
    }

    public void showView(String viewName) {
        cardLayout.show(baseView, viewName);
    }
}
