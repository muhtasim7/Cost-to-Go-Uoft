package usecases.itinerary;

/**
 * Interface for the output boundary of the Itinerary use case.
 * This interface defines the methods that the interactor will use
 * to communicate with the presentation layer, such as displaying the itinerary
 * and switching views.
 */
public interface ItineraryOutputBoundary {

    /**
     * Presents the itinerary data to the view.
     * This method will be called by the interactor to pass the processed
     * itinerary data to the presentation layer.
     *
     * @param outputData the itinerary data to be presented
     */
    void presentItinerary(ItineraryOutputData outputData);

    /**
     * Switches the view to the itinerary view.
     * This method will be called by the interactor to trigger a transition
     * to the view where the itinerary details are displayed.
     */
    void switchToItineraryView();
}
