package interface_adapters.itinerary;

import entities.Property;
import usecases.itinerary.ItineraryInputBoundary;
import interface_adapters.property.PropertyState;

public class ItineraryController {
    private final ItineraryInputBoundary inputBoundary;
//    private final PropertyState propertyState;


    public ItineraryController(ItineraryInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
//        this.propertyState = propertyState;
    }
    public void  switchToItineraryView() {inputBoundary.switchToItineraryView();}

//    public void getProperty() {
//        Property selectedProperty = propertyState.getSelectedProperty();
//        inputBoundary.handleSelectedProperty(selectedProperty);
//    }
}
