package view;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapters.ViewManagerModel;
/**
 * The View for when the user is logged in and in the dashboard.
 */

public class DashboardView extends JPanel {
    private final JButton updateInfoButton;
    private final JButton findProgramButton;
    private final ViewManagerModel viewManagerModel;

    public DashboardView(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel titleLabel = new JLabel("Welcome to Your Dashboard");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        updateInfoButton = new JButton("Update Information");
        findProgramButton = new JButton("Find Program");

        // Action listener for "Update Information"
        updateInfoButton.addActionListener(event -> {
            // Navigate to the Change Password view (or another update view)
            viewManagerModel.setState("logged in");
            viewManagerModel.firePropertyChanged();
        });

        // Action listener for "Find Program"
        findProgramButton.addActionListener(event -> {
            // Navigate to the program search view or implement the search logic
            System.out.println("Find Program button clicked");
        });

        add(titleLabel);
        add(updateInfoButton);
        add(findProgramButton);
    }

    public String getViewName() {
        return "dashboardView";
    }
}
