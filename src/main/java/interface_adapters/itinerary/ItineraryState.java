package interface_adapters.itinerary;

import entities.Property;

import java.util.ArrayList;
import java.util.List;

public class ItineraryState {
    private List<Property> properties;

    public ItineraryState(List<Property> properties) {
        this.properties = properties;
    }

}

