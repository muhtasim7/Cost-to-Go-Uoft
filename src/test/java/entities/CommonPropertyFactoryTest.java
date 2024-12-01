package entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommonPropertyFactoryTest {

    private CommonPropertyFactory factory;

    @Before
    public void setUp() {
        factory = new CommonPropertyFactory();
    }

    @After
    public void tearDown() {
        factory = null;
    }

    @Test
    public void testCreate_shouldReturnValidProperty() {
        // Act
        Property property = factory.create("TestName", "4 Stars", "$90", "$120", "Shared Room");

        // Assert
        assertNotNull("The created property should not be null.", property);
        assertEquals("TestName", property.getName());
        assertEquals("4 Stars", property.getRating());
        assertEquals("$90", property.getDiscountedPrice());
        assertEquals("$120", property.getOriginalPrice());
        assertEquals("Shared Room", property.getRoomType());
    }
}
