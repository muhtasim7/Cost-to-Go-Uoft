package usecases.itinerary;

import java.util.List;

import entities.Flight;
import entities.Property;
import entity_rosa.University;

/**
 * Interface for accessing data required for itinerary management.
 * This interface defines methods for retrieving properties, universities, and flights
 * related to a specific itinerary.
 */
public interface ItineraryDataAccessInterface {

    /**
     * Retrieves a list of properties for a specific city in the itinerary.
     *
     * @param city the name of the city for which to retrieve properties
     * @return a list of properties for the given city
     * @throws Exception if an error occurs while fetching the properties
     */
    List<Property> getPropertiesForItinerary(String city) throws Exception;

    /**
     * Retrieves a list of universities for a specific university in the itinerary.
     *
     * @param university the university for which to retrieve related universities
     * @return a list of universities related to the given university
     * @throws Exception if an error occurs while fetching the universities
     */
    List<University> getUniversitiesForItinerary(University university) throws Exception;

    /**
     * Retrieves a list of flights for a specific flight in the itinerary.
     *
     * @param flight the flight for which to retrieve related flights
     * @return a list of flights related to the given flight
     * @throws Exception if an error occurs while fetching the flights
     */
    List<Flight> getFlightsForItinerary(Flight flight) throws Exception;
}
