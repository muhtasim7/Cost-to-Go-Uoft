package usecases.flightusecasetests;

import entities.CommonFlight;
import entities.Flight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usecases.flight.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FlightInteractorTest {

    private FlightInteractor flightInteractor;
    private TestFlightUserDataAccess flightDataAccess;
    private TestFlightOutputBoundary flightOutputBoundary;

    @Before
    public void setUp() {
        flightDataAccess = new TestFlightUserDataAccess();
        flightOutputBoundary = new TestFlightOutputBoundary();
        flightInteractor = new FlightInteractor(flightDataAccess, flightOutputBoundary);
    }

    @After
    public void tearDown() {
        flightInteractor = null;
        flightDataAccess = null;
        flightOutputBoundary = null;
    }

    @Test
    public void testHandle_validDestination() throws Exception {
        flightDataAccess.setMockFlights(List.of(new CommonFlight("2025-01-01 08:30", "2025-01-01 10:30",
                "Toronto Pearson International Airport", "Vancouver International Airport", "300", "205")));

        flightInteractor.handle(new FlightInputData("Vancouver"));

        assertTrue("Output boundary's present method should have been called.", flightOutputBoundary.wasPresentCalled);
        assertNotNull("Output data should not be null.", flightOutputBoundary.receivedOutputData.getFlights());
        assertEquals("Expected 1 flight.", 1, flightOutputBoundary.receivedOutputData.getFlights().size());
        assertEquals("2025-01-01 08:30", flightOutputBoundary.receivedOutputData.getFlights().get(0).getDepartureTime());
    }

    @Test
    public void testHandle_emptyDestination() throws Exception {
        flightDataAccess.setMockFlights(new ArrayList<>());

        flightInteractor.handle(new FlightInputData("EmptyDestination"));

        assertTrue("Output boundary's present method should have been called.", flightOutputBoundary.wasPresentCalled);
        assertNotNull("Output data should not be null.", flightOutputBoundary.receivedOutputData);
        assertTrue("Expected no properties in the output data.", flightOutputBoundary.receivedOutputData.getFlights().isEmpty());
    }

    @Test
    public void testHandle_invalidDestinationThrowsException() {
        flightDataAccess.throwExceptionOnSearch = true;

        assertThrows("An exception should be thrown for an invalid destination.", Exception.class,
                () -> flightInteractor.handle(new FlightInputData("InvalidDestination")));
        assertFalse("Output boundary's present method should not be called when an exception occurs.",
                flightOutputBoundary.wasPresentCalled);
    }

    @Test
    public void testSwitchToDashboardView() {
        flightInteractor.switchToDashboardView();

        assertTrue("Output boundary's switchToDashboardView method should have been called.", flightOutputBoundary.wasSwitchToDashboardViewCalled);
    }

    private static class TestFlightUserDataAccess implements FlightUserDataAccessInterface {
        private List<Flight> mockFlights = new ArrayList<>();
        boolean throwExceptionOnSearch = false;

        void setMockFlights(List<Flight> flights) {
            this.mockFlights = flights;
        }

        @Override
        public List<Flight> searchFlights(String destination) throws Exception {
            if (throwExceptionOnSearch) {
                throw new Exception("Test exception for invalid destination.");
            }
            return mockFlights;
        }
    }

    private static class TestFlightOutputBoundary implements FlightOutputBoundary {
        boolean wasPresentCalled = false;
        boolean wasSwitchToDashboardViewCalled = false;
        FlightOutputData receivedOutputData;

        @Override
        public void present(FlightOutputData data) {
            wasPresentCalled = true;
            receivedOutputData = data;
        }

        @Override
        public void switchToDashboardView() {
            wasSwitchToDashboardViewCalled = true;
        }
    }
}
