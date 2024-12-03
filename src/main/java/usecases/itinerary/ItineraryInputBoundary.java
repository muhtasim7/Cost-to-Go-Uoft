package usecases.itinerary;

import entities.Flight;
import entities.Property;
import entity_rosa.University;

/**
 * Interface that defines the input boundary for handling itinerary-related use cases.
 * This interface is responsible for managing the data flow related to the itinerary
 * and for transitioning between views in the application.
 */
public interface ItineraryInputBoundary {

    /**
     * Handles the creation of an itinerary by processing the provided property, university, and flight data.
     *
     * @param property the property associated with the itinerary
     * @param university the university associated with the itinerary
     * @param flight the flight associated with the itinerary
     */
    void handleforItinerary(Property property, University university, Flight flight) throws Exception;

    /**
     * Switches the view to the itinerary view, typically used to update the UI or trigger view changes.
     */
    void switchToItineraryView();
}

