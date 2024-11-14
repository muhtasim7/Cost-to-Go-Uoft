package frameworks_drivers;

import entities.Flight;
import interface_adapters.FlightController;

import java.util.List;
import java.util.Scanner;

public class ConsoleFlightSearchView {
    private final FlightController flightController;

    public ConsoleFlightSearchView(FlightController flightController) {this.flightController = flightController;}

    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter city name:");
        String city = scanner.nextLine();

        try {
            List<Flight> flights = flightController.searchFlights(city);
            if (flights.isEmpty()) {
                System.out.println("No flights found.");
            } else {
                System.out.println("Flights found:");
                for (Flight flight : flights) {
                    System.out.println("Departure Time: " + flight.getDepartureTime());
                    System.out.println("Arrival Time: " + flight.getArrivalTime());
                    System.out.println("Arrival Airport: " + flight.getArrivalAirport());
                    System.out.println("Flight Duration: " + flight.getFlightDuration());
                    System.out.println("Layovers: " + flight.getLayovers());
                    System.out.println("price" + flight.getPrice());
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
