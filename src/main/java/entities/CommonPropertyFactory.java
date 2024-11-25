package entities;

public class CommonPropertyFactory implements PropertyFactory {
    @Override
    public Property create(String name, String rating, String discountedPrice, String originalPrice, String roomType) {
        return new CommonProperty(name, rating, discountedPrice, originalPrice, roomType);
    }
}
