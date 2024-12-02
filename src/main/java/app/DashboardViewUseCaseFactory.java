package app;

import interface_adapters.universities.UniversitiesController;
import interface_adapters.universities.UniversitiesViewModel;
import interface_adapters.ViewManagerModel;
import interface_adapters.flight.FlightState;
import interface_adapters.flight.FlightViewModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryPresenter;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.property.PropertyState;
import interface_adapters.property.PropertyViewModel;
import interface_adapters.logged_in.LoggedInState;
import usecases.universities.UniversitiesDataAccessInterface;
import usecases.universities.UniversitiesUserDataAccessInterface; // Import added
import usecases.flight.FlightUserDataAccessInterface;
import usecases.itinerary.ItineraryDataAccessInterface;
import usecases.itinerary.ItineraryInteractor;
import usecases.itinerary.ItineraryOutputBoundary;
import usecases.property.PropertyUserDataAccessInterface;
import view.DashboardView;

public final class DashboardViewUseCaseFactory {

    private DashboardViewUseCaseFactory() {}

    public static DashboardView create(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject,
            PropertyUserDataAccessInterface airbnb,
            PropertyViewModel propertyViewModel,
            PropertyState propertyState,
            FlightUserDataAccessInterface flightUserDataAccessObject,
            FlightViewModel flightViewModel,
            FlightState flightState,
            UniversitiesViewModel universitiesViewModel,
            UniversitiesDataAccessInterface uniDataAccessObject,
            UniversitiesUserDataAccessInterface universitiesUserDataAccessObject){

        final ItineraryController itineraryController =
                createItineraryUseCase(viewManagerModel, itineraryViewModel, userDataAccessObject);

        //rosa
        final UniversitiesController universitiesController =
                createUniversitiesUseCase(viewManagerModel,universitiesViewModel, uniDataAccessObject);

        // Pass the callback to the DashboardView
        return new DashboardView(viewManagerModel, itineraryController, itineraryViewModel, userDataAccessObject, universitiesController, universitiesViewModel, new LoggedInState(), universitiesUserDataAccessObject, airbnb, propertyViewModel, propertyState, flightUserDataAccessObject, flightViewModel, flightState);//for flight
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
