package model;

public class User {
    private String username;
    private String password;

    /**
     * setting up user based on username and password.
     * @param username new user's username.
     * @param password new user's password.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * getting the username.
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * getting the password.
     * @return the password.
     */
    public String getPassword() {
        return password;
    }
}
