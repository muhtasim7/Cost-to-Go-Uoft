package usecases.property;

import entities.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for property-related operations, including filtering and sorting properties.
 */
public class PropertyUtils {

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
        //This part of the code is thanks to ChatGPT as it helped me get the string value and change it to integer that can be compared
        try {
            return Double.parseDouble(priceStr.replace("$", "").replace(",", ""));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    /**
     * Determines the price used for sorting: Discounted Price if available, otherwise Original Price.
     *
     * @param property the property
     * @return the price used for sorting
     */
    public static double getPriceForSorting(Property property) {
        double discountedPrice = getPriceAsDouble(property.getDiscountedPrice());
        if (discountedPrice != 0.0) {
            return discountedPrice;
        } else {
            return getPriceAsDouble(property.getOriginalPrice());
        }
    }


    /**
     * Filters and sorts properties based on price.
     *
     * @param properties the list of properties
     * @param ascending  whether to sort in ascending order
     * @return a filtered and sorted list of properties
     */
    public static List<Property> filterAndSortProperties(List<Property> properties, boolean ascending) {
        List<Property> filteredProperties = new ArrayList<>();

        for (Property property : properties) {
            if (getPriceAsDouble(property.getDiscountedPrice()) != 0.0 || getPriceAsDouble(property.getOriginalPrice()) != 0.0) {
                filteredProperties.add(property);
            }
        }

        for (int i = 0; i < filteredProperties.size() - 1; i++) {
            for (int j = 0; j < filteredProperties.size() - i - 1; j++) {
                double price1 = getPriceForSorting(filteredProperties.get(j));
                double price2 = getPriceForSorting(filteredProperties.get(j + 1));

                if ((ascending && price1 > price2) || (!ascending && price1 < price2)) {
                    Property temp = filteredProperties.get(j);
                    filteredProperties.set(j, filteredProperties.get(j + 1));
                    filteredProperties.set(j + 1, temp);
                }
            }
        }

        return filteredProperties;
    }
}
