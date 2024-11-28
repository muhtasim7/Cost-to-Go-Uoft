package app;

import interface_adapters.ViewManagerModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryPresenter;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.property.PropertySelectedCallback;
import interface_adapters.property.PropertyState;
import usecases.itinerary.ItineraryDataAccessInterface;
import usecases.itinerary.ItineraryInputBoundary;
import usecases.itinerary.ItineraryInteractor;
import usecases.itinerary.ItineraryOutputBoundary;
import view.DashboardView;

public final class DashboardViewUseCaseFactory {

    private DashboardViewUseCaseFactory() {}

    public static DashboardView create(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject,
            PropertyState state) {

        final ItineraryController itineraryController =
                createItineraryUseCase(viewManagerModel, itineraryViewModel, userDataAccessObject);

        // Assign the callback to the provided state object
        PropertySelectedCallback callback = state::setSelectedProperty;

        // Pass the callback to the DashboardView
        return new DashboardView(viewManagerModel, itineraryController, state, callback);
    }

    private static ItineraryController createItineraryUseCase(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject) {
        final ItineraryOutputBoundary itineraryOutputBoundary = new ItineraryPresenter(itineraryViewModel, viewManagerModel);
        final ItineraryInputBoundary itineraryInputBoundary = new ItineraryInteractor(itineraryOutputBoundary, userDataAccessObject);
        return new ItineraryController(itineraryInputBoundary);
    }
}
