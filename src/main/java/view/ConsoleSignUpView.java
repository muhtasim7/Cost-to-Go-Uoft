package view;

import controller.AuthController;
import java.util.Scanner;

public class ConsoleSignUpView {
    private final AuthController authController;

    public ConsoleSignUpView(AuthController authController) {
        this.authController = authController;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean signUpComplete = false;

        while (!signUpComplete) {
            System.out.println("Sign Up Page");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (authController.signUp(username, password)) {
                System.out.println("Sign up successful!");
                signUpComplete = true;  // Exit loop on success
            } else {
                System.out.println("Sign up failed. Please try again.");
            }
        }
    }
}
