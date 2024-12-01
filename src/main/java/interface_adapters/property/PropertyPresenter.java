package interface_adapters.property;

import interface_adapters.ViewManagerModel;
import usecases.property.PropertyOutputBoundary;
import usecases.property.PropertyOutputData;
import view.ViewManager;

/**
 * The Presenter for the Property Use Case.
 */
public class PropertyPresenter implements PropertyOutputBoundary {

    private final PropertyViewModel propertyViewModel;
    private final ViewManagerModel viewManagerModel;

    public PropertyPresenter(PropertyViewModel propertyViewModel, ViewManagerModel viewManagerModel) {
        this.propertyViewModel = propertyViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void present(PropertyOutputData data) {
        // Update the ViewModel with property data
        propertyViewModel.getState().setProperties(data.getProperties());
        propertyViewModel.firePropertyChanged();
    }

    @Override
    public void switchToDashboardView() {
        // Switch to the dashboard using ViewManagerModel
        viewManagerModel.setState("dashboardView");
        viewManagerModel.firePropertyChanged();
    }
}
