package entities;

/**
 * Factory interface for creating Property objects.
 * This interface provides a method to create properties with specified attributes.
 */
public interface PropertyFactory {

    /**
     * Creates a new Property instance with the given attributes.
     *
     * @param name            the name of the property
     * @param rating          the rating of the property
     * @param discountedPrice the discounted price of the property, or "N/A" if not available
     * @param originalPrice   the original price of the property, or "N/A" if not available
     * @param roomType        the type of room associated with the property, e.g., "Entire Place", "Shared Room"
     * @return a new Property instance with the specified attributes
     */
    Property create(String name, String rating, String discountedPrice, String originalPrice, String roomType);
}
