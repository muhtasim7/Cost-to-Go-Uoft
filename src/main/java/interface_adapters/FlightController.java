package interface_adapters;

import entities.Flight;
import usecases.FlightSearchUseCase;


import java.util.List;

public class FlightController {
    private final FlightSearchUseCase flightSearchUseCase;

    public FlightController(FlightSearchUseCase flightSearchUseCase) {
        this.flightSearchUseCase = flightSearchUseCase;
    }

    public List<Flight> searchFlights(String city) throws Exception {
        return flightSearchUseCase.searchFlights(city);
    }
}
