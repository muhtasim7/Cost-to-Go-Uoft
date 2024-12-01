package app;

import entities.Property;
import interface_adapters.ViewManagerModel;
import interface_adapters.property.PropertyController;
import interface_adapters.property.PropertyPresenter;
import interface_adapters.property.PropertySelectedCallback;
import interface_adapters.property.PropertyState;
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

    /** Prevent instantiation. */
    private PropertyUseCaseFactory() {}

    /**
     * Factory function for creating the PropertyView.
     * @param viewManagerModel the ViewManagerModel to inject into the PropertyView
     * @param propertyViewModel the PropertyViewModel to inject into the PropertyView
     * @param propertyUserDataAccess the PropertyUserDataAccessInterface to inject into the PropertyInteractor
     * @param city the city to search properties in
     * @param state the shared PropertyState to store the selected property
     * @return the PropertyView created for the provided input classes
     */
    public static PropertyView create(
            ViewManagerModel viewManagerModel,
            PropertyViewModel propertyViewModel,
            PropertyUserDataAccessInterface propertyUserDataAccess,
            String city,
            PropertyState state) {

        final PropertyController propertyController = createPropertyUseCase(
                viewManagerModel, propertyViewModel, propertyUserDataAccess);

        //IntelJ recommended: "Anonymous new PropertySelectedCallback() can be replaced with referenced"
        PropertySelectedCallback callback = state::setSelectedProperty;

        return new PropertyView(propertyController, propertyViewModel, city, callback);
    }

    /**
     * Helper function to create the PropertyController.
     * @param viewManagerModel the ViewManagerModel to inject into the Presenter
     * @param propertyViewModel the PropertyViewModel to inject into the Presenter
     * @param propertyUserDataAccess the PropertyUserDataAccessInterface to inject into the Interactor
     * @return the PropertyController
     */
    private static PropertyController createPropertyUseCase(
            ViewManagerModel viewManagerModel,
            PropertyViewModel propertyViewModel,
            PropertyUserDataAccessInterface propertyUserDataAccess) {

        final PropertyOutputBoundary propertyPresenter = new PropertyPresenter(propertyViewModel, viewManagerModel);

        final PropertyInputBoundary propertyInteractor =
                new PropertyInteractor(propertyUserDataAccess, propertyPresenter);

        return new PropertyController(propertyInteractor);
    }
}
