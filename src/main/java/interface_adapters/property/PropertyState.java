package interface_adapters.property;

import entities.Property;
import java.util.ArrayList;
import java.util.List;

/**
 * The state for the Property View Model.
 */
public class PropertyState {
    private List<Property> properties = new ArrayList<>();

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
