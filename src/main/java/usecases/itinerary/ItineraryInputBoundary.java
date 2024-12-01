package usecases.itinerary;

import entities.Property;

public interface ItineraryInputBoundary {
    void handleSelectedProperty(Property property);
    void switchToItineraryView();
}
