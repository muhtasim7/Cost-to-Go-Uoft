package entities;


/**
 * A factory class for creating instances of CommonProperty.
 * Implements the PropertyFactory interface.
 */
public class CommonPropertyFactory implements PropertyFactory {

    /**
     * Creates a new instance with the specified details.
     *
     * @param name             the name of the property
     * @param rating           the rating of the property
     * @param discountedPrice  the discounted price of the property
     * @param originalPrice    the original price of the property
     * @param roomType         the type of room (e.g., "Entire Place", "Shared Room")
     * @return a new instance of with the provided details
     */
    @Override
    public Property create(String name, String rating, String discountedPrice, String originalPrice, String roomType) {
        return new CommonProperty(name, rating, discountedPrice, originalPrice, roomType);
    }
}
