package view;

import interface_adapters.ViewManagerModel;
import interface_adapters.itinerary.ItineraryController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DashboardView extends JPanel implements ActionListener, PropertyChangeListener{
    private final JButton updateInfoButton;
    private final JButton findProgramButton;
    private final JButton rentSearchButton;
    private final ViewManagerModel viewManagerModel;
    private final JButton itineraryButton;
    private final ItineraryController itineraryController;

    public DashboardView(ViewManagerModel viewManagerModel, ItineraryController itineraryController) {
        this.viewManagerModel = viewManagerModel;
        this.itineraryController = itineraryController;
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

        //Action listener for "Rent Search"
        rentSearchButton.addActionListener(e -> {
            viewManagerModel.setState("propertyView");
            viewManagerModel.firePropertyChanged();
        });
        itineraryButton.addActionListener(e -> {
                viewManagerModel.setState("itinerary view");
        viewManagerModel.firePropertyChanged();
            System.out.println("overview button clicked");
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

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
