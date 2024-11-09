package service;

import model.User;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class AuthServiceTest {

    private AuthService authService;

    @Before
    public void setUp() {
        // Create a new AuthService with a test file path
        authService = new AuthService();
    }


    @Test
    public void testSignUp() {
        User user = new User("testuser", "password123");
        assertTrue("User should sign up successfully", authService.signUp(user));
    }

    @Test
    public void testLoginSuccess() {
        User user = new User("testuser", "password123");
        authService.signUp(user);

        // Test successful login
        assertTrue("User should be able to log in with correct credentials", authService.login("testuser", "password123"));
    }

    @Test
    public void testLoginFailure() {
        User user = new User("testuser", "password123");
        authService.signUp(user);

        // Test failed login with incorrect password
        assertFalse("User should not be able to log in with incorrect password", authService.login("testuser", "wrongpassword"));

        // Test failed login with non-existent username
        assertFalse("Non-existent user should not be able to log in", authService.login("nonexistent", "password123"));
    }
}
