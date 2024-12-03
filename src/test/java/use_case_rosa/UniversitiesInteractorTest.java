package use_case_rosa;


import data_access.FileUserDataAccessObject;
import entities.CommonUserFactory;
import entities.User;
//import entities.UserFactory;
//import org.junit.Before;
//import org.junit.Test;
//import usecases.login.LoginInputBoundary;
//import usecases.login.LoginInputData;
//import usecases.login.LoginInteractor;
//import usecases.login.LoginUserDataAccessInterface;
//
//import java.io.IOException;
//
//public class UniversitiesInteractorTest {
//
//    @Before
//    public void setUp() throws IOException {
//
//        // set up the current user
//        LoginInputData inputData = new LoginInputData("Paul", "password");
//        UserFactory factory = new CommonUserFactory();
//        String csv = "./Data/users.csv";
//        LoginUserDataAccessInterface userRepository = new FileUserDataAccessObject(csv, factory);
//
//        // For the success test, we need to add Paul to the data access repository before we log in.
//        User user = factory.create("Paul", "password","gpa","degree","program","language","email");
//        userRepository.save(user);
//
//        LoginInputBoundary interactor = new LoginInteractor(userRepository, successPresenter);
//        interactor.execute(inputData);
//
//        // set up the data file
//
//
//    }
//}
