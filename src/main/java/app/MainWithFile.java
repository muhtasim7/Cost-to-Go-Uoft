package app;

import data_access.FLIGHT;
import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import app_rosa.UniversitiesUseCaseFactory;
import data_access.FileUserDataAccessObject;
import data_access.AIRBNB;
import entities.CommonFlightFactory;
import data_access_rosa.FileUniversitiesDataAccessObject;
import entities.CommonPropertyFactory;
import entities.CommonUserFactory;
import entities.User;
import interface_adapter_rosa.universities.UniversitiesViewModel;
import interface_adapters.ViewManagerModel;
import interface_adapters.flight.FlightState;
import interface_adapters.flight.FlightViewModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryPresenter;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.logged_in.LoggedInState;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginViewModel;
import interface_adapters.property.PropertyState;
import interface_adapters.property.PropertyViewModel;
import interface_adapters.signup.SignupViewModel;
import usecases.flight.FlightUserDataAccessInterface;
import view.DashboardView;
import view.LoggedInView;
import view.LoginView;
import view.SignupView;
import view.ViewManager;
import use_case_rosa.universities.UniversitiesDataAccessInterface;
import use_case_rosa.universities.UniversitiesUserDataAccessInterface; // Import added
import usecases.itinerary.ItineraryInputBoundary;
import usecases.itinerary.ItineraryInteractor;
import usecases.itinerary.ItineraryOutputBoundary;
import usecases.property.PropertyUserDataAccessInterface;
import view.*;
import view_rosa.UniversitiesView;


/**
 * The version of Main with an external database used to persist user data.
 */
public class MainWithFile {

    /**
     * The main method for starting the program with an external database used to persist user data.
     * @param args input to main
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static void main(String[] args) throws IOException {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        final JFrame application = new JFrame("Cost-to-Go UofT");
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
        final PropertyState propertyState = new PropertyState();
        final FlightViewModel flightViewModel = new FlightViewModel();
        final FlightState flightState = new FlightState();
        final ItineraryViewModel itineraryViewModel = new ItineraryViewModel(propertyState);

        final FileUserDataAccessObject userDataAccessObject = new FileUserDataAccessObject("/Users/sanyuktanegi/IdeaProjects/Cost-to-Go-Uoft/Data/users.csv", new CommonUserFactory());
        final AIRBNB airbnb = new AIRBNB(new CommonPropertyFactory());
        final FLIGHT flight = new FLIGHT(new CommonFlightFactory());
        // rosa
        final UniversitiesViewModel universitiesViewModel = new UniversitiesViewModel();
        final UniversitiesDataAccessInterface universitiesData = new FileUniversitiesDataAccessObject();
        final UniversitiesUserDataAccessInterface universitiesUserDataAccessObject = userDataAccessObject;

//
//        final PropertyView propertyView = PropertyUseCaseFactory.create(viewManagerModel, propertyViewModel, airbnb,
//                "Toronto", propertyState);
//        views.add(propertyView, "propertyView");


//comment out flgiht stuff
//        final FlightView flightView = FlightUseCaseFactory.create(viewManagerModel, flightViewModel, flight_flight, "Vancouver", flightState);
//        views.add(flightView, "flightView");

        final SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel,
                signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.getViewName());

        final DashboardView dashboardView = DashboardViewUseCaseFactory.create(viewManagerModel, itineraryViewModel,
                userDataAccessObject, airbnb, propertyViewModel, propertyState, flight, flightViewModel, flightState,
                universitiesViewModel, universitiesData, universitiesUserDataAccessObject);
        views.add(dashboardView, dashboardView.getViewName());

        final LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel,
                loggedInViewModel, userDataAccessObject, signupViewModel);
        views.add(loginView, loginView.getViewName());

        final LoggedInView loggedInView = ChangePasswordUseCaseFactory.create(viewManagerModel,
                loggedInViewModel, userDataAccessObject);
        views.add(loggedInView, loggedInView.getViewName());
//
//        final ItineraryView itineraryView = ItineraryUseCaseFactory.create(viewManagerModel,itineraryViewModel,
//                userDataAccessObject);
//        views.add(itineraryView, itineraryView.getViewName());

        // Set the initial view to be the signup view (this is the view that's visible when the application starts)
        viewManagerModel.setState(signupView.getViewName());
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
