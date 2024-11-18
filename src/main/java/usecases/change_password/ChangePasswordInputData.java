package usecases.change_password;

/**
 * The input data for the Change Password Use Case.
 */
public class ChangePasswordInputData {

    private final String password;
    private final String username;
    private final String gpa;
    private final String degree;
    private final String program;
    private final String language;
    private final String email;


    public ChangePasswordInputData(String password, String username, String gpa, String degree, String program, String language, String email) {
        this.password = password;
        this.username = username;
        this.gpa = gpa;
        this.degree = degree;
        this.program = program;
        this.language = language;
        this.email = email;
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }

    String getGpa() {return gpa;}
    String getDegree() {return degree;}
    String getProgram() {return program;}
    String getLanguage() {return language;}
    String getEmail() {return email;}

}
