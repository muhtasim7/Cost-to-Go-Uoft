import controller.AuthController;
import service.AuthService;

import java.util.Scanner;
import view.ConsoleLoginView;
import view.ConsoleSignUpView;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        AuthController authController = new AuthController(authService);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Choose an option:\n1. Sign Up\n2. Login");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            ConsoleSignUpView signUpView = new ConsoleSignUpView(authController);
            signUpView.display();
        } else if (choice == 2) {
            ConsoleLoginView loginView = new ConsoleLoginView(authController);
            loginView.display();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
