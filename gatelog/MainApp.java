package gatelog;

import ui.LoginUI;

public class MainApp {

    public static void main(String[] args) {

        if (DBConnection.getConnection() != null) {
            System.out.println("Database connected successfully!");
        } else {
            System.out.println("Database connection failed!");
            return;
        }

        LoginUI.main(args);
    }
}
