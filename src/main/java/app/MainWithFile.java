package app;

import data_access.FileUserDataAccessObject;
import data_access.AIRBNB;
import entities.CommonPropertyFactory;
import entities.CommonUserFactory;
import interface_adapters.ViewManagerModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryPresenter;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginViewModel;
import interface_adapters.property.PropertyState;
import interface_adapters.property.PropertyViewModel;
import interface_adapters.signup.SignupViewModel;
import usecases.itinerary.ItineraryInputBoundary;
import usecases.itinerary.ItineraryInteractor;
import usecases.itinerary.ItineraryOutputBoundary;
import usecases.property.PropertyUserDataAccessInterface;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * The version of Main with an external database used to persist user data.
 */
public class MainWithFile {

    /**
     * The main method for starting the program with an external database used to persist user data.
     * @param args input to main
     */
    public static void main(String[] args) throws IOException {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        final JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        final JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        final ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are "observable", and will
        // be "observed" by the Views.
        final LoginViewModel loginViewModel = new LoginViewModel();
        final LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        final SignupViewModel signupViewModel = new SignupViewModel();
        final PropertyViewModel propertyViewModel = new PropertyViewModel();
        final ItineraryViewModel itineraryViewModel = new ItineraryViewModel();  // This is your itinerary model
        // TODO Task 1.1 in a copy of this file, change this line to use the in-memory DAO.
        final FileUserDataAccessObject userDataAccessObject = new FileUserDataAccessObject("./Data/users.csv", new CommonUserFactory());
        final AIRBNB airbnb = new AIRBNB(new CommonPropertyFactory());


        final PropertyView propertyView = PropertyUseCaseFactory.create(viewManagerModel, propertyViewModel, airbnb, "Toronto");
        views.add(propertyView, "propertyView");

        final SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.getViewName());

        final DashboardView dashboardView = DashboardViewUseCaseFactory.create(viewManagerModel, itineraryViewModel, userDataAccessObject);
        views.add(dashboardView, dashboardView.getViewName());

        final LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel,
                loggedInViewModel, userDataAccessObject);
        views.add(loginView, loginView.getViewName());

        final LoggedInView loggedInView = ChangePasswordUseCaseFactory.create(viewManagerModel,
                loggedInViewModel, userDataAccessObject);
        views.add(loggedInView, loggedInView.getViewName());

        final ItineraryView itineraryView = ItineraryUseCaseFactory.create(viewManagerModel,itineraryViewModel,userDataAccessObject);
        views.add(itineraryView, itineraryView.getViewName());

        // Set the initial view to be the signup view (this is the view that's visible when the application starts)
        viewManagerModel.setState(signupView.getViewName());
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}

