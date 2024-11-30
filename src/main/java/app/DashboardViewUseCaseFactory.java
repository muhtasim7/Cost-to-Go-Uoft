package app;

import app_rosa.UniversitiesUseCaseFactory;
import interface_adapter_rosa.universities.UniversitiesController;
import interface_adapter_rosa.universities.UniversitiesPresenter;
import interface_adapter_rosa.universities.UniversitiesViewModel;
import interface_adapters.ViewManagerModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryPresenter;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.logged_in.LoggedInState;
import interface_adapters.logged_in.LoggedInViewModel;
import use_case_rosa.universities.UniversitiesDataAccessInterface;
import use_case_rosa.universities.UniversitiesInputBoundary;
import use_case_rosa.universities.UniversitiesInteractor;
import use_case_rosa.universities.UniversitiesOutputBoundary;
import use_case_rosa.universities.UniversitiesUserDataAccessInterface; // Import added
import usecases.itinerary.ItineraryDataAccessInterface;
import usecases.itinerary.ItineraryInteractor;
import usecases.itinerary.ItineraryOutputBoundary;
import usecases.login.LoginUserDataAccessInterface;
import view.DashboardView;
import view_rosa.UniversitiesView;

public final class DashboardViewUseCaseFactory {

    private DashboardViewUseCaseFactory() {
    }

    public static DashboardView create(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject,
            UniversitiesViewModel universitiesViewModel,
            UniversitiesDataAccessInterface uniDataAccessObject,
            UniversitiesUserDataAccessInterface universitiesUserDataAccessObject) {

        final ItineraryController itineraryController =
                createItineraryUseCase(viewManagerModel, itineraryViewModel, userDataAccessObject);

        //rosa
        final UniversitiesController universitiesController =
                createUniversitiesUseCase(viewManagerModel,universitiesViewModel, uniDataAccessObject);

        // Pass the callback to the DashboardView
        return new DashboardView(viewManagerModel, itineraryController, itineraryViewModel, userDataAccessObject, universitiesController, universitiesViewModel, new LoggedInState(), universitiesUserDataAccessObject);
    }

    private static ItineraryController createItineraryUseCase(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject) {
        final ItineraryOutputBoundary itineraryOutputBoundary = new ItineraryPresenter(itineraryViewModel, viewManagerModel);
        final ItineraryInteractor itineraryInputBoundary = new ItineraryInteractor(itineraryOutputBoundary, userDataAccessObject);
        return new ItineraryController(itineraryInputBoundary);
    }

    //rosa
    public static UniversitiesController createUniversitiesUseCase(
            ViewManagerModel viewManagerModel,
            UniversitiesViewModel universitiesViewModel,
            UniversitiesDataAccessInterface universitiesDataAccessObject) {

        // pass this methods parameter to the presenter?
        return UniversitiesUseCaseFactory.createUniversitiesUseCase(viewManagerModel, universitiesViewModel, universitiesDataAccessObject);
        //
    }
}
