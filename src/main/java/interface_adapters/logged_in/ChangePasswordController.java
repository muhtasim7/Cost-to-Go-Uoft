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
     * @param gpa the new gpa
     * @param degree the new degree type
     * @param program the new program
     * @param language the new langauge
     * @param email the new email
     */
    public void execute(String password, String username, String gpa, String degree, String program, String language,
                        String email) {
        final ChangePasswordInputData changePasswordInputData = new ChangePasswordInputData(username, password, gpa,
                degree, program, language, email);

        userChangePasswordUseCaseInteractor.execute(changePasswordInputData);
    }
    /**
     * Executes the "switch to DashboardView" Use Case.
     */

    public void switchToDashboardView() {
        userChangePasswordUseCaseInteractor.switchToDashboardView();
    }
    /**
     * Executes the "switch to LoginView" Use Case.
     */

    public void switchToLogInView() {
        userChangePasswordUseCaseInteractor.switchToLogInView();
    }

}
