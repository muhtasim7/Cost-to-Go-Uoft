package view;

import interface_adapters.ViewManagerModel;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.property.PropertySelectedCallback;
import interface_adapters.property.PropertyState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DashboardView extends JPanel implements ActionListener, PropertyChangeListener {
    private final JButton updateInfoButton;
    private final JButton findProgramButton;
    private final JButton rentSearchButton;
    private final ViewManagerModel viewManagerModel;
    private final JButton itineraryButton;
    private final ItineraryController itineraryController;
    private final PropertyState state;
    private final PropertySelectedCallback callback;

    public DashboardView(ViewManagerModel viewManagerModel, ItineraryController itineraryController, PropertyState state, PropertySelectedCallback callback) {
        this.viewManagerModel = viewManagerModel;
        this.itineraryController = itineraryController;
        this.state = state;
        this.callback = callback;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Welcome to Your Dashboard");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        updateInfoButton = new JButton("Update Information");
        findProgramButton = new JButton("Find Program");
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
            viewManagerModel.setState("itinerary view");
            viewManagerModel.firePropertyChanged();
            System.out.println("Overview button clicked");
            System.out.println(state.getSelectedProperty());
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // handle action events if needed
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // handle property change events if needed
    }
}
