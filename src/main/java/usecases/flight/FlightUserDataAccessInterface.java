package usecases.flight;

import entities.Flight;
import java.util.List;

public interface FlightUserDataAccessInterface {
    List<Flight> searchFlights(String destination) throws Exception;
}
