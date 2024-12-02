package usecases.itinerary;
import entities.Flight;
import entities.Property;
import entity_rosa.University;
import java.util.List;

public interface ItineraryDataAccessInterface {
    List<Property> getPropertiesForItinerary(String city) throws Exception;
    List<University> getUniversitiesForItinerary(University university) throws Exception;
    List<Flight> getFlightsForItinerary(Flight flight) throws Exception;
}
