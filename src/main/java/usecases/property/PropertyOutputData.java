package usecases.property;

import entities.Property;
import java.util.List;

/**
 * Class representing the output data for the Property Use Case.
 * Contains the list of properties to be presented.
 */
public class PropertyOutputData {
    private final List<Property> properties;

    /**
     * Constructs a new instance of PropertyOutputData.
     *
     * @param properties the list of properties to be presented
     */
    public PropertyOutputData(List<Property> properties) {
        this.properties = properties;
    }

    /**
     * Retrieves the list of properties.
     *
     * @return the list of properties
     */
    public List<Property> getProperties() {
        return properties;
    }
}
