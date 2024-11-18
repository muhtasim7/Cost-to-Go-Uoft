package usecases;

import entities.Property;
import java.util.List;

public class PropertySearchUseCase {
    private final PropertyRepository repository;

    public PropertySearchUseCase(PropertyRepository repository) {
        this.repository = repository;
    }

    public List<Property> searchProperties(String city) throws Exception {
        return repository.searchProperties(city);
    }
}
