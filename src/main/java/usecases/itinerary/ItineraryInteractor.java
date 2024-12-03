package usecases.itinerary;

import java.util.List;

import entities.Flight;
import entities.Property;
import entities.University;

/**
 * Interactor for managing and processing itinerary-related use cases.
 * This class interacts with the data access layer to fetch necessary information
 * (properties, universities, and flights) and passes it to the output boundary
 * (e.g., the presenter) for further processing and presentation.
 */
public class ItineraryInteractor implements ItineraryInputBoundary {

    private final ItineraryOutputBoundary outputBoundary;
    private final ItineraryDataAccessInterface dataAccess;

    /**
     * Constructs an ItineraryInteractor with the specified output boundary and data access interface.
     *
     * @param outputBoundary the output boundary responsible for presenting the itinerary data
     * @param dataAccess the data access interface used to fetch the data required for the itinerary
     */
    public ItineraryInteractor(ItineraryOutputBoundary outputBoundary, ItineraryDataAccessInterface dataAccess) {
        this.outputBoundary = outputBoundary;
        this.dataAccess = dataAccess;
    }

    /**
     * Handles the processing of itinerary data by fetching the required information
     * (properties, universities, and flights) and passing it to the output boundary for presentation.
     *
     * @param property the selected property related to the itinerary
     * @param university the selected university related to the itinerary
     * @param flight the selected flight related to the itinerary
     */
    @Override
    public void handleforItinerary(Property property, University university, Flight flight) {
        try {
            // Fetch properties, universities, and flights for the itinerary
            final List<Property> properties = dataAccess.getPropertiesForItinerary(university.getCity());
            final List<University> universities = dataAccess.getUniversitiesForItinerary(university);
            final List<Flight> flights = dataAccess.getFlightsForItinerary(flight);

            // Prepare output data to pass to the output boundary
            final ItineraryOutputData outputData = new ItineraryOutputData(properties, property, universities,
                    university, flights, flight);

            // Pass the data to the output boundary for presentation
            outputBoundary.presentItinerary(outputData);
        }
        catch (Exception e) {
            // Handle any exceptions during data processing
            e.printStackTrace();
        }
    }

    /**
     * Switches the view to the itinerary view by calling the corresponding method in the output boundary.
     */
    @Override
    public void switchToItineraryView() {
        outputBoundary.switchToItineraryView();
    }
}

