//import interface_adapters.AuthController;
//import usecases.AuthService;
//
//import java.util.Scanner;
//import frameworks_drivers.ConsoleLoginView;
//import frameworks_drivers.ConsoleSignUpView;
//
//public class Main {
//    public static void main(String[] args) {
//        AuthService authService = new AuthService();
//        AuthController authController = new AuthController(authService);
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Welcome! Choose an option:\n1. Sign Up\n2. Login");
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//
//        if (choice == 1) {
//            ConsoleSignUpView signUpView = new ConsoleSignUpView(authController);
//            signUpView.display();
//        } else if (choice == 2) {
//            ConsoleLoginView loginView = new ConsoleLoginView(authController);
//            loginView.display();
//        } else {
//            System.out.println("Invalid choice.");
//        }
//    }
//}
