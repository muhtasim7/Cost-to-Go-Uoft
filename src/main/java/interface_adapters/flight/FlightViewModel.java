package interface_adapters.flight;

import interface_adapters.ViewModel;

/**
 * The View Model for the Flight View.
 */
public class FlightViewModel extends ViewModel<FlightState> {

    public FlightViewModel() {
        super("flight view");
        setState(new FlightState());
    }
}

