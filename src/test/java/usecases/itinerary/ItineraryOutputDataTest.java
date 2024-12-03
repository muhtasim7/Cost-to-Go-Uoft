package usecases.itinerary;

import entities.CommonFlightFactory;
import entities.CommonPropertyFactory;
import entities.Flight;
import entities.Property;
import entities.University;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

public class ItineraryOutputDataTest {

    private ItineraryOutputData outputData;
    private ItineraryDataAccessInterface mockDataAccess;
    private CommonPropertyFactory propertyFactory;
    private CommonFlightFactory flightFactory;

    @Before
    public void setUp() throws Exception {
        // Initialize the factories
        propertyFactory = new CommonPropertyFactory();
        flightFactory = new CommonFlightFactory();

        // Mock data access implementation
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

        // Create the ItineraryOutputData object using mock data
        List<Property> properties = mockDataAccess.getPropertiesForItinerary("Toronto");
        Property selectedProperty = properties.get(0);
        List<University> universities = mockDataAccess.getUniversitiesForItinerary(null);
        University selectedUniversity = universities.get(0);
        List<Flight> flights = mockDataAccess.getFlightsForItinerary(null);
        Flight selectedFlight = flights.get(0);

        outputData = new ItineraryOutputData(properties, selectedProperty, universities, selectedUniversity, flights,
                selectedFlight);
    }

    @Test
    public void testGetProperties() {
        // Verify the list of properties
        assertNotNull(outputData.getProperties());
        assertEquals(2, outputData.getProperties().size());
    }

    @Test
    public void testGetUniversities() {
        // Verify the list of universities
        assertNotNull(outputData.getUniversities());
        assertEquals(2, outputData.getUniversities().size());
    }

    @Test
    public void testGetSelectedProperty() {
        // Verify the selected property
        assertNotNull(outputData.getSelectedProperty());
        assertEquals("TestProperty", outputData.getSelectedProperty().getName());
    }

    @Test
    public void testGetFlights() {
        // Verify the list of flights
        assertNotNull(outputData.getFlights());
        assertEquals(2, outputData.getFlights().size());
    }

    @Test
    public void testGetSelectedFlight() {
        // Verify the selected flight
        assertNotNull(outputData.getSelectedFlight());
        assertEquals("2025-01-01 08:30", outputData.getSelectedFlight().getDepartureTime());
    }

    @Test
    public void testGetSelectedUniversity() {
        // Verify the selected university
        assertNotNull(outputData.getSelectedUniversity());
        assertEquals("University of Toronto", outputData.getSelectedUniversity().getUniversityName());
    }
}
