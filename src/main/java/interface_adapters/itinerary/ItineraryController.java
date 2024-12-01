package interface_adapters.itinerary;

import usecases.itinerary.ItineraryInputBoundary;

public class ItineraryController {
    private final ItineraryInputBoundary inputBoundary;

    public ItineraryController(ItineraryInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }
}


