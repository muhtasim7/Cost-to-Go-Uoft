package usecases.change_password;

import data_access.FileUserDataAccessObject;
import entities.CommonUserFactory;
import entities.User;
import entities.UserFactory;
import interface_adapters.ViewManagerModel;
import interface_adapters.logged_in.LoggedInPresenter;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginViewModel;
import interface_adapters.signup.SignupPresenter;
import interface_adapters.signup.SignupViewModel;
import org.junit.Test;
import usecases.signup.SignupInteractor;
import usecases.signup.SignupUserDataAccessInterface;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ChangePasswordInteractorTest {
    @Test
    public void successTest() throws IOException {
        // Arrange: Input data for the password change
        ChangePasswordInputData inputData = new ChangePasswordInputData(
                "newPassword","Paul", "3.8", "BSc", "Computer Science", "English", "paul@example.com"
        );

        // Create a mock UserFactory and UserRepository
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        FileUserDataAccessObject userRepository = new FileUserDataAccessObject(csv, factory);

        // Add the user "Paul" to the repository to ensure they exist for the test
        User initialUser = factory.create("Paul", "oldPassword", "3.8", "BSc", "Computer Science", "English", "paul@example.com");
        userRepository.save(initialUser);
        ChangePasswordUserDataAccessInterface userRep = new FileUserDataAccessObject(csv, factory);

        // Custom presenter implementation to test the output
        ChangePasswordOutputBoundary successPresenter = new ChangePasswordOutputBoundary() {
            @Override
            public void prepareSuccessView(ChangePasswordOutputData outputData) {
                // Assertions to validate the output and repository state
                assertEquals("Paul", outputData.getUsername());
                assertEquals("newPassword", userRepository.get("Paul").getPassword());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToDashboardView() {
                // Expected behavior, no assertion needed
            }

            @Override
            public void switchToLogInView() {
                fail("Switch to LogInView is unexpected.");
            }

            @Override
            public void switchToItineraryView() {
                fail("Switch to ItineraryView is unexpected.");
            }
        };

        // Act: Create and execute the interactor
        ChangePasswordInputBoundary interactor = new ChangePasswordInteractor(userRepository, successPresenter, factory);
        interactor.execute(inputData);
    }

    @Test
    public void testSwitchToLoginView() throws IOException {
        ViewManagerModel viewModelManager = new ViewManagerModel();
        LoggedInViewModel loggedIn = new LoggedInViewModel();
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        ChangePasswordUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);

        // Add Paul to the repo so that when we check later they already exist

        // This creates a presenter that tests whether the test case is as we expect.
        LoggedInPresenter presenter = new LoggedInPresenter(viewModelManager, loggedIn);
        ChangePasswordInteractor interactor = new ChangePasswordInteractor(userRepository, presenter, factory);
        interactor.switchToLogInView();
        assertEquals("log in", viewModelManager.getState());

    }
    @Test
    public void testSwitchToDashboardView() throws IOException {
        ViewManagerModel viewModelManager = new ViewManagerModel();
        LoggedInViewModel loggedIn = new LoggedInViewModel();
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        ChangePasswordUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);

        // Add Paul to the repo so that when we check later they already exist

        // This creates a presenter that tests whether the test case is as we expect.
        LoggedInPresenter presenter = new LoggedInPresenter(viewModelManager, loggedIn);
        ChangePasswordInteractor interactor = new ChangePasswordInteractor(userRepository, presenter, factory);
        interactor.switchToDashboardView();
        assertEquals("dashboardView", viewModelManager.getState());

    }
    @Test
    public void testSwitchToItineraryView() throws IOException {
        ViewManagerModel viewModelManager = new ViewManagerModel();
        LoggedInViewModel loggedIn = new LoggedInViewModel();
        UserFactory factory = new CommonUserFactory();
        String csv = "./Data/users.csv";
        ChangePasswordUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);

        // Add Paul to the repo so that when we check later they already exist

        // This creates a presenter that tests whether the test case is as we expect.
        LoggedInPresenter presenter = new LoggedInPresenter(viewModelManager, loggedIn);
        ChangePasswordInteractor interactor = new ChangePasswordInteractor(userRepository, presenter, factory);
        interactor.switchToItineraryView();
        assertEquals("itinerary view", viewModelManager.getState());

    }}

