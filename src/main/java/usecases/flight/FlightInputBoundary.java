package usecases.flight;

public interface FlightInputBoundary {
    /**
     * Handles flight data.
     * @param inputData the flight input data
     * @throws Exception if error occurs
     */
    void handle(FlightInputData inputData) throws Exception;

    /**
     * Switches to dashboard view.
     */
    void switchToDashboardView();
}
