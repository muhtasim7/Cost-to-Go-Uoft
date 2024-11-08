package view;

import controller.AuthController;
import java.util.Scanner;

public class ConsoleLoginView {
    private final AuthController authController;

    public ConsoleLoginView(AuthController authController) {
        this.authController = authController;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login Page");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authController.login(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
