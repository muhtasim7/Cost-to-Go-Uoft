package app;

import interface_adapters.ViewManagerModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryPresenter;
import interface_adapters.itinerary.ItineraryViewModel;
import usecases.itinerary.ItineraryDataAccessInterface;
import usecases.itinerary.ItineraryInputBoundary;
import usecases.itinerary.ItineraryInteractor;
import usecases.itinerary.ItineraryOutputBoundary;
import view.ItineraryView;

public final class ItineraryUseCaseFactory {
    private ItineraryUseCaseFactory() {
        // Private constructor to prevent instantiation
    }

    public static ItineraryView create(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject) {

        final ItineraryController itineraryController = createItineraryUseCase(viewManagerModel, itineraryViewModel, userDataAccessObject);
        return new ItineraryView(itineraryController, itineraryViewModel);
    }

    private static ItineraryController createItineraryUseCase(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject) {

        // Notice how we pass this method's parameters to the Presenter.
        final ItineraryOutputBoundary itineraryOutputBoundary = new ItineraryPresenter(itineraryViewModel, viewManagerModel);
        final ItineraryInputBoundary itineraryInteractor = new ItineraryInteractor(itineraryOutputBoundary, userDataAccessObject);
        return new ItineraryController(itineraryInteractor);
    }
}
