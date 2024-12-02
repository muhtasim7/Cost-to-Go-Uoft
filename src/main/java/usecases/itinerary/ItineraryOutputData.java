package usecases.itinerary;

import entities.Flight;
import entities.Property;

import java.util.List;

import entity_rosa.University;


public class ItineraryOutputData {
    private final List<Property> properties;
    private final Property selectedProperty;
    private final List<University> universities;
    private final University selectedUniversity;
    private final List<Flight> flights;
    private final Flight selectedFlight;

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

    public List<Property> getProperties() {
        return properties;
    }
    public List<University> getUniversities() {return universities;}

    public Property getSelectedProperty() {
        return selectedProperty;
    }

    public List<Flight> getFlights() {return flights;}
}
