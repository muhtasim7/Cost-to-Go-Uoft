package app_rosa;


import data_access_rosa.FileUniversitiesDataAccessObject;
import interface_adapter_rosa.universities.*;
import interface_adapters.ViewManagerModel;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginController;
import use_case_rosa.universities.*;
import usecases.login.LoginUserDataAccessInterface;
import view_rosa.UniversitiesView;
import use_case_rosa.universities.UniversitiesUserDataAccessInterface;

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
            UniversitiesUserDataAccessInterface universitiesUserDataAccessObject, // added for user data access
            LoggedInViewModel loggedInViewModel,
            LoginUserDataAccessInterface userDataAccessObject) {

        final UniversitiesController universitiesController = createUniversitiesUseCase(viewManagerModel, universitiesViewModel,universitiesDataAccessObject);

        return new UniversitiesView(universitiesController,universitiesViewModel, universitiesUserDataAccessObject);
    }

    public static UniversitiesController createUniversitiesUseCase(
            ViewManagerModel viewManagerModel,
            UniversitiesViewModel universitiesViewModel,
            UniversitiesDataAccessInterface universitiesDataAccessObject) {

    // pass this methods parameter to the presenter?
        final UniversitiesOutputBoundary universitiesOutputBoundary = new UniversitiesPresenter(viewManagerModel, universitiesViewModel);
        final UniversitiesInputBoundary universitiesInteractor = new UniversitiesInteractor(universitiesOutputBoundary);
        return new UniversitiesController(universitiesInteractor);
    }
}
