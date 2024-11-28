package view;

import interface_adapters.ViewManagerModel;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JPanel {
    private final JButton updateInfoButton;
    private final JButton findProgramButton;
    private final JButton rentSearchButton;
    private final ViewManagerModel viewManagerModel;
    private final JButton flightSearchButton;

    public DashboardView(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Welcome to Your Dashboard");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        updateInfoButton = new JButton("Update Information");
        findProgramButton = new JButton("Find Program");
        rentSearchButton = new JButton("Rent Search");
        flightSearchButton = new JButton("Flight Search");

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

        flightSearchButton.addActionListener(e -> {
            viewManagerModel.setState("flightView");
            viewManagerModel.firePropertyChanged();
        });


        add(titleLabel);
        add(updateInfoButton);
        add(findProgramButton);
        add(rentSearchButton);
        add(flightSearchButton);
    }

    public String getViewName() {
        return "dashboardView";
    }
}
