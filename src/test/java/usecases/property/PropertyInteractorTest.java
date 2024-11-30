package usecases.property;

import entities.Property;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PropertyInteractorTest {

    private PropertyInteractor interactor;
    private MockUserDataAccess mockUserDataAccess;
    private MockOutputBoundary mockPresenter;

    @Before
    public void setUp() {
        mockUserDataAccess = new MockUserDataAccess();
        mockPresenter = new MockOutputBoundary();
        interactor = new PropertyInteractor(mockUserDataAccess, mockPresenter);
    }

    @After
    public void tearDown() {
        interactor = null;
        mockUserDataAccess = null;
        mockPresenter = null;
    }

    @Test
    public void testHandle_shouldCallPresenterWithFetchedProperties() throws Exception {
        // Arrange
        mockUserDataAccess.setMockProperties(List.of(new MockProperty("TestProperty")));

        // Act
        interactor.handle(new PropertyInputData("Toronto"));

        // Assert
        assertTrue("Presenter's present method should have been called.", mockPresenter.wasPresentCalled);
        assertNotNull("Presenter should have received properties.", mockPresenter.receivedOutputData);
        assertEquals("Expected 1 property.", 1, mockPresenter.receivedOutputData.getProperties().size());
        assertEquals("TestProperty", mockPresenter.receivedOutputData.getProperties().get(0).getName());
    }

    @Test
    public void testHandle_shouldHandleEmptyResult() throws Exception {
        // Arrange
        mockUserDataAccess.setMockProperties(new ArrayList<>()); // No properties

        // Act
        interactor.handle(new PropertyInputData("EmptyCity"));

        // Assert
        assertTrue("Presenter's present method should have been called.", mockPresenter.wasPresentCalled);
        assertNotNull("Presenter should have received output data.", mockPresenter.receivedOutputData);
        assertTrue("Expected no properties in output.", mockPresenter.receivedOutputData.getProperties().isEmpty());
    }

    @Test
    public void testHandle_shouldThrowExceptionForInvalidCity() {
        // Arrange
        mockUserDataAccess.throwExceptionOnSearch = true;

        // Act & Assert
        assertThrows("Exception should be thrown for invalid city.",
                Exception.class,
                () -> interactor.handle(new PropertyInputData("InvalidCity")));

        assertFalse("Presenter's present method should not have been called.", mockPresenter.wasPresentCalled);
    }

    @Test
    public void testSwitchToDashboardView_shouldCallPresenter() {
        // Act
        interactor.switchToDashboardView();

        // Assert
        assertTrue("Presenter's switchToDashboardView method should have been called.",
                mockPresenter.wasSwitchToDashboardViewCalled);
    }

    // Mock implementation of PropertyUserDataAccessInterface
    private static class MockUserDataAccess implements PropertyUserDataAccessInterface {
        private List<Property> mockProperties = new ArrayList<>();
        boolean throwExceptionOnSearch = false;

        void setMockProperties(List<Property> properties) {
            this.mockProperties = properties;
        }

        @Override
        public List<Property> searchProperties(String city) throws Exception {
            if (throwExceptionOnSearch) {
                throw new Exception("Mock Exception");
            }
            return mockProperties;
        }
    }

    // Mock implementation of PropertyOutputBoundary
    private static class MockOutputBoundary implements PropertyOutputBoundary {
        boolean wasPresentCalled = false;
        boolean wasSwitchToDashboardViewCalled = false;
        PropertyOutputData receivedOutputData;

        @Override
        public void present(PropertyOutputData data) {
            wasPresentCalled = true;
            receivedOutputData = data;
        }

        @Override
        public void handleError(String error) {
            // Not used in this test
        }

        @Override
        public void switchToDashboardView() {
            wasSwitchToDashboardViewCalled = true;
        }
    }

    // Mock implementation of Property for testing
    private static class MockProperty implements Property {
        private final String name;

        MockProperty(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getRating() {
            return null;
        }

        @Override
        public String getDiscountedPrice() {
            return null;
        }

        @Override
        public String getOriginalPrice() {
            return null;
        }

        @Override
        public String getRoomType() {
            return null;
        }
    }
}
