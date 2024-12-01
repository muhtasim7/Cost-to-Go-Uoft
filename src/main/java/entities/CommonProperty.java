package entities;

/**
 * Represents a property with details such as name, rating, prices, and room type.
 * This class is an implementation of the Property interface.
 */

public class CommonProperty implements Property {
    private final String name;
    private final String rating;
    private final String discountedPrice;
    private final String originalPrice;
    private final String roomType;

    /**
     * Constructs a new CommonProperty object with the specified details.
     *
     * @param name             the name of the property
     * @param rating           the rating of the property
     * @param discountedPrice  the discounted price of the property
     * @param originalPrice    the original price of the property
     * @param roomType         the type of room (e.g., "Entire Place", "Shared Room")
     */

    public CommonProperty(String name, String rating, String discountedPrice, String originalPrice, String roomType) {
        this.name = name;
        this.rating = rating;
        this.discountedPrice = discountedPrice;
        this.originalPrice = originalPrice;
        this.roomType = roomType;
    }

    /**
     * Gets the name of the property.
     *
     * @return the property name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the rating of the property.
     *
     * @return the property rating
     */
    @Override
    public String getRating() {
        return rating;
    }

    /**
     * Gets the discounted price of the property.
     *
     * @return the discounted price as a string
     */
    @Override
    public String getDiscountedPrice() {
        return discountedPrice;
    }

    /**
     * Gets the original price of the property.
     *
     * @return the original price as a string
     */
    @Override
    public String getOriginalPrice() {
        return originalPrice;
    }

    /**
     * Gets the room type of the property.
     *
     * @return the room type (e.g., "Entire Place", "Shared Room")
     */
    @Override
    public String getRoomType() {
        return roomType;
    }

    /**
     * Returns a string representation of the property, including all its details.
     *
     * @return a string representation of the property
     */
    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                ", discountedPrice='" + discountedPrice + '\'' +
                ", originalPrice='" + originalPrice + '\'' +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}
