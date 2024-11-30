package usecases.itinerary;

import entities.Property;
import java.util.List;

public class ItineraryInteractor implements ItineraryInputBoundary {

    private final ItineraryOutputBoundary outputBoundary;
    private final ItineraryDataAccessInterface dataAccess;

    // Constructor taking both output boundary and data access interface
    public ItineraryInteractor(ItineraryOutputBoundary outputBoundary, ItineraryDataAccessInterface dataAccess) {
        this.outputBoundary = outputBoundary;
        this.dataAccess = dataAccess;
    }

    @Override
    public void handleSelectedProperty(Property property) {
        try {
            // Example: Fetch properties for a specific city (this can be dynamic or passed as a parameter)
            List<Property> properties = dataAccess.getPropertiesForItinerary("Toronto");

            // You can now do any additional processing before passing data to the output boundary
            ItineraryOutputData outputData = new ItineraryOutputData(properties, property);

            // Pass the data to the output boundary (e.g., presenter)
            outputBoundary.presentItinerary(outputData);
        } catch (Exception e) {
            // Handle exceptions (e.g., data access issues) appropriately
            e.printStackTrace();
        }
    }

    @Override
    public void switchToItineraryView() {
        outputBoundary.switchToItineraryView();
    }
}
