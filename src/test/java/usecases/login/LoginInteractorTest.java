package usecases.login;

import data_access.FileUserDataAccessObject;
import entities.CommonUserFactory;
import entities.User;
import entities.UserFactory;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class LoginInteractorTest {

    @Test
    public void successTest() throws IOException {
        LoginInputData inputData = new LoginInputData("Paul", "password");
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        LoginUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);

        // For the success test, we need to add Paul to the data access repository before we log in.

        User user = factory.create("Paul", "password","gpa","degree","program","language","email");
        userRepository.save(user);

        // This creates a successPresenter that tests whether the test case is as we expect.
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals("Paul", user.getUsername());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToLoginView() {

            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void successUserLoggedInTest() throws IOException {
        LoginInputData inputData = new LoginInputData("Paul", "password");
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        LoginUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);

        // For the success test, we need to add Paul to the data access repository before we log in.
        User user = factory.create("Paul", "password","gpa","degree","program","language","email");
        userRepository.save(user);

        // This creates a successPresenter that tests whether the test case is as we expect.
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals("Paul", userRepository.getCurrentUser());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToLoginView() {

            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
        assertNull(userRepository.getCurrentUser());
        interactor.execute(inputData);
    }


    @Test
    public void failurePasswordMismatchTest() throws IOException {
        LoginInputData inputData = new LoginInputData("Paul", "wrong");
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        LoginUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);

        // For this failure test, we need to add Paul to the data access repository before we log in, and
        // the passwords should not match.
        User user = factory.create("Paul", "password","gpa","degree","program","language","email");
        userRepository.save(user);

        // This creates a presenter that tests whether the test case is as we expect.
        LoginOutputBoundary failurePresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Incorrect password for \"Paul\".", error);
            }

            @Override
            public void switchToLoginView() {

            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserDoesNotExistTest() throws IOException {
        LoginInputData inputData = new LoginInputData("Paul", "password");
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        LoginUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);

        // Add Paul to the repo so that when we check later they already exist

        // This creates a presenter that tests whether the test case is as we expect.
        LoginOutputBoundary failurePresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Paul: Account does not exist.", error);
            }

            @Override
            public void switchToLoginView() {

            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, failurePresenter);
        interactor.execute(inputData);
    }}
