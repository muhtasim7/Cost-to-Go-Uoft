package interface_adapters.flight;

import java.util.ArrayList;
import java.util.List;

import entities.Flight;

/**
 * The state for the Flight View Model.
 */
public class FlightState {
    private List<Flight> flights = new ArrayList<>();
    private Flight selectedFlight;

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    // Getter for selected flight
    public Flight getSelectedFlight() {
        return selectedFlight;
    }

    // Setter for selected flight
    public void setSelectedFlight(Flight selectedFlight) {
        this.selectedFlight = selectedFlight;
    }
}
