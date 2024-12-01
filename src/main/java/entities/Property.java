package entities;

/**
 * Represents a generic property with attributes such as name, rating, prices, and room type.
 * This interface defines the contract for accessing property details.
 */
public interface Property {

    /**
     * Gets the name of the property.
     *
     * @return the name of the property
     */
    String getName();

    /**
     * Gets the rating of the property.
     *
     * @return the rating of the property
     */
    String getRating();

    /**
     * Gets the discounted price of the property.
     *
     * @return the discounted price of the property, or "N/A" if not available
     */
    String getDiscountedPrice();

    /**
     * Gets the original price of the property.
     *
     * @return the original price of the property, or "N/A" if not available
     */
    String getOriginalPrice();

    /**
     * Gets the type of room associated with the property.
     * Examples include "Entire Place", "Shared Room", etc.
     *
     * @return the room type of the property
     */
    String getRoomType();
}
