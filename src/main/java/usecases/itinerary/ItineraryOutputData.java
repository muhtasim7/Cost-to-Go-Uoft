package usecases.itinerary;

import entities.Property;
import java.util.List;

public class ItineraryOutputData {
    private final List<Property> properties;
    private final Property selectedProperty;

    public ItineraryOutputData(List<Property> properties, Property selectedProperty) {
        this.properties = properties;
        this.selectedProperty = selectedProperty;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public Property getSelectedProperty() {
        return selectedProperty;
    }
}
