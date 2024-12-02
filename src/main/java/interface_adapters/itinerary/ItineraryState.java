package interface_adapters.itinerary;

import java.util.List;

import entities.Flight;
import entities.Property;
import entity_rosa.University;

/**
 * Represents the state of an itinerary, including the lists of properties,
 * universities, and flights associated with the itinerary.
 */
public class ItineraryState {

    private List<Property> properties;
    private List<University> universities;
    private List<Flight> flights;

    /**
     * Constructs an ItineraryState object with the specified lists of properties,
     * universities, and flights.
     *
     * @param properties a list of properties associated with the itinerary
     * @param universityInfo a list of universities associated with the itinerary
     * @param flights a list of flights associated with the itinerary
     */
    public ItineraryState(List<Property> properties, List<University> universityInfo, List<Flight> flights) {
        this.properties = properties;
        this.universities = universityInfo;
        this.flights = flights;
    }
}
