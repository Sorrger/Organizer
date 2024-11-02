package polsl.pl;


import polsl.pl.view.AppView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        if (args.length < 2) {
            getUserInput();
        } else {
            String param1 = args[0];
            String param2 = args[1];
            launchApplication(param1, param2);
        }
    }

    private static void launchApplication(String param1, String param2) {
        java.awt.EventQueue.invokeLater(() -> {
            AppView view = new AppView(param1, param2);
            view.setVisible(true);
        });
    }

    private static void getUserInput() {
        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();

        Object[] message = {
                "first param:", field1,
                "second param:", field2
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Enter Tittle", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String param1 = field1.getText();
            String param2 = field2.getText();
            launchApplication(param1, param2);
        } else {
            System.exit(0);
        }
    }
}