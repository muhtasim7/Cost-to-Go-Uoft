package interface_adapters_sim.property;

import entities.Property;
import usecases_sim.property.PropertySearchInputData;
import usecases_sim.property.PropertySearchUseCase;

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
