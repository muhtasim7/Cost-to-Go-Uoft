package interface_adapters.logged_in;

import usecases.change_password.ChangePasswordInputBoundary;
import usecases.change_password.ChangePasswordInputData;

/**
 * Controller for the Change Password Use Case.
 */
public class ChangePasswordController {
    private final ChangePasswordInputBoundary userChangePasswordUseCaseInteractor;

    public ChangePasswordController(ChangePasswordInputBoundary userChangePasswordUseCaseInteractor) {
        this.userChangePasswordUseCaseInteractor = userChangePasswordUseCaseInteractor;
    }

    /**
     * Executes the Change Password Use Case.
     * @param password the new password
     * @param username the user whose password to change
     */
    public void execute(String password, String username, String gpa, String degree, String program, String langauge, String email) {
        final ChangePasswordInputData changePasswordInputData = new ChangePasswordInputData(username, password, gpa, degree, program, langauge, email);

        userChangePasswordUseCaseInteractor.execute(changePasswordInputData);
    }
    /**
     * Executes the "switch to DashboardView" Use Case.
     */
    public void switchToDashboardView() {
        userChangePasswordUseCaseInteractor.switchToDashboardView();
    }
}
