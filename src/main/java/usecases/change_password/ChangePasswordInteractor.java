package usecases.change_password;

import entities.User;
import entities.UserFactory;

/**
 * The Change Password Interactor.
 */
public class ChangePasswordInteractor implements ChangePasswordInputBoundary {
    private final ChangePasswordUserDataAccessInterface userDataAccessObject;
    private final ChangePasswordOutputBoundary userPresenter;
    private final UserFactory userFactory;

    public ChangePasswordInteractor(ChangePasswordUserDataAccessInterface changePasswordDataAccessInterface,
                                    ChangePasswordOutputBoundary changePasswordOutputBoundary,
                                    UserFactory userFactory) {
        this.userDataAccessObject = changePasswordDataAccessInterface;
        this.userPresenter = changePasswordOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(ChangePasswordInputData changePasswordInputData) {
        final User user = userFactory.create(changePasswordInputData.getUsername(),
                                             changePasswordInputData.getPassword(), changePasswordInputData.getGpa(),
                changePasswordInputData.getDegree(), changePasswordInputData.getProgram(), changePasswordInputData
                        .getLanguage(), changePasswordInputData.getEmail());
        userDataAccessObject.changeInformation(user);

        final ChangePasswordOutputData changePasswordOutputData = new ChangePasswordOutputData(user.getName(),
                                                                                  false);
        userPresenter.prepareSuccessView(changePasswordOutputData);
    }

    @Override
    public void switchToDashboardView() {
        userPresenter.switchToDashboardView();
    }

    @Override
    public void switchToLogInView() {
        userPresenter.switchToLogInView();

    }
}
