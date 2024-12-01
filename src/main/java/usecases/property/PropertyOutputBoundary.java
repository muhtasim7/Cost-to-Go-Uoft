package usecases.property;

/**
 * Interface representing the output boundary for the Property Use Case.
 * Defines the operations that the interactor can invoke on the presenter.
 */
public interface PropertyOutputBoundary {

    /**
     * Presents the output data for the Property Use Case.
     *
     * @param data the output data containing the list of properties
     */
    void present(PropertyOutputData data);

    /**
     * Switches to the dashboard view.
     * Handles the transition of the application state to the dashboard.
     */
    void switchToDashboardView();
}
