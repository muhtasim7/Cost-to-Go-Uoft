//package entities;
//
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class UserTest {
//
//    private User user;
//
//    @Before
//    public void setUp() {
//        user = new User("testuser", "password123");
//    }
//
//    @Test
//    public void testGetUsername() {
//        assertEquals("Username should be 'testuser'", "testuser", user.getUsername());
//    }
//
//    @Test
//    public void testGetPassword() {
//        assertEquals("Password should be 'password123'", "password123", user.getPassword());
//    }
//
//    @Test
//    public void testSetUsernameAndPassword() {
//        // Testing the immutability of the User object
//        User newUser = new User("newuser", "newpassword");
//        assertEquals("Username should be 'newuser'", "newuser", newUser.getUsername());
//        assertEquals("Password should be 'newpassword'", "newpassword", newUser.getPassword());
//    }
//}
