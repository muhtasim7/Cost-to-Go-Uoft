package usecases.property;

import entities.Property;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PropertyInteractorSwitchToDashboardViewTest {

    private PropertyInteractor interactor;
    private TestPropertyOutputBoundary outputBoundary;

    @Before
    public void setUp() {
        // Initialize test boundary and interactor
        outputBoundary = new TestPropertyOutputBoundary();
        interactor = new PropertyInteractor(new TestPropertyUserDataAccess(), outputBoundary);
    }

    @After
    public void tearDown() {
        interactor = null;
        outputBoundary = null;
    }

    @Test
    public void testSwitchToDashboardView() {
        // Act
        interactor.switchToDashboardView();

        // Assert
        assertTrue("switchToDashboardView should call the presenter's method.",
                outputBoundary.wasSwitchToDashboardViewCalled());
    }

    // Minimal implementation of PropertyOutputBoundary for testing
    private static class TestPropertyOutputBoundary implements PropertyOutputBoundary {
        private boolean switchToDashboardViewCalled = false;

        @Override
        public void present(PropertyOutputData data) {
            // No-op for this test
        }

        @Override
        public void switchToDashboardView() {
            switchToDashboardViewCalled = true;
        }

        public boolean wasSwitchToDashboardViewCalled() {
            return switchToDashboardViewCalled;
        }
    }

    // Minimal implementation of PropertyUserDataAccessInterface for testing
    private static class TestPropertyUserDataAccess implements PropertyUserDataAccessInterface {
        @Override
        public List<Property> searchProperties(String city) throws Exception {
            return new ArrayList<>(); // Return empty list for this test
        }
    }
}
