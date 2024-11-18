package interface_adapters.property;

import entities.Property;
import usecases.property.PropertySearchInputData;
import usecases.property.PropertySearchUseCase;

import java.util.List;

public class PropertyController {
    private final PropertySearchUseCase propertySearchUseCase;
    private final PropertySearchPresenter presenter;

    public PropertyController(PropertySearchUseCase propertySearchUseCase, PropertySearchPresenter presenter) {
        this.propertySearchUseCase = propertySearchUseCase;
        this.presenter = presenter;
    }

    public void searchProperties(String city) {
        PropertySearchInputData inputData = new PropertySearchInputData(city);
        try {
            List<Property> results = propertySearchUseCase.searchProperties(inputData);
            presenter.presentSearchResults(results);  // Display results in the GUI table
        } catch (Exception e) {
            System.out.println("Error occurred during property search: " + e.getMessage());
        }
    }
}
