package usecases;

import entities.Flight;

import java.util.List;

public interface FlightRepository {
    List<Flight> searchFlights(String city) throws Exception;
}
