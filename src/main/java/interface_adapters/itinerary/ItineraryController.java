package interface_adapters.itinerary;

import usecases.itinerary.ItineraryInputBoundary;

/**
 * Controller class responsible for coordinating the interaction between
 * the user interface and the use case logic for managing itineraries.
 * The controller handles incoming requests, delegates tasks to the input
 * boundary, and manages the flow of data between the interface and use case.
 */
public class ItineraryController {

    private final ItineraryInputBoundary inputBoundary;

    /**
     * Constructs an instance of {@link ItineraryController} with the provided
     * input boundary, which contains the logic for handling itinerary-related
     * operations. This controller is responsible for delegating user actions
     * to the appropriate use case logic.
     *
     * @param inputBoundary the input boundary that defines the operations for managing itineraries
     */
    public ItineraryController(ItineraryInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public ItineraryInputBoundary getInputBoundary() {
        return inputBoundary;
    }
}
