package usecases.property;

import entities.Property;
import java.util.List;

public class PropertySearchUseCase {
    private final PropertyRepository repository;

    public PropertySearchUseCase(PropertyRepository repository) {
        this.repository = repository;
    }

    public List<Property> searchProperties(PropertySearchInputData inputData) throws Exception {
        // Get the city from inputData and pass it to the repository
        return repository.searchProperties(inputData.getCity());
    }
}
