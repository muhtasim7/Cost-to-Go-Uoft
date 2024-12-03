package usecases.flight;

public interface FlightOutputBoundary {
    /**
     * Presents the flight output data.
     * @param data the flight output data
     */
    void present(FlightOutputData data);

    /**
     * Switches to the dashboard view.
     */
    void switchToDashboardView();
}
