package interface_adapters.property;

import entities.Property;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the state for the Property View Model.
 * This class holds the list of properties and the currently selected property.
 */
public class PropertyState {
    private List<Property> properties = new ArrayList<>();
    private Property selectedProperty;

    /**
     * Retrieves the list of properties.
     *
     * @return a List of Property objects
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * Updates the list of properties.
     *
     * @param properties a List of Property objects to set
     */
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    /**
     * Retrieves the currently selected property.
     *
     * @return the selected Property, or null if no property is selected
     */
    public Property getSelectedProperty() {
        return selectedProperty;
    }

    /**
     * Updates the currently selected property.
     *
     * @param selectedProperty the Property to set as selected
     */
    public void setSelectedProperty(Property selectedProperty) {
        this.selectedProperty = selectedProperty;
    }
}