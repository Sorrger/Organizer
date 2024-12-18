package polsl.pl.controller;

import polsl.pl.view.AppView;

/**
 * Controller used for navigation in buttons Action listener in app
 * @author Dawid Polczyk
 * @version 1.0
 */
public class AppController {
    public AppController(AppView appView){

        appView.getButtonPanel().b1.addActionListener(e -> {
            appView.getViewNavigation().showView("menuView");
        });
        appView.getButtonPanel().b2.addActionListener(e -> {
            appView.getViewNavigation().showView("taskListView");
        });
        appView.getButtonPanel().b3.addActionListener(e -> {
            System.out.println("Przycisk Inne 1 został kliknięty");
        });
        appView.getButtonPanel().b4.addActionListener(e -> {
            System.out.println("Przycisk Inne 2 został kliknięty");
        });

    }
}
