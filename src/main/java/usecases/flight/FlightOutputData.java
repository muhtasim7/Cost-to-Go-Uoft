package usecases.flight;

import java.util.List;

import entities.Flight;

public class FlightOutputData {
    private final List<Flight> flights;

    public FlightOutputData(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
