package interface_adapters.flight;

import usecases.flight.FlightInputBoundary;
import usecases.flight.FlightInputData;

/**
 * The controller for the Flight Use Case.
 */
public class FlightController {

    private final FlightInputBoundary flightInteractor;

    public FlightController(FlightInputBoundary flightInteractor) {
        this.flightInteractor = flightInteractor;
    }

    /**
     * Executes the Flight Search Use Case.
     * @param destination the destination to search flights for.
     */
    public void searchFlights(String destination) {
        try {
            final FlightInputData inputData = new FlightInputData(destination);
            flightInteractor.handle(inputData);
        } catch (Exception e) {
            // Log or display the error
            System.out.println("Error occurred while searching flights: " + e.getMessage());
        }
    }

    /**
     * Switches to the Dashboard View.
     */
    public void switchToDashboardView() {
        flightInteractor.switchToDashboardView();
    }
}

