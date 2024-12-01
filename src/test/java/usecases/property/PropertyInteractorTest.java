package usecases.property;

import entities.CommonProperty;
import entities.Property;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PropertyInteractorTest {

    private PropertyInteractor interactor;
    private TestPropertyUserDataAccess dataAccess;
    private TestPropertyOutputBoundary outputBoundary;

    @Before
    public void setUp() {
        dataAccess = new TestPropertyUserDataAccess();
        outputBoundary = new TestPropertyOutputBoundary();
        interactor = new PropertyInteractor(dataAccess, outputBoundary);
    }

    @After
    public void tearDown() {
        interactor = null;
        dataAccess = null;
        outputBoundary = null;
    }

    @Test
    public void testHandle_validCity() throws Exception {
        // Arrange
        dataAccess.setMockProperties(List.of(new CommonProperty("TestName", "5 Stars", "$90", "$150", "Entire Place")));

        // Act
        interactor.handle(new PropertyInputData("Toronto"));

        // Assert
        assertTrue("Output boundary's present method should have been called.", outputBoundary.wasPresentCalled);
        assertNotNull("Output data should not be null.", outputBoundary.receivedOutputData);
        assertEquals("Expected 1 property.", 1, outputBoundary.receivedOutputData.getProperties().size());
        assertEquals("TestName", outputBoundary.receivedOutputData.getProperties().get(0).getName());
    }

    @Test
    public void testHandle_emptyCity() throws Exception {
        // Arrange
        dataAccess.setMockProperties(new ArrayList<>()); // Empty properties list

        // Act
        interactor.handle(new PropertyInputData("EmptyCity"));

        // Assert
        assertTrue("Output boundary's present method should have been called.", outputBoundary.wasPresentCalled);
        assertNotNull("Output data should not be null.", outputBoundary.receivedOutputData);
        assertTrue("Expected no properties in the output data.", outputBoundary.receivedOutputData.getProperties().isEmpty());
    }

    @Test
    public void testHandle_invalidCityThrowsException() {
        // Arrange
        dataAccess.throwExceptionOnSearch = true;

        // Act & Assert
        assertThrows("An exception should be thrown for an invalid city.",
                Exception.class,
                () -> interactor.handle(new PropertyInputData("InvalidCity")));

        assertFalse("Output boundary's present method should not be called when an exception occurs.", outputBoundary.wasPresentCalled);
    }

    @Test
    public void testSwitchToDashboardView() {
        // Act
        interactor.switchToDashboardView();

        // Assert
        assertTrue("Output boundary's switchToDashboardView method should have been called.", outputBoundary.wasSwitchToDashboardViewCalled);
    }

    // Test implementation for PropertyUserDataAccessInterface
    private static class TestPropertyUserDataAccess implements PropertyUserDataAccessInterface {
        private List<Property> mockProperties = new ArrayList<>();
        boolean throwExceptionOnSearch = false;

        void setMockProperties(List<Property> properties) {
            this.mockProperties = properties;
        }

        @Override
        public List<Property> searchProperties(String city) throws Exception {
            if (throwExceptionOnSearch) {
                throw new Exception("Test exception for invalid city.");
            }
            return mockProperties;
        }
    }

    // Test implementation for PropertyOutputBoundary
    private static class TestPropertyOutputBoundary implements PropertyOutputBoundary {
        boolean wasPresentCalled = false;
        boolean wasSwitchToDashboardViewCalled = false;
        PropertyOutputData receivedOutputData;

        @Override
        public void present(PropertyOutputData data) {
            wasPresentCalled = true;
            receivedOutputData = data;
        }

        @Override
        public void switchToDashboardView() {
            wasSwitchToDashboardViewCalled = true;
        }
    }
}
