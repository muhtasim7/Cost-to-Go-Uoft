package usecases.flightusecasetests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usecases.flight.FlightInputData;

import static org.junit.Assert.*;

public class FlightInputDataTest {

    private FlightInputData flightInputData;

    @Before
    public void setUp() {
        flightInputData = new FlightInputData("Vancouver");
    }

    @After
    public void tearDown() {
        flightInputData = null;
    }

    @Test
    public void testGetDestination() {
        String destination = flightInputData.getDestination();
        assertEquals("Destination should be correct", "Vancouver", destination);
    }
}
