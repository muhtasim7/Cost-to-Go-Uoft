package usecases;

import entities.Property;
import java.util.List;

public interface PropertyRepository {
    List<Property> searchProperties(String city) throws Exception;
}
