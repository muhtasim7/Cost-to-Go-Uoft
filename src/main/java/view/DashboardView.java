package view;

import entities.Property;
import interface_adapters.ViewManagerModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.property.PropertySelectedCallback;
import interface_adapters.property.PropertyState;
import usecases.itinerary.ItineraryDataAccessInterface;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DashboardView extends JPanel implements PropertyChangeListener {
    private final JButton updateInfoButton;
    private final JButton findProgramButton;
    private final JButton rentSearchButton;
    private final ViewManagerModel viewManagerModel;
    private final JButton itineraryButton;
    private final ItineraryController itineraryController;
    private final ItineraryViewModel itineraryViewModel;
    private final ItineraryDataAccessInterface userDataAccessObject;

    public DashboardView(ViewManagerModel viewManagerModel, ItineraryController itineraryController, ItineraryViewModel itineraryViewModel, ItineraryDataAccessInterface userDataAccessObject) {
        this.viewManagerModel = viewManagerModel;
        this.itineraryController = itineraryController;
        this.itineraryViewModel = itineraryViewModel;
        this.userDataAccessObject = userDataAccessObject;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Welcome to Your Dashboard");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        updateInfoButton = new JButton("Update Information");
        findProgramButton = new JButton("Find University");
        rentSearchButton = new JButton("Rent Search");
        itineraryButton = new JButton("Overview");

        // Action listener for "Update Information"
        updateInfoButton.addActionListener(e -> {
            // Navigate to the Change Password view (or another update view)
            viewManagerModel.setState("logged in");
            viewManagerModel.firePropertyChanged();
        });

        // Action listener for "Find Program"
        findProgramButton.addActionListener(e -> {
            // Navigate to the program search view or implement the search logic
            System.out.println("Find Program button clicked");
        });

        // Action listener for "Rent Search"
        rentSearchButton.addActionListener(e -> {
            viewManagerModel.setState("propertyView");
            viewManagerModel.firePropertyChanged();
        });

        itineraryButton.addActionListener(e -> {
            // Create and display the ItineraryView when the button is clicked
            ItineraryView itineraryView = new ItineraryView(itineraryController, itineraryViewModel);
            JFrame itineraryFrame = new JFrame("Itinerary Overview");
            itineraryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            itineraryFrame.getContentPane().add(itineraryView);
            itineraryFrame.pack();
            itineraryFrame.setVisible(true);
        });

        add(titleLabel);
        add(updateInfoButton);
        add(findProgramButton);
        add(rentSearchButton);
        add(itineraryButton);
    }

    public String getViewName() {
        return "dashboardView";
    }
}
