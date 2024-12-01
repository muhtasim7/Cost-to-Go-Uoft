package usecases.property;

/**
 * Interface representing the input boundary for the Property Use Case.
 * This defines the operations that the controller can invoke on the use case interactor.
 */
public interface PropertyInputBoundary {

    /**
     * Handles the input data for the Property Use Case.
     *
     * @param inputData the input data for this use case
     * @throws Exception if any issue occurs while processing the input
     */
    void handle(PropertyInputData inputData) throws Exception;

    /**
     * Switches to the dashboard view.
     * This method can be invoked to transition the application state to the dashboard.
     */
    void switchToDashboardView();
}
