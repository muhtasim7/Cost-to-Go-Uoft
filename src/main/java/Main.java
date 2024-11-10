import interface_adapters.AuthController;
import interface_adapters.PropertyController;
import usecases.AuthService;
import usecases.PropertySearchUseCase;
import frameworks_drivers.ConsoleLoginView;
import frameworks_drivers.ConsoleSignUpView;
import frameworks_drivers.ConsolePropertySearchView;
import API.AIRBNB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize dependencies for authentication
        AuthService authService = new AuthService();
        AuthController authController = new AuthController(authService);

        // Initialize dependencies for property search
        AIRBNB propertyRepository = new AIRBNB();
        PropertySearchUseCase propertySearchUseCase = new PropertySearchUseCase(propertyRepository);
        PropertyController propertyController = new PropertyController(propertySearchUseCase);

        System.out.println("Welcome! Choose an option:\n1. Sign Up\n2. Login\n3. Search Properties");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            ConsoleSignUpView signUpView = new ConsoleSignUpView(authController);
            signUpView.display();
        } else if (choice == 2) {
            ConsoleLoginView loginView = new ConsoleLoginView(authController);
            loginView.display();
        } else if (choice == 3) {
            ConsolePropertySearchView propertySearchView = new ConsolePropertySearchView(propertyController);
            propertySearchView.display();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
