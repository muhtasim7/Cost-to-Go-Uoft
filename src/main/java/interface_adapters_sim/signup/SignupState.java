package interface_adapters.signup;

/**
 * The state for the Signup View Model.
 */
public class SignupState {
    private String username = "";
    private String usernameError;
    private String password = "";
    private String passwordError;
    private String repeatPassword = "";
    private String repeatPasswordError;
    private String email = "";
    private String gpa;
    private String degree;
    private String program = "";
    private String language = "";

    public String getUsername() {
        return username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getRepeatPasswordError() {
        return repeatPasswordError;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    @Override
    public String toString() {
        return "SignupState{"
                + "username='" + username + '\''
                + ", password='" + password + '\''
                + ", repeatPassword='" + repeatPassword + '\''
                + '}';
    }

    public String getGpa() {
        return gpa;
    }
    public void setGpa(String gpa) {this.gpa = gpa;}
    public String getDegree() {return degree;}
    public void setDegree(String degree) {this.degree = degree;}
    public String getProgram() {return program;}
    public void setProgram(String program) {this.program = program;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getLanguage() {return language;}
    public void setLanguage(String language) {this.language = language;}

}
