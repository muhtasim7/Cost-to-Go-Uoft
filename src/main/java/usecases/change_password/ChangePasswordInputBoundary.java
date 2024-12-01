package usecases.change_password;

/**
 * The Change Password Use Case.
 */
public interface ChangePasswordInputBoundary {

    /**
     * Execute the Change Password Use Case.
     * @param changePasswordInputData the input data for this use case
     */
    void execute(ChangePasswordInputData changePasswordInputData);
    /**
     * Switch to Dashboard View Use Case.
     */

    void switchToDashboardView();
    void switchToItineraryView();
    /**
     * Switch to the LogIn View Use Case.
     */

    void switchToLogInView();

}
