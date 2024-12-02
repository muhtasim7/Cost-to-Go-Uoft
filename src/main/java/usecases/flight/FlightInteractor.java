package usecases.flight;

import entities.Flight;

import java.util.List;

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
        List<Flight> flights = userDataAccess.searchFlights(inputData.getDestination());

        FlightOutputData outputData = new FlightOutputData(flights);

        presenter.present(outputData);
    }

    @Override
    public void switchToDashboardView() {
        presenter.switchToDashboardView();
    }
}
