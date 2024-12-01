package usecases.property;

import entities.Property;
import java.util.List;


/**
 * Interface representing the data access interface for the Property Use Case.
 * Defines the operations to fetch property data from an external source.
 */
public interface PropertyUserDataAccessInterface {

    /**
     * Searches for properties in the specified city.
     *
     * @param city the name of the city to search properties in
     * @return a list of properties found in the specified city
     * @throws Exception if an error occurs during the search
     */
    List<Property> searchProperties(String city) throws Exception;
}
