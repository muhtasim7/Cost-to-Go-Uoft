package usecases.flightusecasetests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usecases.flight.FlightInputBoundary;
import usecases.flight.FlightInputData;

import static org.junit.Assert.*;

public class FlightInputBoundaryTest {

    private TestFlightInputBoundary testFlightInputBoundary;

    @Before
    public void setUp() {
        testFlightInputBoundary = new TestFlightInputBoundary();
    }

    @After
    public void tearDown() {
        testFlightInputBoundary = null;
    }

    @Test
    public void testSwitchToDashboardView() {
        testFlightInputBoundary.switchToDashboardView();
        assertTrue("switchToDashboardView should set wasSwitchToDashboardViewCalled to true.",
                testFlightInputBoundary.switchToDashboardViewCalled());
    }

    private static class TestFlightInputBoundary implements FlightInputBoundary {
        private boolean switchToDashboardViewCalled = false;

        @Override
        public void switchToDashboardView() {
            switchToDashboardViewCalled = true;
        }

        public boolean switchToDashboardViewCalled() {
            return switchToDashboardViewCalled;
        }

        @Override
        public void handle(FlightInputData inputData) {}
    }
}
