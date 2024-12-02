package usecases.signup;

import data_access.FileUserDataAccessObject;
import entities.CommonUserFactory;
import entities.User;
import entities.UserFactory;
import interface_adapters.ViewManagerModel;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginPresenter;
import interface_adapters.login.LoginViewModel;
import interface_adapters.signup.SignupPresenter;
import interface_adapters.signup.SignupViewModel;
import org.junit.Test;
import usecases.login.LoginInteractor;
import usecases.login.LoginUserDataAccessInterface;

import java.io.IOException;

import static org.junit.Assert.*;


public class SignupInteractorTest {

    @Test
    public void successTest() throws IOException {
        SignupInputData inputData = new SignupInputData("Paul", "password", "password","gpa","degree","program","language","email");
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        SignupUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);

        // This creates a successPresenter that tests whether the test case is as we expect.
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("Paul", user.getUsername());
                assertTrue(userRepository.existsByName("Paul"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToLoginView() {
                // This is expected
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, new CommonUserFactory());
        interactor.execute(inputData);
    }

    @Test
    public void failurePasswordMismatchTest() throws IOException {
        SignupInputData inputData = new SignupInputData("Paul", "password", "wrong","gpa","degree","program","language","email");
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        SignupUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);

        // This creates a presenter that tests whether the test case is as we expect.
        SignupOutputBoundary failurePresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Passwords don't match.", error);
            }

            @Override
            public void switchToLoginView() {
                // This is expected
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, failurePresenter, new CommonUserFactory());
        interactor.execute(inputData);
    }

    @Test
    public void failureUserExistsTest() throws IOException {
        SignupInputData inputData = new SignupInputData("Paul", "password", "wrong", "gpa","degree","program","language","email");
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        SignupUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);

        // Add Paul to the repo so that when we check later they already exist
        User user = factory.create("Paul", "pwd", "gpa","degree","program","language","email");
        userRepository.save(user);

        // This creates a presenter that tests whether the test case is as we expect.
        SignupOutputBoundary failurePresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("User already exists.", error);
            }

            @Override
            public void switchToLoginView() {
                // This is expected
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, failurePresenter, new CommonUserFactory());
        interactor.execute(inputData);
    }
    @Test
    public void testSwitchToLoginView() throws IOException {
        ViewManagerModel viewModelManager = new ViewManagerModel();
        LoginViewModel login = new LoginViewModel();
        SignupViewModel signup = new SignupViewModel();
        LoggedInViewModel loggedIn = new LoggedInViewModel();
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        SignupUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);

        // Add Paul to the repo so that when we check later they already exist

        // This creates a presenter that tests whether the test case is as we expect.
        SignupPresenter presenter = new SignupPresenter(viewModelManager,signup, login);
        SignupInteractor interactor = new SignupInteractor(userRepository, presenter, factory);
        interactor.switchToLoginView();
        assertEquals("log in", viewModelManager.getState());

    }}