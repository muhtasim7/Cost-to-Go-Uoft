package entities;

/**
 * A simple implementation of the User interface.
 */
public class CommonUser implements User {

    private final String name;
    private final String password;
    private final String email;
    private final String degree;
    private final String program;
    private final String gpa;
    private final String language;

    public CommonUser(String name, String password, String gpa, String degree, String program, String langauge, String email) {
        this.name = name;
        this.password = password;

        this.email = email;
        this.degree = degree;
        this.program = program;
        this.gpa = gpa;
        this.language = langauge;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getGpa() {
        return this.gpa;
    }

    @Override
    public String getDegreeType() {
        return degree;
    }

    @Override
    public String getProgram() {
        return this.program;
    }
    @Override
    public String getLanguage(){
        return this.language;
    }

}
