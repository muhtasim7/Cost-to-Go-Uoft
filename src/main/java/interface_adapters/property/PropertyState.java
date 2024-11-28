package interface_adapters.property;

import entities.Property;
import java.util.ArrayList;
import java.util.List;

/**
 * The state for the Property View Model.
 */
public class PropertyState {
    private List<Property> properties = new ArrayList<>();
    private Property selectedProperty; // New field to store the selected property

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    // Getter for selected property
    public Property getSelectedProperty() {
        return selectedProperty;
    }

    // Setter for selected property
    public void setSelectedProperty(Property selectedProperty) {
        this.selectedProperty = selectedProperty;
    }
}