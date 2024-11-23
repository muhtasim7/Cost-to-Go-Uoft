package interface_adapters.property;

import usecases.property.PropertyInputBoundary;
import usecases.property.PropertyInputData;

/**
 * The controller for the Property Use Case.
 */
public class PropertyController {

    private final PropertyInputBoundary propertyInteractor;

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
            // Log or display the error
            System.out.println("Error occurred while searching properties: " + e.getMessage());
        }
    }

}
