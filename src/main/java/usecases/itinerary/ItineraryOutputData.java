package usecases.itinerary;

import java.util.List;

import entities.Flight;
import entities.Property;
import entities.University;

/**
 * Data transfer object for the itinerary output data.
 * This class encapsulates the details of the properties, universities,
 * and flights that are part of the itinerary, including the selected ones.
 */
public class ItineraryOutputData {

    private final List<Property> properties;
    private final Property selectedProperty;
    private final List<University> universities;
    private final University selectedUniversity;
    private final List<Flight> flights;
    private final Flight selectedFlight;

    /**
     * Constructs an ItineraryOutputData object with the provided lists
     * of properties, universities, and flights, along with the selected items.
     *
     * @param properties the list of properties for the itinerary
     * @param selectedProperty the selected property for the itinerary
     * @param universities the list of universities for the itinerary
     * @param selectedUniversity the selected university for the itinerary
     * @param flights the list of flights for the itinerary
     * @param selectedFlight the selected flight for the itinerary
     */
    public ItineraryOutputData(List<Property> properties, Property selectedProperty,
                               List<University> universities, University selectedUniversity, List<Flight> flights,
                               Flight selectedFlight) {
        this.properties = properties;
        this.selectedProperty = selectedProperty;
        this.universities = universities;
        this.selectedUniversity = selectedUniversity;
        this.flights = flights;
        this.selectedFlight = selectedFlight;
    }

    /**
     * Gets the list of properties in the itinerary.
     *
     * @return the list of properties
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * Gets the list of universities in the itinerary.
     *
     * @return the list of universities
     */
    public List<University> getUniversities() {
        return universities;
    }

    /**
     * Gets the selected property for the itinerary.
     *
     * @return the selected property
     */
    public Property getSelectedProperty() {
        return selectedProperty;
    }

    /**
     * Gets the list of flights in the itinerary.
     *
     * @return the list of flights
     */
    public List<Flight> getFlights() {
        return flights;
    }

    /**
     * Gets the selected flight for the itinerary.
     *
     * @return the selected flight
     */
    public Flight getSelectedFlight() {
        return selectedFlight;
    }

    public University getSelectedUniversity() {
        return selectedUniversity;
    }
}

