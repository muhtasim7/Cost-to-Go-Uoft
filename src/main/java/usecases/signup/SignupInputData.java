package usecases.signup;

/**
 * The Input Data for the Signup Use Case.
 */
public class SignupInputData {

    private final String username;
    private final String password;
    private final String repeatPassword;
    private final String email;
    private final String gpa;
    private final String degree;
    private final String program;
    private final String language;

    public SignupInputData(String username, String password, String repeatPassword, String gpa, String degree, String program, String language, String email) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
        this.gpa = gpa;
        this.degree = degree;
        this.language = language;
        this.program = program;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
    public String getEmail() {return email;}
    public String getGpa() {return gpa;}
    public String getDegree() {return degree;}
    public String getProgram() {return program;}
    public String getLanguage() {return language;}
}
