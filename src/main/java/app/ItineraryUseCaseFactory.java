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

/**
 * Factory class for creating instances related to the itinerary use case.
 * This class is responsible for constructing and wiring the necessary components
 * such as the ItineraryController, ItineraryView, and other related use case objects.
 * It follows the Factory Design Pattern to encapsulate the creation logic.
 */
public final class ItineraryUseCaseFactory {

    /**
     * Private constructor to prevent instantiation of the factory class.
     * The factory class provides only static methods.
     */
    private ItineraryUseCaseFactory() {
        // Private constructor to prevent instantiation
    }

    /**
     * Creates an instance of {@link ItineraryView}, wiring the necessary
     * components such as {@link ItineraryController} and {@link ItineraryViewModel}.
     * This method acts as the entry point to initiate the itinerary view with
     * the necessary controllers and data models.
     *
     * @param viewManagerModel the model that manages the view state
     * @param itineraryViewModel the model containing the itinerary data to be displayed
     * @param userDataAccessObject the data access interface to retrieve itinerary data
     * @return an instance of {@link ItineraryView} with the controller and view model
     */
    public static ItineraryView create(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject) {

        final ItineraryController itineraryController = createItineraryUseCase(viewManagerModel, itineraryViewModel,
                userDataAccessObject);
        return new ItineraryView(itineraryController, itineraryViewModel);
    }

    /**
     * Creates and returns an instance of {@link ItineraryController} by wiring the
     * necessary components such as the {@link ItineraryInteractor} and {@link ItineraryPresenter}.
     * This method provides the use case logic to handle itinerary-related tasks.
     *
     * @param viewManagerModel the model that manages the view state
     * @param itineraryViewModel the model containing the itinerary data to be displayed
     * @param userDataAccessObject the data access interface to retrieve itinerary data
     * @return an instance of {@link ItineraryController} to handle itinerary logic
     */
    static ItineraryController createItineraryUseCase(
            ViewManagerModel viewManagerModel,
            ItineraryViewModel itineraryViewModel,
            ItineraryDataAccessInterface userDataAccessObject) {

        // Notice how we pass this method's parameters to the Presenter.
        final ItineraryOutputBoundary itineraryOutputBoundary = new ItineraryPresenter(itineraryViewModel,
                viewManagerModel);
        final ItineraryInputBoundary itineraryInteractor = new ItineraryInteractor(itineraryOutputBoundary,
                userDataAccessObject);
        return new ItineraryController(itineraryInteractor);
    }
}

