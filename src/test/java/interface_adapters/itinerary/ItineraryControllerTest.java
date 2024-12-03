package interface_adapters.itinerary;

import entities.*;
import entity_rosa.University;
import org.junit.Before;
import org.junit.Test;
import usecases.itinerary.ItineraryInputBoundary;

import static org.junit.Assert.*;

public class ItineraryControllerTest {

    private ItineraryController controller;
    private ItineraryInputBoundary inputBoundary;

    // Stub implementation for ItineraryInputBoundary
    private class StubItineraryInputBoundary implements ItineraryInputBoundary {
        @Override
        public void handleforItinerary(Property property, University university, Flight flight) throws Exception {
            // Stub method (does nothing)
        }

        @Override
        public void switchToItineraryView() {
            // Stub method (does nothing)
        }
    }

    @Before
    public void setUp() {
        inputBoundary = new StubItineraryInputBoundary();
        controller = new ItineraryController(inputBoundary);  // Create the controller with the stub
    }

    @Test
    public void testControllerInstantiation() {
        assertNotNull("The controller should be instantiated", controller);
        assertNotNull("The input boundary should be passed to the controller", inputBoundary);
    }

    @Test
    public void testControllerDelegation() {
        // In this test, we can just verify that the input boundary is correctly passed to the controller,
        // as the controller is just delegating to this boundary.

        // No specific functionality to assert here, because it's about ensuring the controller is delegating
        // tasks to the provided input boundary.
        assertSame("The input boundary in the controller should be the same as the passed one",
                inputBoundary, controller.getInputBoundary());
    }
}

