package interface_adapters;

import entities.Property;
import usecases.PropertySearchUseCase;

import java.util.List;

public class PropertyController {
    private final PropertySearchUseCase propertySearchUseCase;

    public PropertyController(PropertySearchUseCase propertySearchUseCase) {
        this.propertySearchUseCase = propertySearchUseCase;
    }

    public List<Property> searchProperties(String city) throws Exception {
        return propertySearchUseCase.searchProperties(city);
    }
}
