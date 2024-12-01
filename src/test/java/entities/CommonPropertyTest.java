package entities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommonPropertyTest {

    private CommonProperty property;

    @Before
    public void setUp() {
        property = new CommonProperty("TestName", "5 Stars", "$100", "$150", "Entire Place");
    }

    @After
    public void tearDown() {
        property = null;
    }

    @Test
    public void testGetName() {
        // Act
        String name = property.getName();

        // Assert
        assertEquals("TestName", name);
    }

    @Test
    public void testGetRating() {
        // Act
        String rating = property.getRating();

        // Assert
        assertEquals("5 Stars", rating);
    }

    @Test
    public void testGetDiscountedPrice() {
        // Act
        String discountedPrice = property.getDiscountedPrice();

        // Assert
        assertEquals("$100", discountedPrice);
    }

    @Test
    public void testGetOriginalPrice() {
        // Act
        String originalPrice = property.getOriginalPrice();

        // Assert
        assertEquals("$150", originalPrice);
    }

    @Test
    public void testGetRoomType() {
        // Act
        String roomType = property.getRoomType();

        // Assert
        assertEquals("Entire Place", roomType);
    }

    @Test
    public void testToString() {
        // Act
        String actualString = property.toString();
        String expectedString = "Property{name='TestName', rating='5 Stars', discountedPrice='$100', originalPrice='$150', roomType='Entire Place'}";

        // Assert
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testPropertyEquality() {
        // Arrange
        CommonProperty anotherProperty = new CommonProperty("TestName", "5 Stars", "$100", "$150", "Entire Place");

        // Act & Assert
        assertEquals("Two properties with identical fields should be equal in terms of content.",
                anotherProperty.toString(), property.toString());
    }
}
