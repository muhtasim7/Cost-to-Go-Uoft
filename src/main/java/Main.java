import frameworks_drivers.ConsoleFlightSearchView;
import interface_adapters.AuthController;
import interface_adapters.FlightController;
import interface_adapters.PropertyController;
import usecases.AuthService;
import usecases.FlightRepository;
import usecases.FlightSearchUseCase;
import usecases.PropertySearchUseCase;
import frameworks_drivers.ConsoleLoginView;
import frameworks_drivers.ConsoleSignUpView;
import frameworks_drivers.ConsolePropertySearchView;
import API.AIRBNB;
import API.FLIGHT;

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

        FLIGHT flightRepo = new FLIGHT();
        FlightSearchUseCase flightSearchUseCase = new FlightSearchUseCase((FlightRepository) flightRepo);
        FlightController flightController = new FlightController(flightSearchUseCase);

        System.out.println("Welcome! Choose an option:\n1. Sign Up\n2. Login\n3. Search Properties\n4. flight");
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
        }else if(choice == 4){
            ConsoleFlightSearchView flightSearchView = new ConsoleFlightSearchView(flightController);
            flightSearchView.display();
        }else {
            System.out.println("Invalid choice.");
        }
    }
}
