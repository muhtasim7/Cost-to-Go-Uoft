package usecases.flight;

import java.util.List;

import entities.Flight;

public class FlightInteractor implements FlightInputBoundary {
    private final FlightUserDataAccessInterface userDataAccess;
    private final FlightOutputBoundary presenter;

    public FlightInteractor(FlightUserDataAccessInterface userDataAccess, FlightOutputBoundary presenter) {
        this.userDataAccess = userDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void handle(FlightInputData inputData) throws Exception {
        // Fetch flights from data access interface, then prepare output data and pass it to presenter
        final List<Flight> flights = userDataAccess.searchFlights(inputData.getDestination());

        final FlightOutputData outputData = new FlightOutputData(flights);

        presenter.present(outputData);
    }

    @Override
    public void switchToDashboardView() {
        presenter.switchToDashboardView();
    }
}
