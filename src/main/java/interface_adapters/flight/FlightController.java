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
     * @param destination the destination we are searching flights for.
     */
    public void searchFlights(String destination) {
        try {
            final FlightInputData inputData = new FlightInputData(destination);
            flightInteractor.handle(inputData);
        }
        catch (Exception exception) {
            // Display the error
            System.out.println("Error occurred while searching flights: " + exception.getMessage());
        }
    }

    /**
     * Switches to the Dashboard View.
     */
    public void switchToDashboardView() {
        flightInteractor.switchToDashboardView();
    }
}

