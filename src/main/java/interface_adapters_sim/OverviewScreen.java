package interface_adapters;

import javax.swing.*;
import java.awt.*;

public class OverviewScreen extends JFrame {

    public OverviewScreen() {
        setTitle("Study Abroad Overview");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Initialize university panel
        JPanel universityPanel = createUniversityPanel();
        JPanel rentalPanel = createRentalPanel();
        JPanel flightPanel = createFlightPanel();
        JPanel totalPanel = createTotalPanel();

        // Add sub-panels to main panel
        mainPanel.add(universityPanel);
        mainPanel.add(rentalPanel);
        mainPanel.add(flightPanel);
        mainPanel.add(totalPanel);


        add(new JScrollPane(mainPanel));
    }

    Font regularFont = new Font("Apple LiGothic", Font.PLAIN, 20);
    Font boldFont = new Font("Apple LiGothic", Font.BOLD, 30);

    private JPanel createUniversityPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1)); // Adjusted layout for less space
        panel.setBackground(new Color(190, 211, 115));
        JLabel universityLabel = new JLabel("University Details:");
        universityLabel.setFont(boldFont);

        JLabel countryLabel = new JLabel("Country:");
        countryLabel.setFont(regularFont);

        JLabel cityLabel = new JLabel("City:");
        cityLabel.setFont(regularFont);

        JLabel uniLabel = new JLabel("University:");
        uniLabel.setFont(regularFont);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(regularFont);

        JLabel languageLabel = new JLabel("Language:");
        languageLabel.setFont(regularFont);

        JLabel tuitionLabel = new JLabel("Tuition:");
        tuitionLabel.setFont(regularFont);

        JLabel requirementsLabel = new JLabel("Requirements:");
        requirementsLabel.setFont(regularFont);

        panel.add(universityLabel);
        panel.add(countryLabel);
        panel.add(cityLabel);
        panel.add(uniLabel);
        panel.add(nameLabel);
        panel.add(languageLabel);
        panel.add(tuitionLabel);
        panel.add(requirementsLabel);

        return panel;
    }

    private JPanel createRentalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1)); // Adjusted layout for less space
        panel.setBackground(new Color(159, 224, 229));
        JLabel hotelLabel = new JLabel("Hotel Details:");
        hotelLabel.setFont(boldFont);

        JLabel listingNameLabel = new JLabel("Listing Name:");
        listingNameLabel.setFont(regularFont);

        JLabel discountedPriceLabel = new JLabel("Discounted Price:");
        discountedPriceLabel.setFont(regularFont);

        JLabel originalPriceLabel = new JLabel("Original Price:");
        originalPriceLabel.setFont(regularFont);

        JLabel starRatingLabel = new JLabel("Star Rating:");
        starRatingLabel.setFont(regularFont);

        JLabel roomTypeLabel = new JLabel("Room Type:");
        roomTypeLabel.setFont(regularFont);

        panel.add(hotelLabel);
        panel.add(listingNameLabel);
        panel.add(discountedPriceLabel);
        panel.add(originalPriceLabel);
        panel.add(starRatingLabel);
        panel.add(roomTypeLabel);

        return panel;
    }

    private JPanel createFlightPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1)); // Adjusted layout for less space

        JLabel flightLabel = new JLabel("Flight Details:");
        flightLabel.setFont(boldFont);
        panel.setBackground(new Color(235, 194, 235));

        JLabel flightNumberLabel = new JLabel("Flight Number:");
        flightNumberLabel.setFont(regularFont);

        JLabel durationLabel = new JLabel("Duration:");
        durationLabel.setFont(regularFont);

        JLabel lengthLabel = new JLabel("Length:");
        lengthLabel.setFont(regularFont);

        JLabel layoversLabel = new JLabel("Layovers:");
        layoversLabel.setFont(regularFont);

        JLabel flightTimeLabel = new JLabel("When the flight is:");
        flightTimeLabel.setFont(regularFont);

        panel.add(flightLabel);
        panel.add(flightNumberLabel);
        panel.add(durationLabel);
        panel.add(lengthLabel);
        panel.add(layoversLabel);
        panel.add(flightTimeLabel);

        return panel;
    }

    private JPanel createTotalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1)); // Adjusted layout for less space

        JLabel costLabel = new JLabel("Total Cost:");
        costLabel.setFont(boldFont);
        panel.setBackground(new Color(255, 191, 71));

        panel.add(costLabel);
        return panel;
    }

    public static void main(String[] args) {
        OverviewScreen screen = new OverviewScreen();
        screen.setVisible(true);
    }
}