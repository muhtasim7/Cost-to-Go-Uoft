package app;

import interface_adapters.ViewManagerModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryPresenter;
import interface_adapters.itinerary.ItineraryViewModel;
import usecases.itinerary.ItineraryDataAccessInterface;
import usecases.itinerary.ItineraryInteractor;
import usecases.itinerary.ItineraryOutputBoundary;
import view.DashboardView;

public final class DashboardViewUseCaseFactory {

    private DashboardViewUseCaseFactory() {}

    public static DashboardView create(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject) {

        final ItineraryController itineraryController =
                createItineraryUseCase(viewManagerModel, itineraryViewModel, userDataAccessObject);

        // Pass the callback to the DashboardView
        return new DashboardView(viewManagerModel, itineraryController, itineraryViewModel, userDataAccessObject);
    }

    private static ItineraryController createItineraryUseCase(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject) {
        final ItineraryOutputBoundary itineraryOutputBoundary = new ItineraryPresenter(itineraryViewModel, viewManagerModel);
        final ItineraryInteractor itineraryInputBoundary = new ItineraryInteractor(itineraryOutputBoundary, userDataAccessObject);
        return new ItineraryController(itineraryInputBoundary);
    }
}
