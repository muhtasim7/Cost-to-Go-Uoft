package app;

import interface_adapters.ViewManagerModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryPresenter;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginController;
import interface_adapters.login.LoginPresenter;
import interface_adapters.login.LoginViewModel;
import interface_adapters.property.PropertyState;
import usecases.itinerary.ItineraryDataAccessInterface;
import usecases.itinerary.ItineraryInputBoundary;
import usecases.itinerary.ItineraryInteractor;
import usecases.itinerary.ItineraryOutputBoundary;
import usecases.login.LoginInputBoundary;
import usecases.login.LoginInteractor;
import usecases.login.LoginOutputBoundary;
import usecases.login.LoginUserDataAccessInterface;
import view.ItineraryView;
import view.LoginView;

public final class ItineraryUseCaseFactory {
    private ItineraryUseCaseFactory() {
        // Private constructor to prevent instantiation
    }

//    public static ItineraryController createItineraryController(
//            PropertyState propertyState,
//            ItineraryViewModel itineraryViewModel,
//            ItineraryDataAccessInterface itineraryDataAccessInterface, ViewManagerModel viewManagerModel
//    ) {
//        final ItineraryOutputBoundary itineraryPresenter = new ItineraryPresenter(itineraryViewModel, viewManagerModel);
//        final ItineraryInputBoundary itineraryInteractor = new ItineraryInteractor(itineraryPresenter, itineraryDataAccessInterface);
//
//        return new ItineraryController(itineraryInteractor, propertyState);
//    }

    public static ItineraryView createItineraryView(
            ItineraryController itineraryController,
            ItineraryViewModel itineraryViewModel
    ) {
        return new ItineraryView(itineraryController, itineraryViewModel);  // Now passing the correct ViewModel

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
