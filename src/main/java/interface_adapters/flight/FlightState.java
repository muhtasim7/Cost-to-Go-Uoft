package interface_adapters.flight;

import entities.Flight;
import java.util.ArrayList;
import java.util.List;

/**
 * The state for the Flight View Model.
 */
public class FlightState {
    private List<Flight> flights = new ArrayList<>();
    private Flight selectedFlight; // New field to store the selected flight

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
