package usecases.itinerary;
import entities.Flight;
import entity_rosa.University;
import entities.Property;

public interface ItineraryInputBoundary {
    void handleforItinerary(Property property, University university, Flight flight);
    void switchToItineraryView();
}
