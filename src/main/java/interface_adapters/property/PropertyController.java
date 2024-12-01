package interface_adapters.property;

import usecases.property.PropertyInputBoundary;
import usecases.property.PropertyInputData;

/**
 * The controller for the Property Use Case.
 * Acts as an intermediary between the user interface and the application logic.
 * Responsible for invoking the appropriate use case methods.
 */

public class PropertyController {

    private final PropertyInputBoundary propertyInteractor;

    /**
     * Constructs a new PropertyController with the specified PropertyInputBoundary.
     *
     * @param propertyInteractor the interactor handling the business logic for the Property Use Case
     */
    public PropertyController(PropertyInputBoundary propertyInteractor) {
        this.propertyInteractor = propertyInteractor;
    }

    /**
     * Executes the Property Search Use Case.
     * @param city the city to search properties in.
     */
    public void searchProperties(String city) {
        try {
            final PropertyInputData inputData = new PropertyInputData(city);
            propertyInteractor.handle(inputData);
        } catch (Exception e) {
            // Log or display the error. Recommendation by IntelJ
            System.getLogger("Error occurred while searching properties: " + e.getMessage());
        }
    }

    /**
     * Switches the application view to the dashboard.
     * Delegates the action to the interactor.
     */
    public void switchToDashboardView() {
        propertyInteractor.switchToDashboardView();
    }

}
