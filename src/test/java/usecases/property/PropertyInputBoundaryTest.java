package usecases.property;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PropertyInputBoundaryTest {

    private TestPropertyInputBoundary testPropertyInputBoundary;

    @Before
    public void setUp() {
        testPropertyInputBoundary = new TestPropertyInputBoundary();
    }

    @After
    public void tearDown() {
        testPropertyInputBoundary = null;
    }

    @Test
    public void testSwitchToDashboardView() {
        // Act
        testPropertyInputBoundary.switchToDashboardView();

        // Assert
        assertTrue("switchToDashboardView should set wasSwitchToDashboardViewCalled to true.",
                testPropertyInputBoundary.wasSwitchToDashboardViewCalled());
    }

    // Concrete implementation of PropertyInputBoundary for testing
    private static class TestPropertyInputBoundary implements PropertyInputBoundary {
        private boolean switchToDashboardViewCalled = false;

        @Override
        public void switchToDashboardView() {
            switchToDashboardViewCalled = true;
        }

        public boolean wasSwitchToDashboardViewCalled() {
            return switchToDashboardViewCalled;
        }

        @Override
        public void handle(PropertyInputData inputData) {
            // No-op for this test
        }
    }
}
