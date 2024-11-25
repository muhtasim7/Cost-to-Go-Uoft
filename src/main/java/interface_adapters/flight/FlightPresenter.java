package interface_adapters.flight;

import interface_adapters.ViewManagerModel;
import usecases.flight.FlightOutputBoundary;
import usecases.flight.FlightOutputData;
import view.ViewManager;

/**
 * The Presenter for the Flight Use Case.
 */
public class FlightPresenter implements FlightOutputBoundary {

    private final FlightViewModel flightViewModel;
    private final ViewManagerModel viewManagerModel;

    public FlightPresenter(FlightViewModel flightViewModel, ViewManagerModel viewManagerModel) {
        this.flightViewModel = flightViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void present(FlightOutputData data) {
        // Update the ViewModel with flight data
        flightViewModel.getState().setFlights(data.getFlights());
        flightViewModel.firePropertyChanged();
    }

    @Override
    public void handleError(String error) {
        // Handle errors if needed
        System.out.println("Error: " + error);
    }

    @Override
    public void switchToDashboardView() {
        // Switch to the dashboard using ViewManagerModel
        viewManagerModel.setState("dashboardView");
        viewManagerModel.firePropertyChanged();
    }
}

