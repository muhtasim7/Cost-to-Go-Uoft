package interface_adapters.signup;

import interface_adapters.ViewModel;

/**
 * The ViewModel for the Signup View.
 */
public class SignupViewModel extends ViewModel<SignupState> {

    public static final String TITLE_LABEL = "Sign Up View";
    public static final String USERNAME_LABEL = "Choose username";
    public static final String PASSWORD_LABEL = "Choose password";
    public static final String REPEAT_PASSWORD_LABEL = "Enter password again";
    public static final String PROGRAM_LABAEL = "Choose your program";
    public static final String GPA_LABEL = "Enter your GPA";
    public static final String DEGREE_LABEL = "Choose degree";
    public static final String LANGUAGE_LABEL = "Choose language";
    public static final String EMAIL_LABEL = "Write down email";

    public static final String SIGNUP_BUTTON_LABEL = "Sign up";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public static final String TO_LOGIN_BUTTON_LABEL = "Go to Login";

    public SignupViewModel() {
        super("sign up");
        setState(new SignupState());
    }

}
