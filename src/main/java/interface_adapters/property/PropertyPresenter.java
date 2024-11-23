package interface_adapters.property;

import usecases.property.PropertyOutputBoundary;
import usecases.property.PropertyOutputData;

/**
 * The Presenter for the Property Use Case.
 */
public class PropertyPresenter implements PropertyOutputBoundary {

    private final PropertyViewModel propertyViewModel;

    public PropertyPresenter(PropertyViewModel propertyViewModel) {
        this.propertyViewModel = propertyViewModel;
    }

    @Override
    public void present(PropertyOutputData data) {
        // Update the ViewModel with the list of properties
        final PropertyState state = propertyViewModel.getState();
        state.setProperties(data.getProperties());
        propertyViewModel.setState(state);
        propertyViewModel.firePropertyChanged();
    }

    @Override
    public void handleError(String error) {
        // Log or display errors, but this is not reflected in the state
        System.out.println("Error occurred: " + error);
    }
}
