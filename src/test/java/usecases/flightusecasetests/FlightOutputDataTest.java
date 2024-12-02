package usecases.flightusecasetests;

import entities.CommonFlight;
import entities.Flight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usecases.flight.FlightOutputData;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FlightOutputDataTest {

    private FlightOutputData flightOutputData;
    private List<Flight> flights;

    @Before
    public void setUp() {
        flights = new ArrayList<>();
        flightOutputData = new FlightOutputData(flights);
        flights.add(new CommonFlight("2025-01-01 08:30", "2025-01-01 10:30",
                "Toronto Pearson International Airport", "Vancouver International Airport",
                "300", "205"));
    }

    @After
    public void tearDown() {
        flightOutputData = null;
        flights = null;
    }

    @Test
    public void testGetFlights() {
        // Act
        List<Flight> retrievedFlights = flightOutputData.getFlights();

        // Assert
        assertNotNull("Flights list should not be null.", retrievedFlights);
        assertEquals("The retrieved flights should match the original list.", flights, retrievedFlights);
        assertEquals("The size of the flights list should be 1.", 1, retrievedFlights.size());
        assertEquals("The first flight's departure time should be '2025-01-01 08:30'.",
                "2025-01-01 08:30", retrievedFlights.get(0).getDepartureTime());
    }
}
