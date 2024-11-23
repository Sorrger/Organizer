package polsl.pl;


import polsl.pl.view.AppView;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            launchApplication("param1", "param2");
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

}