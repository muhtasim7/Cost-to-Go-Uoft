package entities.flightentitiestest;

import entities.CommonFlight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommonFlightTest {

    private CommonFlight commonFlight;

    @Before
    public void setUp() {
        commonFlight = new CommonFlight("2025-01-01 08:30", "2025-01-01 10:30", "Toronto Pearson International Airport", "Vancouver International Airport", "300", "205");
    }

    @After
    public void tearDown() {
        commonFlight = null;
    }

    @Test
    public void testDepartureTime() {
        String departureTime = commonFlight.getDepartureTime();
        assertEquals("2025-01-01 08:30", departureTime);
    }

    @Test
    public void testArrivalTime() {
        String arrivalTime = commonFlight.getArrivalTime();
        assertEquals("2025-01-01 10:30", arrivalTime);
    }

    @Test
    public void testDepartureAirport() {
        String departureAirport = commonFlight.getDepartureAirport();
        assertEquals("Toronto Pearson International Airport", departureAirport);
    }

    @Test
    public void testArrivalAirport() {
        String arrivalAirport = commonFlight.getArrivalAirport();
        assertEquals("Vancouver International Airport", arrivalAirport);
    }

    @Test
    public void testFlightDuration() {
        String flightDuration = commonFlight.getFlightDuration();
        assertEquals("300", flightDuration);
    }

    @Test
    public void testFlightPrice() {
        String price = commonFlight.getPrice();
        assertEquals("205", price);
    }

    @Test
    public void testString() {
        String actual = commonFlight.toString();
        String expected = "Flight{Departure Time ='2025-01-01 08:30', Arrival Time ='2025-01-01 10:30', Departure Airport ='Toronto Pearson International Airport', Arrival Airport ='Vancouver International Airport', Flight Duration ='300', Price ='205'}";
        assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        CommonFlight otherFlight = new CommonFlight("2025-01-01 08:30", "2025-01-01 10:30", "Toronto Pearson International Airport", "Vancouver International Airport", "300", "205");
        assertEquals("If 2 flights have the same information, then they are the same.",
                otherFlight.toString(), commonFlight.toString());
    }
}
