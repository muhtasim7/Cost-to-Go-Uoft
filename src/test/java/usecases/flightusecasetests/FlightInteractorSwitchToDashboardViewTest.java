package usecases.flightusecasetests;

import entities.Flight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usecases.flight.FlightInteractor;
import usecases.flight.FlightOutputBoundary;
import usecases.flight.FlightOutputData;
import usecases.flight.FlightUserDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FlightInteractorSwitchToDashboardViewTest {
    private FlightInteractor flightInteractor;
    private TestFlightOutputBoundary flightOutputBoundary;

    @Before
    public void setUp() {
        flightOutputBoundary = new TestFlightOutputBoundary();
        flightInteractor = new FlightInteractor(new TestFlightUserDataAccess(), flightOutputBoundary);
    }

    @After
    public void tearDown() {
        flightInteractor = null;
        flightOutputBoundary = null;
    }

    @Test
    public void testSwitchToDashboardView() {
        flightInteractor.switchToDashboardView();
        assertTrue("switchtoDashboardView should call the presenter's method.",
                flightOutputBoundary.wasSwitchToDashboardViewCalled());
    }

    private static class TestFlightOutputBoundary implements FlightOutputBoundary {
        private boolean switchToDashboardViewCalled = false;

        @Override
        public void present(FlightOutputData data) {}

        @Override
        public void switchToDashboardView() {
            switchToDashboardViewCalled = true;
        }

        public boolean wasSwitchToDashboardViewCalled() {
            return switchToDashboardViewCalled;
        }
    }

    private static class TestFlightUserDataAccess implements FlightUserDataAccessInterface {

        @Override
        public List<Flight> searchFlights(String destination) throws Exception {
            return new ArrayList<>();
        }
    }
}
