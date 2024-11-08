package controller;

import model.User;
import service.AuthService;

public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public boolean signUp(String username, String password) {
        User user = new User(username, password);
        return authService.signUp(user);
    }

    public boolean login(String username, String password) {
        return authService.login(username, password);
    }
}
