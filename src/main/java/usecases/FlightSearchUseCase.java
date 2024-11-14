package usecases;

import entities.Flight;

import java.util.List;

public class FlightSearchUseCase {
    private final FlightRepository repository;

    public FlightSearchUseCase(FlightRepository repository) {
        this.repository = repository;
    }

    public List<Flight> searchFlights(String city) throws Exception {
        return repository.searchFlights(city);
    }
}
