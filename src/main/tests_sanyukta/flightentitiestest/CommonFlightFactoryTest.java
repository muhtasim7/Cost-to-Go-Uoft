package flightentitiestest;

import entities.CommonFlightFactory;
import entities.Flight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommonFlightFactoryTest {
    private CommonFlightFactory factory;

    @Before
    public void setUp() {
        factory = new CommonFlightFactory();
    }

    @After
    public void tearDown() {
        factory = null;
    }

    @Test
    public void test_hasToReturnValidFlight() {
        Flight flight = factory.create("2025-01-01 08:30", "2025-01-01 10:30", "Toronto Pearson International Airport", "Vancouver International Airport", "300", "205");

        assertNotNull("The created flight should not be null.", flight);
        assertEquals("2025-01-01 08:30", flight.getDepartureTime());
        assertEquals("2025-01-01 10:30", flight.getArrivalTime());
        assertEquals("Toronto International Airport", flight.getDepartureAirport());
        assertEquals("Vancouver International Airport", flight.getArrivalAirport());
        assertEquals("300", flight.getFlightDuration());
        assertEquals("205", flight.getPrice());
    }
}
