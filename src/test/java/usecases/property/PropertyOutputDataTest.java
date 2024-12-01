package usecases.property;

import entities.CommonProperty;
import entities.Property;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PropertyOutputDataTest {

    private PropertyOutputData propertyOutputData;
    private List<Property> properties;

    @Before
    public void setUp() {
        properties = new ArrayList<>();
        properties.add(new CommonProperty("TestName", "5 Stars", "$100", "$150", "Entire Place"));
        propertyOutputData = new PropertyOutputData(properties);
    }

    @After
    public void tearDown() {
        propertyOutputData = null;
        properties = null;
    }

    @Test
    public void testGetProperties() {
        // Act
        List<Property> retrievedProperties = propertyOutputData.getProperties();

        // Assert
        assertNotNull("Properties list should not be null.", retrievedProperties);
        assertEquals("The retrieved properties should match the original list.", properties, retrievedProperties);
        assertEquals("The size of the properties list should be 1.", 1, retrievedProperties.size());
        assertEquals("The first property's name should be 'TestName'.",
                "TestName", retrievedProperties.get(0).getName());
    }
}
