package entities;

import java.util.List;

import entities.University;

/**
 * Interface representing an itinerary containing the rental properties, universities, and flights.
 */
public interface Itinerary {

    /**
     * Retrieves the list of properties for the itinerary.
     *
     * @return a list of properties
     */
    List<Property> getProperty();

    /**
     * Retrieves the list of universities for the itinerary.
     *
     * @return a list of universities
     */
    List<University> getUniversity();

    /**
     * Retrieves the list of flights for the itinerary.
     *
     * @return a list of universities
     */
    List<Flight> getFlights();
}
