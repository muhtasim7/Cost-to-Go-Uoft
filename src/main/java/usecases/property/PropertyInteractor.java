package usecases.property;

import entities.Property;

import java.util.List;

public class PropertyInteractor implements PropertyInputBoundary {
    private final PropertyUserDataAccessInterface userDataAccess;
    private final PropertyOutputBoundary presenter;

    public PropertyInteractor(PropertyUserDataAccessInterface userDataAccess, PropertyOutputBoundary presenter) {
        this.userDataAccess = userDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void handle(PropertyInputData inputData) throws Exception {
        // Fetch properties from the data access interface
        List<Property> properties = userDataAccess.searchProperties(inputData.getCity());

        // Prepare the output data
        PropertyOutputData outputData = new PropertyOutputData(properties);

        // Pass the output data to the presenter
        presenter.present(outputData);
    }

    @Override
    public void switchToDashboardView() {
        presenter.switchToDashboardView();
    }
}
