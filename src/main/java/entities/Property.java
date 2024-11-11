package entities;

public class Property {
    private final String listingName;
    private final String avgRatingLocalized;
    private final String discountedPrice;
    private final String originalPrice;
    private final String roomType;


    public Property(String listingName, String avgRatingLocalized, String discountedPrice, String originalPrice, String RoomType) {
        this.listingName = listingName;
        this.avgRatingLocalized = avgRatingLocalized;
        this.discountedPrice = discountedPrice;
        this.originalPrice = originalPrice;
        this.roomType = RoomType;
    }

    // Getters
    public String getListingName() { return listingName; }
    public String getAvgRatingLocalized() { return avgRatingLocalized; }
    public String getDiscountedPrice() { return discountedPrice; }
    public String getOriginalPrice() { return originalPrice; }
    public String getRoomTye() { return  roomType; }
}
