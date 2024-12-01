package entities;

/**
 * Factory for creating CommonUser objects.
 */
public class CommonUserFactory implements UserFactory {

    @Override
    public User create(String name, String password, String gpa, String degree, String program, String language,
                       String email) {
        return new CommonUser(name, password, gpa, degree, program, language, email);
    }
}
