package interface_adapters.property;

import interface_adapters.ViewManagerModel;
import usecases.property.PropertyOutputBoundary;
import usecases.property.PropertyOutputData;

/**
 * The Presenter for the Property Use Case.
 * Responsible for receiving output data from the interactor, updating the ViewModel,
 * and managing view transitions.
 */
public class PropertyPresenter implements PropertyOutputBoundary {

    private final PropertyViewModel propertyViewModel;
    private final ViewManagerModel viewManagerModel;


    /**
     * Constructs a new PropertyPresenter with the specified ViewModel and ViewManagerModel.
     *
     * @param propertyViewModel the ViewModel that stores property-related state and data
     * @param viewManagerModel  the ViewManagerModel responsible for managing the current view state
     */
    public PropertyPresenter(PropertyViewModel propertyViewModel, ViewManagerModel viewManagerModel) {
        this.propertyViewModel = propertyViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    /**
     * Updates the Property ViewModel with the data received from the interactor.
     * This method is called when the use case produces output data.
     *
     * @param data the output data containing the list of properties to be displayed
     */
    @Override
    public void present(PropertyOutputData data) {
        propertyViewModel.getState().setProperties(data.getProperties());
        propertyViewModel.firePropertyChanged();
    }

    /**
     * Switches the view to the dashboard.
     * Updates the ViewManagerModel to reflect the transition to the "dashboardView".
     */
    @Override
    public void switchToDashboardView() {
        viewManagerModel.setState("dashboardView");
        viewManagerModel.firePropertyChanged();
    }
}
