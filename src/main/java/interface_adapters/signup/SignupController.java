package interface_adapters.signup;

import usecases.signup.SignupInputBoundary;
import usecases.signup.SignupInputData;

/**
 * Controller for the Signup Use Case.
 */
public class SignupController {

    private final SignupInputBoundary userSignupUseCaseInteractor;

    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * Executes the Signup Use Case.
     * @param username the username to sign up
     * @param password1 the password
     * @param password2 the password repeated
     * @param gpa the gpa of user
     * @param degree the degree of the user
     * @param program the program of the user
     * @param language the language of the user
     * @param email the emial of the user
     */
    public void execute(String username, String password1, String password2, String gpa, String degree, String program,
                        String language, String email) {
        final SignupInputData signupInputData = new SignupInputData(
                username, password1, password2, gpa, degree, program, language, email);

        userSignupUseCaseInteractor.execute(signupInputData);
    }

    /**
     * Executes the "switch to LoginView" Use Case.
     */
    public void switchToLoginView() {
        userSignupUseCaseInteractor.switchToLoginView();
    }
}
