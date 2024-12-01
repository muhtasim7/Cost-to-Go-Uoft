package usecases.flight;

import entities.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightUtils {

    /**
     * Converts a price string to a double. Handles "N/A" or invalid formats by returning 0.0.
     *
     * @param priceStr the price string
     * @return the price as a double, or 0.0 if invalid
     */
    public static double getPriceAsDouble(String priceStr) {
        if (priceStr == null || priceStr.equals("N/A")) {
            return 0.0;
        }
        try {
            return Double.parseDouble(priceStr.replace("$", "").replace(",", ""));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    /**
     * Determines the price used for sorting: Using the price provided by getPrice().
     *
     * @param flight the flight
     * @return the price used for sorting (price)
     */
    public static double getPriceForSorting(Flight flight) {
        return getPriceAsDouble(flight.getPrice());
    }

    /**
     * Filters and sorts flights based on price.
     *
     * @param flights   the list of flights
     * @param ascending whether to sort in ascending order
     * @return a filtered and sorted list of flights
     */
    public static List<Flight> filterAndSortFlights(List<Flight> flights, boolean ascending) {
        List<Flight> filteredFlights = new ArrayList<>();

        // Filter flights with non-zero prices
        for (Flight flight : flights) {
            if (getPriceAsDouble(flight.getPrice()) != 0.0) {
                filteredFlights.add(flight);
            }
        }

        // Sort the filtered list using bubble sort
        for (int i = 0; i < filteredFlights.size() - 1; i++) {
            for (int j = 0; j < filteredFlights.size() - i - 1; j++) {
                double price1 = getPriceForSorting(filteredFlights.get(j));
                double price2 = getPriceForSorting(filteredFlights.get(j + 1));

                if ((ascending && price1 > price2) || (!ascending && price1 < price2)) {
                    // Swap flights
                    Flight temp = filteredFlights.get(j);
                    filteredFlights.set(j, filteredFlights.get(j + 1));
                    filteredFlights.set(j + 1, temp);
                }
            }
        }

        return filteredFlights;
    }
}
