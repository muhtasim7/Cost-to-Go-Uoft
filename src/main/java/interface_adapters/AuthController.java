//package interface_adapters;
//
//import entities.User;
//import usecases.AuthService;
//
//public class AuthController {
//    private final AuthService authService;
//
//    /**
//     * This is the constructor for the class.
//     * @param authService allows AuthController to be initialized.
//     */
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    /**
//     * Setting up the information to be passed on to authService by calling on User for sign up.
//     * @param username the new user's username.
//     * @param password the new user's password.
//     * @return the authService.
//     */
//    public boolean signUp(String username, String password) {
//        User user = new User(username, password);
//        return authService.signUp(user);
//    }
//
//    /**
//     * Setting up the information to be passed on to authService.
//     * @param username the user's username.
//     * @param password the user's password.
//     * @return the authService.
//     */
//    public boolean login(String username, String password) {
//        return authService.login(username, password);
//    }
//}
