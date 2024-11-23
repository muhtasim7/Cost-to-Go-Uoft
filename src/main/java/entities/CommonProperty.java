package entities;

public class CommonProperty implements Property {
    private final String name;
    private final String rating;
    private final String discountedPrice;
    private final String originalPrice;
    private final String roomType;

    public CommonProperty(String name, String rating, String discountedPrice, String originalPrice, String roomType) {
        this.name = name;
        this.rating = rating;
        this.discountedPrice = discountedPrice;
        this.originalPrice = originalPrice;
        this.roomType = roomType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRating() {
        return rating;
    }

    @Override
    public String getDiscountedPrice() {
        return discountedPrice;
    }

    @Override
    public String getOriginalPrice() {
        return originalPrice;
    }

    @Override
    public String getRoomType() {
        return roomType;
    }
}
