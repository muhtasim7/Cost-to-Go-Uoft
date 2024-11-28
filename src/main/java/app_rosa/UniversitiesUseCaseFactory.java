package app_rosa;


import data_access_rosa.FileUniversitiesDataAccessObject;
import interface_adapter_rosa.universities.*;
import interface_adapters.ViewManagerModel;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginController;
import use_case_rosa.universities.*;
import usecases.login.LoginUserDataAccessInterface;
import view_rosa.UniversitiesView;
import interface_adapters.logged_in.LoggedInState;

/**
 * Factory for creating the Universities use case and view.
 */
public final class UniversitiesUseCaseFactory {

    private UniversitiesUseCaseFactory() {}

    /**
     * Create the UniversitiesView.
     * @return the constructed UniversitiesView.
     */
    public static UniversitiesView create(
            ViewManagerModel viewManagerModel,
            UniversitiesViewModel universitiesViewModel,
            UniversitiesDataAccessInterface universitiesDataAccessObject,
            LoggedInViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        final UniversitiesController universitiesController = createUniversitiesUseCase(viewManagerModel, universitiesViewModel,universitiesDataAccessObject, loggedInViewModel, userDataAccessObject);

        return new UniversitiesView(universitiesController,universitiesViewModel, loggedInViewModel.getState());
    }

    private static UniversitiesController createUniversitiesUseCase(
            ViewManagerModel viewManagerModel,
            UniversitiesViewModel universitiesViewModel,
            UniversitiesDataAccessInterface universitiesDataAccessObject,
            LoggedInViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessInterface) {

    // pass this methods parameter to the presenter?
        final UniversitiesOutputBoundary universitiesOutputBoundary = new UniversitiesPresenter(viewManagerModel, universitiesViewModel);

        final UniversitiesInputBoundary universitiesInteractor = new UniversitiesInteractor(universitiesDataAccessObject, universitiesOutputBoundary);

        return new UniversitiesController(universitiesInteractor);
    }
}
