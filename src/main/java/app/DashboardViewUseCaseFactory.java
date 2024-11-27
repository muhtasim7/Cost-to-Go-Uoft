package app;

import interface_adapters.ViewManagerModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryPresenter;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.logged_in.ChangePasswordController;
import interface_adapters.logged_in.LoggedInViewModel;
import usecases.change_password.ChangePasswordUserDataAccessInterface;
import usecases.itinerary.ItineraryDataAccessInterface;
import usecases.itinerary.ItineraryInputBoundary;
import usecases.itinerary.ItineraryInteractor;
import usecases.itinerary.ItineraryOutputBoundary;
import view.DashboardView;
import view.ItineraryView;
import view.LoggedInView;

public final class DashboardViewUseCaseFactory {

    private DashboardViewUseCaseFactory() {}

    public static DashboardView create(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject) {

        final ItineraryController itineraryController =
                createItineeraryUseCase(viewManagerModel, itineraryViewModel, userDataAccessObject);
        return new DashboardView(viewManagerModel, itineraryController);

    }
    private static ItineraryController createItineeraryUseCase(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject) {
        final ItineraryOutputBoundary itineraryOutputBoundary = new ItineraryPresenter(itineraryViewModel, viewManagerModel);
        final ItineraryInputBoundary itineraryInputBoundary = new ItineraryInteractor(itineraryOutputBoundary,userDataAccessObject);
        return new ItineraryController(itineraryInputBoundary);
    }
}
