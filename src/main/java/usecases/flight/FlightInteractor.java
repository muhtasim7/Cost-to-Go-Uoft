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
        // Fetch flights from the data access interface
        List<Flight> flights = userDataAccess.searchFlights(inputData.getDestination());

        // Prepare the output data
        FlightOutputData outputData = new FlightOutputData(flights);

        // Pass the output data to the presenter
        presenter.present(outputData);
    }

    @Override
    public void switchToDashboardView() {
        presenter.switchToDashboardView();
    }
}
