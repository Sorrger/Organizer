package polsl.pl;


import polsl.pl.view.AppView;

public class Main {
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AppView view = new AppView();
                view.setVisible(true);
            }
        });
    }
}