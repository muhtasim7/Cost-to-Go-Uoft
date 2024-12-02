package view;

import app.FlightUseCaseFactory;
import app.PropertyUseCaseFactory;
import entities.Property;
import entity_rosa.University;
import interface_adapter_rosa.universities.*;
import interface_adapter_rosa.universities.UniversitiesController;
import interface_adapter_rosa.universities.UniversitiesViewModel;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapters.ViewManagerModel;
import interface_adapters.flight.FlightState;
import interface_adapters.flight.FlightViewModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.logged_in.LoggedInState;
import interface_adapters.property.PropertySelectedCallback;
import interface_adapters.property.PropertyState;
import interface_adapters.property.PropertyViewModel;
import usecases.flight.FlightUserDataAccessInterface;
import usecases.itinerary.ItineraryDataAccessInterface;
import usecases.property.PropertyUserDataAccessInterface;
import use_case_rosa.universities.UniversitiesUserDataAccessInterface; // rosa import added
import view_rosa.UniversitiesView;
import entity_rosa.University;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;

/**
 * The View for when the user is logged in and in the dashboard.
 */

public class DashboardView extends JPanel {
    private final JButton updateInfoButton;
    private final JButton findProgramButton;
    private final JButton rentSearchButton;
    private final ViewManagerModel viewManagerModel;
    private final JButton flightSearchButton;
    private final JButton itineraryButton;
    private final ItineraryController itineraryController;
    private final ItineraryViewModel itineraryViewModel;
    private final ItineraryDataAccessInterface userDataAccessObject;
    private final PropertyViewModel propertyViewModel;
    private final PropertyUserDataAccessInterface airbnb;
    private final PropertyState propertyState;
    private final FlightViewModel flightViewModel;
    private final FlightUserDataAccessInterface flight;
    private final FlightState flightState;
    private final UniversitiesController universitiesController; //rosa
    private final UniversitiesViewModel universitiesViewModel; //rosa
    private final LoggedInState loggedInState; //rosa
    private final UniversitiesUserDataAccessInterface universitiesUserDataAccessObject; // rosa

    public DashboardView(ViewManagerModel viewManagerModel, ItineraryController itineraryController, ItineraryViewModel itineraryViewModel, ItineraryDataAccessInterface userDataAccessObject,
                         UniversitiesController universitiesController, UniversitiesViewModel universitiesViewModel, LoggedInState loggedInState, UniversitiesUserDataAccessInterface universitiesUserDataAccessObject,
                         PropertyUserDataAccessInterface airbnb,
                         PropertyViewModel propertyViewModel, PropertyState propertyState, FlightUserDataAccessInterface flight, FlightViewModel flightViewModel, FlightState flightState) {
        this.viewManagerModel = viewManagerModel;
        this.itineraryController = itineraryController;
        this.itineraryViewModel = itineraryViewModel;
        this.userDataAccessObject = userDataAccessObject;
        this.airbnb = airbnb;
        this.propertyViewModel = propertyViewModel;
        this.propertyState = propertyState;
        this.flight = flight;
        this.flightViewModel = flightViewModel;
        this.flightState = flightState;
        // rosa
        this.universitiesController = universitiesController;
        this.universitiesViewModel = universitiesViewModel;
        this.loggedInState = loggedInState;
        this.universitiesUserDataAccessObject = universitiesUserDataAccessObject; // Initialize
        //
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel titleLabel = new JLabel("Welcome to Your Dashboard");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        updateInfoButton = new JButton("Update Information");
        findProgramButton = new JButton("Find University");
        rentSearchButton = new JButton("Rent Search");
        itineraryButton = new JButton("Itinerary");
        flightSearchButton = new JButton("Flight Search");

        // Action listener for "Update Information"
        updateInfoButton.addActionListener(event -> {
            // Navigate to the Change Password view (or another update view)
            viewManagerModel.setState("logged in");
            viewManagerModel.firePropertyChanged();
        });

        // Action listener for "Find Program"
        findProgramButton.addActionListener(event -> {
            // Navigate to the program search view or implement the search logic
//            viewManagerModel.setState("StudyAbroadOptions"); // rosa
//            viewManagerModel.firePropertyChanged(); // rosa
            // create and display the UniversitiesView when the button is called
            UniversitiesView universitiesView = new UniversitiesView(universitiesController, universitiesViewModel, universitiesUserDataAccessObject);
            Container parent = this.getParent();
            if (parent instanceof JPanel) {
                JPanel parentPanel = (JPanel) parent;
                CardLayout layout = (CardLayout) parentPanel.getLayout();
                // Add UniversitiesView to the parent panel
                String universitiesViewName = universitiesView.getViewName(); // Unique identifier for UniversitiesView
                parentPanel.add(universitiesView, universitiesViewName);

                // Switch to UniversitiesView
                layout.show(parentPanel, universitiesViewName);
            }

        });

        // Action listener for "Rent Search"
        rentSearchButton.addActionListener(e -> {
            String city = JOptionPane.showInputDialog(this, "Enter city for Airbnb search:", "Rent Search", QUESTION_MESSAGE);

            if (city != null && !city.trim().isEmpty()) {
                // Dynamically create PropertyView
                PropertyView propertyView = PropertyUseCaseFactory.create(viewManagerModel, propertyViewModel, airbnb, city, propertyState);

                // Add PropertyView to the parent container
                Container parent = this.getParent();
                if (parent instanceof JPanel) {
                    JPanel parentPanel = (JPanel) parent;
                    CardLayout layout = (CardLayout) parentPanel.getLayout();

                    // Add PropertyView dynamically (if not already added)
                    String propertyViewName = "propertyView"; // Unique identifier
                    parentPanel.add(propertyView, propertyViewName);

                    // Switch to PropertyView
                    layout.show(parentPanel, propertyViewName);
                }
            } else {
                JOptionPane.showMessageDialog(this, "City is required for Rent Search.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        });

        itineraryButton.addActionListener(e -> {
            // ROSA
            itineraryViewModel.setSelectedUniversities(UniversitiesState.getInstance().getSelectedUniversityData());
            System.out.println(itineraryViewModel.getSelectedUniversities().getCountry() + "in dashboard");

            // Create and display the ItineraryView when the button is clicked
            ItineraryView itineraryView = new ItineraryView(itineraryController, itineraryViewModel);
            JFrame itineraryFrame = new JFrame("Itinerary Overview");
            itineraryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            itineraryFrame.getContentPane().add(itineraryView);
            itineraryFrame.pack();
            itineraryFrame.setVisible(true);
        });

        flightSearchButton.addActionListener(e -> {
            String destination = JOptionPane.showInputDialog(this, "Enter city for flight search:", "Flight Search", QUESTION_MESSAGE);

            if (destination != null && !destination.trim().isEmpty()) {
                FlightView flightView = FlightUseCaseFactory.create(viewManagerModel, flightViewModel, flight, destination, flightState);

                Container parent = this.getParent();
                if (parent instanceof JPanel) {
                    JPanel parentPanel = (JPanel) parent;
                    CardLayout layout = (CardLayout) parentPanel.getLayout();

                    String FlightViewName = "flightView";
                    parentPanel.add(flightView, FlightViewName);
                    layout.show(parentPanel, FlightViewName);
                } else {
                    JOptionPane.showMessageDialog(this, "City is required for Flight Search.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        add(titleLabel);
        add(updateInfoButton);
        add(findProgramButton);
        add(flightSearchButton);
        add(rentSearchButton);
        add(itineraryButton);
    }

    public String getViewName() {
        return "dashboardView";
    }
}
