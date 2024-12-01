package usecases.login;

/**
 * Input Boundary for actions which are related to logging in.
 */
public interface LoginInputBoundary {

    /**
     * Executes the login use case.
     * @param loginInputData the input data
     */
    void execute(LoginInputData loginInputData);
    /**
     * Switch to the LogIn View Use Case.
     */

    void switchToLoginView();
}
