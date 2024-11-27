package interface_adapters.itinerary;

import interface_adapters.ViewModel;
import entities.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * The ViewModel for the Itinerary View.
 */
public class ItineraryViewModel extends ViewModel<ItineraryState> {

    public ItineraryViewModel() {
        super("itinerary view");
        setState(new ItineraryState());  // Initialize the state with an empty list of properties
    }
}
