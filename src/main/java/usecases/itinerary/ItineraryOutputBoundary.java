package usecases.itinerary;

public interface ItineraryOutputBoundary {
    // Define a method that will present the itinerary data
    void presentItinerary(ItineraryOutputData outputData);

    void switchToItineraryView();
}
