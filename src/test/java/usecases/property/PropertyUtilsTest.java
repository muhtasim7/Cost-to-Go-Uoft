package usecases.property;

import entities.CommonProperty;
import entities.Property;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PropertyUtilsTest {

    private List<Property> properties;

    @Before
    public void setUp() {
        properties = new ArrayList<>();
        properties.add(new CommonProperty("Property1", "4 Stars", "$200", "$250", "Entire Place"));
        properties.add(new CommonProperty("Property2", "3 Stars", "N/A", "$300", "Private Room"));
        properties.add(new CommonProperty("Property3", "5 Stars", "$150", "$200", "Shared Room"));
        properties.add(new CommonProperty("Property4", "4 Stars", "N/A", "N/A", "Entire Place")); // No valid prices
    }

    @After
    public void tearDown() {
        properties = null;
    }

    @Test
    public void testFilterAndSortProperties_ascendingOrder() {
        // Act
        List<Property> result = PropertyUtils.filterAndSortProperties(properties, true);

        // Assert
        assertEquals("Expected 3 properties after filtering.", 3, result.size());
        assertEquals("Property3 should be the first after sorting in ascending order.", "Property3", result.get(0).getName());
        assertEquals("Property1 should be the second after sorting in ascending order.", "Property1", result.get(1).getName());
        assertEquals("Property2 should be the third after sorting in ascending order.", "Property2", result.get(2).getName());
    }

    @Test
    public void testFilterAndSortProperties_descendingOrder() {
        // Act
        List<Property> result = PropertyUtils.filterAndSortProperties(properties, false);

        // Assert
        assertEquals("Expected 3 properties after filtering.", 3, result.size());
        assertEquals("Property2 should be the first after sorting in descending order.", "Property2", result.get(0).getName());
        assertEquals("Property1 should be the second after sorting in descending order.", "Property1", result.get(1).getName());
        assertEquals("Property3 should be the third after sorting in descending order.", "Property3", result.get(2).getName());
    }

    @Test
    public void testFilterAndSortProperties_noValidPrices() {
        // Arrange
        List<Property> propertiesWithNoValidPrices = new ArrayList<>();
        propertiesWithNoValidPrices.add(new CommonProperty("Invalid1", "3 Stars", "N/A", "N/A", "Private Room"));

        // Act
        List<Property> result = PropertyUtils.filterAndSortProperties(propertiesWithNoValidPrices, true);

        // Assert
        assertEquals("Expected 0 properties after filtering.", 0, result.size());
    }

    @Test
    public void testFilterAndSortProperties_emptyList() {
        // Arrange
        List<Property> emptyProperties = new ArrayList<>();

        // Act
        List<Property> result = PropertyUtils.filterAndSortProperties(emptyProperties, true);

        // Assert
        assertEquals("Expected 0 properties after filtering.", 0, result.size());
    }

    @Test
    public void testGetPriceAsDouble_validPrice() {
        // Act
        double price = PropertyUtils.getPriceAsDouble("$123.45");

        // Assert
        assertEquals("Expected 123.45 for valid price string.", 123.45, price, 0.001);
    }

    @Test
    public void testGetPriceAsDouble_invalidPrice() {
        // Act
        double price = PropertyUtils.getPriceAsDouble("InvalidPrice");

        // Assert
        assertEquals("Expected 0.0 for invalid price string.", 0.0, price, 0.001);
    }

    @Test
    public void testGetPriceAsDouble_nullPrice() {
        // Act
        double price = PropertyUtils.getPriceAsDouble(null);

        // Assert
        assertEquals("Expected 0.0 for null price string.", 0.0, price, 0.001);
    }

    @Test
    public void testGetPriceAsDouble_naPrice() {
        // Act
        double price = PropertyUtils.getPriceAsDouble("N/A");

        // Assert
        assertEquals("Expected 0.0 for 'N/A' price string.", 0.0, price, 0.001);
    }

    @Test
    public void testGetPriceAsDouble_priceWithCommas() {
        // Act
        double price = PropertyUtils.getPriceAsDouble("$1,234.56");

        // Assert
        assertEquals("Expected 1234.56 for price string with commas.", 1234.56, price, 0.001);
    }
}
