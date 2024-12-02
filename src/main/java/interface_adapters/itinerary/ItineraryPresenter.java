package interface_adapters.itinerary;

import interface_adapters.ViewManagerModel;
import usecases.itinerary.ItineraryOutputBoundary;
import usecases.itinerary.ItineraryOutputData;

public class ItineraryPresenter implements ItineraryOutputBoundary {

    private final ItineraryViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    public ItineraryPresenter(ItineraryViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void presentItinerary(ItineraryOutputData outputData) {
        // Create the ItineraryState object with the list of properties
        ItineraryState itineraryState = new ItineraryState(outputData.getProperties(), outputData.getUniversities(), outputData.getFlights());

        // Set the ItineraryState in the ViewModel
        viewManagerModel.setState(viewManagerModel.getState());

    }

    @Override
    public void switchToItineraryView() {
        viewManagerModel.setState("itinerary view");
        viewManagerModel.firePropertyChanged();
    }
}
