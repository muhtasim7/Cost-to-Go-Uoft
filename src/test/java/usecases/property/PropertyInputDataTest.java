package usecases.property;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyInputDataTest {

    private PropertyInputData propertyInputData;

    @Before
    public void setUp() {
        propertyInputData = new PropertyInputData("Toronto");
    }

    @After
    public void tearDown() {
        propertyInputData = null;
    }

    @Test
    public void testGetCity() {
        // Act
        String city = propertyInputData.getCity();

        // Assert
        assertEquals("City should be correctly retrieved.", "Toronto", city);
    }
}
