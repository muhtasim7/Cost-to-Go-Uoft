//package frameworks_drivers;
//
//import interface_adapters.AuthController;
//import java.util.Scanner;
//
//public class ConsoleLoginView {
//    private final AuthController authController;
//
//    public ConsoleLoginView(AuthController authController) {
//        this.authController = authController;
//    }
//
//    public void display() {
//        Scanner scanner = new Scanner(System.in);
//        boolean loggedIn = false;
//
//        while (!loggedIn) {
//            System.out.println("Login Page");
//            System.out.print("Enter username: ");
//            String username = scanner.nextLine();
//
//            System.out.print("Enter password: ");
//            String password = scanner.nextLine();
//
//            if (authController.login(username, password)) {
//                System.out.println("Login successful!");
//                loggedIn = true;  // Exit loop on success
//            } else {
//                System.out.println("Invalid username or password. Try again.");
//            }
//        }
//    }
//}
