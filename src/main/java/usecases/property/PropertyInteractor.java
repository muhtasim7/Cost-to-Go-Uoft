package usecases.property;

import entities.Property;

import java.util.List;

/**
 * The interactor for the Property Use Case.
 * Implements the core business logic of fetching and presenting property data.
 */
public class PropertyInteractor implements PropertyInputBoundary {
    private final PropertyUserDataAccessInterface userDataAccess;
    private final PropertyOutputBoundary presenter;

    /**
     * Constructs a new PropertyInteractor.
     *
     * @param userDataAccess the data access interface to fetch property data
     * @param presenter the output boundary to handle presentation logic
     */
    public PropertyInteractor(PropertyUserDataAccessInterface userDataAccess, PropertyOutputBoundary presenter) {
        this.userDataAccess = userDataAccess;
        this.presenter = presenter;
    }

    /**
     * Handles the input data for the Property Use Case.
     * Fetches property data based on the input city and passes it to the presenter.
     *
     * @param inputData the input data for this use case
     * @throws Exception if an error occurs during data retrieval
     */
    @Override
    public void handle(PropertyInputData inputData) throws Exception {
        // Fetch properties from the data access interface
        List<Property> properties = userDataAccess.searchProperties(inputData.getCity());

        // Prepare the output data
        PropertyOutputData outputData = new PropertyOutputData(properties);

        // Pass the output data to the presenter
        presenter.present(outputData);
    }

    /**
     * Switches to the dashboard view.
     * Invokes the presenter's method to transition the application state to the dashboard.
     */
    @Override
    public void switchToDashboardView() {
        presenter.switchToDashboardView();
    }
}
