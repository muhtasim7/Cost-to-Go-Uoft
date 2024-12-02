package interface_adapters.itinerary;

import entities.Flight;
import entities.Property;
import entity_rosa.University;

import java.util.ArrayList;
import java.util.List;

public class ItineraryState {
    private List<Property> properties;
    private List<University> universities;
    private List<Flight> flights;


    public ItineraryState(List<Property> properties, List<University> universityInfo, List<Flight> flights) {
        this.properties = properties;
        this.universities = universityInfo;
        this.flights = flights;
    }

}

