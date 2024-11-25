package usecases.property;

import entities.Property;
import java.util.List;

public interface PropertyUserDataAccessInterface {
    List<Property> searchProperties(String city) throws Exception;
}
