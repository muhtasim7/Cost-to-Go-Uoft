package interface_adapters;

import javax.swing.*;
import java.awt.*;

public class OverviewScreen extends JFrame {
    // The code to put the overview screen together
    public OverviewScreen() {
        setTitle("Study Abroad Itinerary");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Initialize the sub-panels
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

    // Fonts for the labels
    Font regularFont = new Font("Apple LiGothic", Font.PLAIN, 20);
    Font boldFont = new Font("Apple LiGothic", Font.BOLD, 30);

    // Creates the panel with the university information
    private JPanel createUniversityPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));
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
    // Creates the panel with the rental information
    private JPanel createRentalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
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
    // Creates the panel with the flight information
    private JPanel createFlightPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JLabel flightLabel = new JLabel("Flight Details:");
        flightLabel.setFont(boldFont);
        panel.setBackground(new Color(235, 194, 235));

        JLabel originLabel = new JLabel("Origin: Toronto International Airport");
        originLabel.setFont(regularFont);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(regularFont);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(regularFont);

        JLabel durationLabel = new JLabel("Duration:");
        durationLabel.setFont(regularFont);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(regularFont);

        panel.add(flightLabel);
        panel.add(originLabel);
        panel.add(priceLabel);
        panel.add(durationLabel);
        panel.add(dateLabel);

        return panel;
    }
    // Creates the panel that displays the total cost
    private JPanel createTotalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));

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