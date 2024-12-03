package usecases.flightusecasetests;

import entities.CommonFlight;
import entities.Flight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usecases.flight.FlightUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FlightUtilsTest {

    private List<Flight> flights;

    @Before
    public void setUp() {
        flights = new ArrayList<>();
        flights.add(new CommonFlight("2025-01-01 08:30", "2025-01-01 10:30",
                "Toronto Pearson International Airport", "Vancouver International Airport",
                "NA", "205"));
        flights.add(new CommonFlight("2025-01-01 12:30", "2025-01-01 14:30",
                "Toronto Pearson International Airport", "Vancouver International Airport",
                "250", "NA"));
        flights.add(new CommonFlight("2025-01-01 09:30", "2025-01-01 11:30",
                "Toronto Pearson International Airport", "Vancouver International Airport",
                "280", "215"));
        flights.add(new CommonFlight("2025-01-01 13:30", "2025-01-01 16:30",
                "Toronto Pearson International Airport", "Vancouver International Airport",
                "350", "300"));
    }

    @After
    public void tearDown() {
        flights = null;
    }


    @Test
    public void testFilterAndSortFlights_noValidPrices() {
        // Arrange
        List<Flight> flightsWithNoValidPrices = new ArrayList<>();
        flightsWithNoValidPrices.add(new CommonFlight("Invalid1", "2025-01-01 10:30",
                "Toronto Pearson International Airport", "Vancouver International Airport",
                "320", "NA"));
        // Act
        List<Flight> result = FlightUtils.filterAndSortFlights(flightsWithNoValidPrices, true);

        // Assert
        assertEquals("Expected 0 flights after filtering.", 0, result.size());
    }

    @Test
    public void testFilterAndSortFlights_emptyList() {
        // Arrange
        List<Flight> emptyFlights = new ArrayList<>();

        // Act
        List<Flight> result = FlightUtils.filterAndSortFlights(emptyFlights, true);

        // Assert
        assertEquals("Expected 0 flights after filtering.", 0, result.size());
    }

    @Test
    public void testGetPriceAsDouble_validPrice() {
        // Act
        double price = FlightUtils.getPriceAsDouble("$123.45");

        // Assert
        assertEquals("Expected 123.45 for valid price string.", 123.45, price, 0.001);
    }

    @Test
    public void testGetPriceAsDouble_invalidPrice() {
        // Act
        double price = FlightUtils.getPriceAsDouble("InvalidPrice");

        // Assert
        assertEquals("Expected 0.0 for invalid price string.", 0.0, price, 0.001);
    }

    @Test
    public void testGetPriceAsDouble_nullPrice() {
        // Act
        double price = FlightUtils.getPriceAsDouble(null);

        // Assert
        assertEquals("Expected 0.0 for null price string.", 0.0, price, 0.001);
    }

    @Test
    public void testGetPriceAsDouble_naPrice() {
        // Act
        double price = FlightUtils.getPriceAsDouble("N/A");

        // Assert
        assertEquals("Expected 0.0 for 'N/A' price string.", 0.0, price, 0.001);
    }

    @Test
    public void testGetPriceAsDouble_priceWithCommas() {
        // Act
        double price = FlightUtils.getPriceAsDouble("$1,234.56");

        // Assert
        assertEquals("Expected 1234.56 for price string with commas.", 1234.56, price, 0.001);
    }
}
