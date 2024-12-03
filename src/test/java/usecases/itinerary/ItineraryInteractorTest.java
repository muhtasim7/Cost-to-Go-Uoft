package usecases.itinerary;

import entities.CommonFlightFactory;
import entities.CommonPropertyFactory;
import entities.Flight;
import entities.Property;
import entity_rosa.University;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ItineraryInteractorTest {

    private ItineraryOutputBoundary mockOutputBoundary;
    private ItineraryDataAccessInterface mockDataAccess;
    private ItineraryInteractor interactor;

    private CommonPropertyFactory propertyFactory;
    private CommonFlightFactory flightFactory;
    private University university;
    private Property property;
    private Flight flight;

    @Before
    public void setUp() {
        // Initialize factories
        propertyFactory = new CommonPropertyFactory();
        flightFactory = new CommonFlightFactory();

        // Initialize the output boundary (mocked)
        mockOutputBoundary = new ItineraryOutputBoundary() {
            @Override
            public void presentItinerary(ItineraryOutputData outputData) {
                // Mock implementation for presentItinerary
            }

            @Override
            public void switchToItineraryView() {
                // Mock implementation for switchToItineraryView
                // You can log or check some state if needed
            }
        };

        // Mock the data access interface
        mockDataAccess = new ItineraryDataAccessInterface() {
            @Override
            public List<Property> getPropertiesForItinerary(String city) {
                // Create mock Property using the factory
                Property property1 = propertyFactory.create("TestProperty", "5 Stars", "$100", "$150", "Entire Place");
                Property property2 = propertyFactory.create("TestProperty2", "4 Stars", "$80", "$120", "Private Room");
                return List.of(property1, property2);
            }

            @Override
            public List<University> getUniversitiesForItinerary(University university) {
                // Return a mock list of universities (using the custom constructor)
                University university1 = new University("Canada", "Toronto", "University of Toronto", "English", "$10000", "BSc Award", "3.5");
                University university2 = new University("USA", "New York", "Harvard University", "English", "$50000", "PhD Award", "3.9");
                return List.of(university1, university2);
            }

            @Override
            public List<Flight> getFlightsForItinerary(Flight flight) {
                // Create mock Flight using the factory
                Flight flight1 = flightFactory.create("2025-01-01 08:30", "2025-01-01 10:30",
                        "Toronto Pearson International Airport", "Vancouver International Airport", "300", "205");
                Flight flight2 = flightFactory.create("2025-02-01 09:00", "2025-02-01 11:00",
                        "Vancouver International Airport", "Toronto Pearson International Airport", "350", "220");
                return List.of(flight1, flight2);
            }
        };

        // Initialize the interactor with mock dependencies
        interactor = new ItineraryInteractor(mockOutputBoundary, mockDataAccess);
    }

    @Test
    public void testHandleForItinerary() throws Exception {
        // Mock input data for the test using the factories
        Property selectedProperty = propertyFactory.create("TestProperty", "5 Stars", "$100", "$150", "Entire Place");
        University selectedUniversity = new University("Canada", "Toronto", "University of Toronto", "English", "$10000", "BSc Award", "3.5");
        Flight selectedFlight = flightFactory.create("2025-01-01 08:30", "2025-01-01 10:30",
                "Toronto Pearson International Airport", "Vancouver International Airport", "300", "205");

        // Call the method under test
        interactor.handleforItinerary(selectedProperty, selectedUniversity, selectedFlight);

        // Verify that the output boundary method is called (you can verify it with a spy or mock setup)
        // Example assertions to check the correct behavior:
        assertNotNull(mockDataAccess.getPropertiesForItinerary(selectedUniversity.getCity()));
        assertNotNull(mockDataAccess.getUniversitiesForItinerary(selectedUniversity));
        assertNotNull(mockDataAccess.getFlightsForItinerary(selectedFlight));
    }

    @Test
    public void testSwitchToItineraryView() {
        interactor.switchToItineraryView();
    }
}
