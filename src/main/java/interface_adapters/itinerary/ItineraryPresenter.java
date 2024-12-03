package interface_adapters.itinerary;

import interface_adapters.ViewManagerModel;
import usecases.itinerary.ItineraryOutputBoundary;
import usecases.itinerary.ItineraryOutputData;

/**
 * Presenter class responsible for handling the presentation of itinerary data
 * to the user interface. The presenter processes the data received from the use case
 * and updates the ViewModel accordingly, as well as triggering changes in the view.
 * Implements the {@link ItineraryOutputBoundary} to define the methods for updating
 * the view with itinerary information.
 */
public class ItineraryPresenter implements ItineraryOutputBoundary {

    private final ItineraryViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Constructs an instance of {@link ItineraryPresenter} with the provided
     * ViewModel and ViewManagerModel.
     * The presenter updates the ViewModel and manages transitions between views
     * using the ViewManagerModel.
     *
     * @param viewModel the ViewModel responsible for holding the itinerary-related data
     * @param viewManagerModel the model responsible for managing and switching views
     */
    public ItineraryPresenter(ItineraryViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Presents the itinerary data to the view by updating the ViewModel.
     * This method receives the itinerary output data, which it uses to set the
     * state of the ViewModel. The view will be updated based on the new state.
     *
     * @param outputData the itinerary data to be presented to the view
     */
    @Override
    public void presentItinerary(ItineraryOutputData outputData) {
        ItineraryState itineraryState = new ItineraryState(outputData.getProperties(), outputData.getUniversities(),
                outputData.getFlights());
        // Set the ItineraryState in the ViewModel
        viewModel.setState(outputData);
    }

    /**
     * Switches the current view to the "itinerary view" by updating the state
     * of the ViewManagerModel. This triggers the UI to transition to the itinerary view.
     */
    @Override
    public void switchToItineraryView() {
        viewManagerModel.setState("itinerary view");
        viewManagerModel.firePropertyChanged();
    }
}
