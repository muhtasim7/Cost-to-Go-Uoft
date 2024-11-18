package interface_adapters_sim.property;

import entities.Property;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class PropertySearchPresenter {
    private DefaultTableModel tableModel;

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void presentSearchResults(List<Property> properties) {
        if (tableModel == null) {
            throw new IllegalStateException("Table model is not set.");
        }

        // Clear previous search results
        tableModel.setRowCount(0);

        // Add each property with non-zero prices to the table model
        for (Property property : properties) {
            double discountedPrice = getPriceAsDouble(property.getDiscountedPrice());
            double originalPrice = getPriceAsDouble(property.getOriginalPrice());

            // Only add properties where at least one price is non-zero
            if (discountedPrice != 0.0 || originalPrice != 0.0) {
                tableModel.addRow(new Object[]{
                        property.getListingName(),
                        property.getAvgRatingLocalized(),
                        property.getDiscountedPrice(),
                        property.getOriginalPrice(),
                        property.getRoomTye()
                });
            }
        }
    }

    /**
     * Sorts the properties by price, filtering out entries with both prices as "0.0".
     * @param ascending - if true, sorts from lowest to highest; if false, sorts from highest to lowest.
     */
    public void sortPropertiesByPrice(boolean ascending) {
        // Retrieve properties from the table model
        List<Property> properties = getPropertiesFromTable();

        // Filter out properties with both Discounted Price and Original Price as 0.0
        List<Property> filteredProperties = new ArrayList<>();
        for (Property property : properties) {
            double discountedPrice = getPriceAsDouble(property.getDiscountedPrice());
            double originalPrice = getPriceAsDouble(property.getOriginalPrice());

            if (discountedPrice != 0.0 || originalPrice != 0.0) {
                filteredProperties.add(property);
            }
        }

        // Sort the filtered list
        for (int i = 0; i < filteredProperties.size() - 1; i++) {
            for (int j = i + 1; j < filteredProperties.size(); j++) {
                double priceI = getPriceForSorting(filteredProperties.get(i));
                double priceJ = getPriceForSorting(filteredProperties.get(j));

                // Swap based on the ascending or descending order
                if ((ascending && priceI > priceJ) || (!ascending && priceI < priceJ)) {
                    Property temp = filteredProperties.get(i);
                    filteredProperties.set(i, filteredProperties.get(j));
                    filteredProperties.set(j, temp);
                }
            }
        }

        // Update the table with sorted properties
        presentSearchResults(filteredProperties);
    }

    // Helper method to parse a price string as a double, defaulting to 0.0 if invalid
    private double getPriceAsDouble(String priceStr) {
        if (priceStr == null || priceStr.equals("N/A")) {
            return 0.0;
        }

        // Remove the dollar sign and any commas, then parse
        priceStr = priceStr.replace("$", "").replace(",", "");
        try {
            return Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    // Helper method to determine the price used for sorting: uses Discounted Price if available, otherwise Original Price
    private double getPriceForSorting(Property property) {
        double discountedPrice = getPriceAsDouble(property.getDiscountedPrice());
        if (discountedPrice != 0.0) {
            return discountedPrice;
        } else {
            return getPriceAsDouble(property.getOriginalPrice());
        }
    }

    public Property getPropertyByIndex(int index) {
        if (tableModel == null || index < 0 || index >= tableModel.getRowCount()) {
            System.out.println("Index out of bounds or table model not set.");
            return null;
        }

        String name = (String) tableModel.getValueAt(index, 0);
        String rating = (String) tableModel.getValueAt(index, 1);
        String discountedPrice = (String) tableModel.getValueAt(index, 2);
        String originalPrice = (String) tableModel.getValueAt(index, 3);
        String roomType = (String) tableModel.getValueAt(index, 4);

        return new Property(name, rating, discountedPrice, originalPrice, roomType);
    }


    /**
     * Extracts properties from the current table model.
     * Filters out properties where both Discounted Price and Original Price are 0.0.
     * @return List<Property> - properties in the table.
     */
    private List<Property> getPropertiesFromTable() {
        List<Property> properties = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String discountedPriceStr = (String) tableModel.getValueAt(i, 2);
            String originalPriceStr = (String) tableModel.getValueAt(i, 3);
            double discountedPrice = getPriceAsDouble(discountedPriceStr);
            double originalPrice = getPriceAsDouble(originalPriceStr);

            // Only add properties where at least one price is non-zero
            if (discountedPrice != 0.0 || originalPrice != 0.0) {
                Property property = new Property(
                        (String) tableModel.getValueAt(i, 0),  // Listing Name
                        (String) tableModel.getValueAt(i, 1),  // Rating
                        discountedPriceStr,                    // Discounted Price
                        originalPriceStr,                      // Original Price
                        (String) tableModel.getValueAt(i, 4)   // Room Type
                );
                properties.add(property);
            }
        }
        return properties;
    }
}
