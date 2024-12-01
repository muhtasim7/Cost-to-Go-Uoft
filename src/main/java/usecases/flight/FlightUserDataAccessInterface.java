package usecases.flight;

import java.util.List;

import entities.Flight;

public interface FlightUserDataAccessInterface {
    /**
     * Searches for flights according to destination.
     * @param destination the destination to search flights for
     * @return a list of flights that match the destination
     * @throws Exception if an error occurs
     */
    List<Flight> searchFlights(String destination) throws Exception;
}
