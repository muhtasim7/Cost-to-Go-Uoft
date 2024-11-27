package app_rosa;

import interface_adapter_rosa.universities.UniversitiesViewModel;
import view_rosa.UniversitiesView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class AppBuilder {

    public void buildAndShowUI() {
        // Sample mock data for testing
        List<Object[]> data = List.of(
                new Object[]{"Country A", "City A", "University A", "French", "Paid to uni", "Award: whatever", "3.0"},
                new Object[]{"Country A", "City A", "University A", "French", "Paid to uni", "Award: whatever", "3.0"},
                new Object[]{"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[]{"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"}
        );

        // Create a UniversitiesViewModel instance
        UniversitiesViewModel viewModel = new UniversitiesViewModel();

        // Create the view (UI) and pass the viewModel
        UniversitiesView view = new UniversitiesView(viewModel);

        // Pass mock data to the table
        view.createTable(data);

        // Create and set up the JFrame to test the view
        JFrame frame = new JFrame("Study Abroad Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AppBuilder builder = new AppBuilder();
        builder.buildAndShowUI();  // Initialize the UI and show it
    }
}
