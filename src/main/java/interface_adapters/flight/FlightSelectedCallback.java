package interface_adapters.flight;

import entities.Flight;

/**
 * Callback interface to handle selection of flight.
 * Implementations defines what to do when a flight is selected
 */
public interface FlightSelectedCallback {
    /**
     * Called when someone chooses a flight.
     * @param selectedFlight the flight selected
     */
    void onFlightSelected(Flight selectedFlight);
}
