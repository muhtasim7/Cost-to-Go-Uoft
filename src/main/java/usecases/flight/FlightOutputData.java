package usecases.flight;

import entities.Flight;
import java.util.List;

public class FlightOutputData {
    private final List<Flight> flights;

    public FlightOutputData(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
