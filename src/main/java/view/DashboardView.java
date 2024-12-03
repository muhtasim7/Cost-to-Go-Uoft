package view;

import app.FlightUseCaseFactory;
import app.PropertyUseCaseFactory;
import entities.Property;
import entities.University;
import interface_adapters.universities.*;
import interface_adapters.universities.UniversitiesController;
import interface_adapters.universities.UniversitiesViewModel;
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
import interface_adapters.property.PropertyState;
import interface_adapters.property.PropertyViewModel;
import use_case_rosa.universities.UniversitiesUserDataAccessInterface;
import usecases.flight.FlightUserDataAccessInterface;
import usecases.itinerary.ItineraryDataAccessInterface;
import usecases.property.PropertyUserDataAccessInterface;
import view_rosa.UniversitiesView;

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
    private final UniversitiesController universitiesController;
    private final UniversitiesViewModel universitiesViewModel;
    private final LoggedInState loggedInState;
    private final UniversitiesUserDataAccessInterface universitiesUserDataAccessObject;

    public DashboardView(ViewManagerModel viewManagerModel, ItineraryController itineraryController,
                         ItineraryViewModel itineraryViewModel, ItineraryDataAccessInterface userDataAccessObject,
                         UniversitiesController universitiesController, UniversitiesViewModel universitiesViewModel,
                         LoggedInState loggedInState,
                         UniversitiesUserDataAccessInterface universitiesUserDataAccessObject,
                         PropertyUserDataAccessInterface airbnb,
                         PropertyViewModel propertyViewModel, PropertyState propertyState,
                         FlightUserDataAccessInterface flight, FlightViewModel flightViewModel,
                         FlightState flightState) {
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
        this.universitiesUserDataAccessObject = universitiesUserDataAccessObject;
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
            final UniversitiesView universitiesView = new UniversitiesView(universitiesController,
                    universitiesViewModel, universitiesUserDataAccessObject);
            final Container parent = this.getParent();
            if (parent instanceof JPanel) {
                final JPanel parentPanel = (JPanel) parent;
                final CardLayout layout = (CardLayout) parentPanel.getLayout();
                // Add UniversitiesView to the parent panel
                final String universitiesViewName = universitiesView.getViewName();
                parentPanel.add(universitiesView, universitiesViewName);

                // Switch to UniversitiesView
                layout.show(parentPanel, universitiesViewName);
            }

        });

        // Action listener for "Rent Search"
        rentSearchButton.addActionListener(event -> {
            itineraryViewModel.setSelectedUniversities(UniversitiesState.getInstance().getSelectedUniversityData());
            final String city = itineraryViewModel.getSelectedUniversities().getCity();

            if (city != null && !city.trim().isEmpty()) {
                // Dynamically create PropertyView
                final PropertyView propertyView = PropertyUseCaseFactory.create(viewManagerModel, propertyViewModel,
                        airbnb, city, propertyState);

                // Add PropertyView to the parent container
                final Container parent = this.getParent();
                if (parent instanceof JPanel) {
                    final JPanel parentPanel = (JPanel) parent;
                    final CardLayout layout = (CardLayout) parentPanel.getLayout();

                    // Add PropertyView dynamically (if not already added)
                    final String propertyViewName = "propertyView";
                    parentPanel.add(propertyView, propertyViewName);

                    // Switch to PropertyView
                    layout.show(parentPanel, propertyViewName);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "City is required for Rent Search.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        });

        itineraryButton.addActionListener(event -> {
            // ROSA
            itineraryViewModel.setSelectedUniversities(UniversitiesState.getInstance().getSelectedUniversityData());

            // Create and display the ItineraryView when the button is clicked
            final ItineraryView itineraryView = new ItineraryView(itineraryController, itineraryViewModel);
            final Container parent = this.getParent();
            final JPanel parentPanel = (JPanel) parent;
            final CardLayout layout = (CardLayout) parentPanel.getLayout();

            // Add PropertyView dynamically (if not already added)
            final String itineraryViewName = "itinerary view";
            parentPanel.add(itineraryView, itineraryViewName);

            // Switch to PropertyView
            layout.show(parentPanel, itineraryViewName);
        });

        flightSearchButton.addActionListener(event -> {
            itineraryViewModel.setSelectedUniversities(UniversitiesState.getInstance().getSelectedUniversityData());
            final String destination = itineraryViewModel.getSelectedUniversities().getCity();

            if (destination != null && !destination.trim().isEmpty()) {
                final FlightView flightView = FlightUseCaseFactory.create(viewManagerModel, flightViewModel, flight,
                        destination, flightState);

                final Container parent = this.getParent();
                if (parent instanceof JPanel) {
                    final JPanel parentPanel = (JPanel) parent;
                    final CardLayout layout = (CardLayout) parentPanel.getLayout();

                    final String flightViewName = "flightView";
                    parentPanel.add(flightView, flightViewName);
                    layout.show(parentPanel, flightViewName);
                }
                else {
                    JOptionPane.showMessageDialog(this, "City is required for Flight Search.",
                            "Error", JOptionPane.ERROR_MESSAGE);
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
