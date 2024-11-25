package usecases.property;

import entities.Property;
import java.util.List;

public class PropertyOutputData {
    private final List<Property> properties;

    public PropertyOutputData(List<Property> properties) {
        this.properties = properties;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
