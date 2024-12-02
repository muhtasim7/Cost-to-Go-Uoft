package entities;

import java.util.List;

import entity_rosa.University;

/**
 * Interface representing an itinerary containing the rental properties and universities.
 */
public interface Itinerary {

    /**
     * Retrieves the list of properties in the itinerary.
     *
     * @return a list of properties
     */
    List<Property> getProperty();

    /**
     * Retrieves the list of universities in the itinerary.
     *
     * @return a list of universities
     */
    List<University> getUniversity();

    // DO this later
    List<Flight> getFlights();
}
