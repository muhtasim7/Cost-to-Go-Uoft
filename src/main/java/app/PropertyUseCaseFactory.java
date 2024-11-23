package app;

import interface_adapters.property.PropertyController;
import interface_adapters.property.PropertyPresenter;
import interface_adapters.property.PropertyViewModel;
import usecases.property.PropertyInputBoundary;
import usecases.property.PropertyInteractor;
import usecases.property.PropertyOutputBoundary;
import usecases.property.PropertyUserDataAccessInterface;
import view.PropertyView;

/**
 * This class contains the static factory function for creating the PropertyView.
 */
public final class PropertyUseCaseFactory {

    private PropertyUseCaseFactory() {
        // Prevent instantiation
    }

    public static PropertyView create(PropertyUserDataAccessInterface propertyUserDataAccess, String city) {
        PropertyViewModel propertyViewModel = new PropertyViewModel();
        PropertyController propertyController = createPropertyUseCase(propertyUserDataAccess, propertyViewModel);

        return new PropertyView(propertyController, propertyViewModel, city);
    }

    private static PropertyController createPropertyUseCase(
            PropertyUserDataAccessInterface propertyUserDataAccess,
            PropertyViewModel propertyViewModel) {

        PropertyOutputBoundary propertyPresenter = new PropertyPresenter(propertyViewModel);
        PropertyInputBoundary propertyInteractor = new PropertyInteractor(propertyUserDataAccess, propertyPresenter);

        return new PropertyController(propertyInteractor);
    }
}
