//package interface_adapters;
//
//import org.junit.Before;
//import org.junit.Test;
//import usecases.AuthService;
//
//import static org.junit.Assert.*;
//
//public class AuthControllerTest {
//
//    private AuthController authController;
//    private AuthService authService;
//
//    @Before
//    public void setUp() {
//        // Use a test AuthService
//        authService = new AuthService();
//        authController = new AuthController(authService);
//    }
//
//    @Test
//    public void testSignUp() {
//        assertTrue("User should be able to sign up", authController.signUp("testuser", "password123"));
//    }
//
//    @Test
//    public void testLogin() {
//        authController.signUp("testuser", "password123");
//
//        assertTrue("User should be able to log in with correct credentials", authController.login("testuser", "password123"));
//        assertFalse("User should not be able to log in with incorrect password", authController.login("testuser", "wrongpassword"));
//        assertFalse("Non-existent user should not be able to log in", authController.login("nonexistent", "password123"));
//    }
//}
