package app;

import interface_adapters.ViewManagerModel;
import interface_adapters.flight.FlightController;
import interface_adapters.flight.FlightPresenter;
import interface_adapters.flight.FlightSelectedCallback;
import interface_adapters.flight.FlightState;
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
     * @param state to store chosen flight
     * @return the FlightView created for the provided input classes
     */
    public static FlightView create(
            ViewManagerModel viewManagerModel,
            FlightViewModel flightViewModel,
            FlightUserDataAccessInterface flightUserDataAccess,
            String destination, FlightState state) {

        final FlightController flightController = createFlightUseCase(
                viewManagerModel, flightViewModel, flightUserDataAccess);

        // Anonymous new FlightSelectedCallback() can be replaced with lambda
        // Anonymous new FlightSelectedCallback() can be replaced with method reference
        // Make this anonymous inner class a lambda
        // Replace this lambda with method reference 'state::setSelectedFlight'.
        // As IntelliJ recommended
        FlightSelectedCallback callback = state::setSelectedFlight;

        return new FlightView(flightController, flightViewModel, destination, callback);
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

        final FlightOutputBoundary flightPresenter = new FlightPresenter(flightViewModel, viewManagerModel);

        final FlightInputBoundary flightInteractor =
                new FlightInteractor(flightUserDataAccess, flightPresenter);

        return new FlightController(flightInteractor);
    }
}

