package usecases.itinerary;

import entities.Property;
import java.util.List;

public interface ItineraryDataAccessInterface {
    List<Property> getPropertiesForItinerary(String city) throws Exception;
}
