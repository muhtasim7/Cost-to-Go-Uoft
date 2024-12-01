package interface_adapters.logged_in;

import interface_adapters.ViewManagerModel;
import usecases.change_password.ChangePasswordOutputBoundary;
import usecases.change_password.ChangePasswordOutputData;

/**
 * The Presenter for the Change Password Use Case.
 */
public class LoggedInPresenter implements ChangePasswordOutputBoundary {

    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoggedInPresenter(ViewManagerModel viewManagerModel,
                             LoggedInViewModel loggedInViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
    }

    @Override
    public void prepareSuccessView(ChangePasswordOutputData outputData) {

        loggedInViewModel.firePropertyChanged("password");

    }

    @Override
    public void prepareFailView(String error) {

    }

    @Override
    public void switchToDashboardView() {
        viewManagerModel.setState("dashboardView");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToItineraryView() {
        viewManagerModel.setState("itinerary view");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToLogInView() {
        viewManagerModel.setState("log in");
        viewManagerModel.firePropertyChanged();
    }
}
