package app;

import interface_adapters.ViewManagerModel;
import interface_adapters.flight.FlightController;
import interface_adapters.flight.FlightPresenter;
import interface_adapters.flight.FlightViewModel;
import usecases.flight.FlightInputBoundary;
import usecases.flight.FlightInteractor;
import usecases.flight.FlightOutputBoundary;
import usecases.flight.FlightUserDataAccessInterface;
import view.FlightView;

/**
 * This class contains the static factory function for creating the FlightView.
 */
public final class FlightUseCaseFactory {

    /** Prevent instantiation. */
    private FlightUseCaseFactory() {

    }

    /**
     * Factory function for creating the FlightView.
     * @param viewManagerModel the ViewManagerModel to inject into the FlightView
     * @param flightViewModel the FlightViewModel to inject into the FlightView
     * @param flightUserDataAccess the FlightUserDataAccessInterface to inject into the FlightInteractor
     * @param destination the destination to search flights for
     * @return the FlightView created for the provided input classes
     */
    public static FlightView create(
            ViewManagerModel viewManagerModel,
            FlightViewModel flightViewModel,
            FlightUserDataAccessInterface flightUserDataAccess,
            String destination) {

        final FlightController flightController = createFlightUseCase(
                viewManagerModel, flightViewModel, flightUserDataAccess);

        return new FlightView(flightController, flightViewModel, destination);
    }

    /**
     * Helper function to create the FlightController.
     * @param viewManagerModel the ViewManagerModel to inject into the Presenter
     * @param flightViewModel the FlightViewModel to inject into the Presenter
     * @param flightUserDataAccess the FlightUserDataAccessInterface to inject into the Interactor
     * @return the FlightController
     */
    private static FlightController createFlightUseCase(
            ViewManagerModel viewManagerModel,
            FlightViewModel flightViewModel,
            FlightUserDataAccessInterface flightUserDataAccess) {

        // Create Presenter with ViewManagerModel and ViewModel
        final FlightOutputBoundary flightPresenter = new FlightPresenter(flightViewModel, viewManagerModel);

        // Create Interactor with data access object and presenter
        final FlightInputBoundary flightInteractor =
                new FlightInteractor(flightUserDataAccess, flightPresenter);

        // Return Controller
        return new FlightController(flightInteractor);
    }
}

