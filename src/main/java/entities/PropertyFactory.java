package entities;

public interface PropertyFactory {
    Property create(String name, String rating, String discountedPrice, String originalPrice, String roomType);
}
