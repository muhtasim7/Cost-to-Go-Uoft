package interface_adapters;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverviewScreen extends JFrame {
    private static final String FILE_PATH = "/Users/alisa.isk/IdeaProjects/Cost-to-Go-Uoft/Data/mockdata.txt";
    public List<String> list = new ArrayList<>();
    public double totalCost = 0;
    public List<String> info() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Extracting country data
                if (line.contains("Country:")) {
                    String country = (line.substring(line.indexOf("Country:") + 8).replace("\"", "").trim());
                    list.add(country);
                }

                // Extracting city data
                if (line.contains("City:")) {
                    String city = (line.substring(line.indexOf("City:") + 6).replace("\"", "").trim());
                    list.add(city);
                }

                // Extracting university data
                if (line.contains("University:")) {
                    String university = (line.substring(line.indexOf("University:") + 12).replace("\"", "").trim());
                    list.add(university);
                }

                // Extracting language data
                if (line.contains("Langauge:")) {
                    String language = (line.substring(line.indexOf("Langauge:") + 9).replace("\"", "").trim());
                    list.add(language);
                }

                // Extracting tuition data
                if (line.contains("Tuition:")) {
                    String tuition = (line.substring(line.indexOf("Tuition:") + 8).replace("\"", "").trim());
                    list.add(tuition);
                }

                // Extracting requirements data
                if (line.contains("Requirements:")) {
                    String requirements = (line.substring(line.indexOf("Requirements:") + 13).replace("\"", "").trim());
                    list.add(requirements);
                }

                // Extracting listing name data
                if (line.contains("Listing Name:")) {
                    String listingName = (line.substring(line.indexOf("Listing Name:") + 13).replace("\"", "").trim());
                    list.add(listingName);
                }

                // Extracting discounted price data
                if (line.contains("Discounted Price:")) {
                    String discountedPrice = (line.substring(line.indexOf("Discounted Price:") + 17).replace("\"", "").trim());
                    totalCost += Double.parseDouble(discountedPrice);
                    list.add(discountedPrice);
                }

                // Extracting original price data
                if (line.contains("Original Price:")) {
                    String originalPrice = (line.substring(line.indexOf("Original Price:") + 15).replace("\"", "").trim());
                    list.add(originalPrice);
                }

                // Extracting star rating data
                if (line.contains("Star Rating:")) {
                    String starRating = (line.substring(line.indexOf("Star Rating:") + 12).replace("\"", "").trim());
                    list.add(starRating);
                }

                // Extracting room type data
                if (line.contains("Bedroom Type:")) {
                    String roomType = (line.substring(line.indexOf("Bedroom Type:") + 13).replace("\"", "").trim());
                    list.add(roomType);
                }

                // Extracting destination data
                if (line.contains("Destination:")) {
                    String destination = (line.substring(line.indexOf("Destination:") + 12).replace("\"", "").trim());
                    list.add(destination);
                }

                // Extracting duration data
                if (line.contains("Duration:")) {
                    String duration = (line.substring(line.indexOf("Duration:") + 9).replace("\"", "").trim());
                    list.add(duration);
                }

                // Extracting flight price/fare data
                if (line.contains("Fare:")) {
                    String fare = (line.substring(line.indexOf("Fare:") + 6).replace("\"", "").trim());
                    totalCost += Double.parseDouble(fare);
                    list.add(fare);
                }

                // Extracting flight date data
                if (line.contains("Date:")) {
                    String date = (line.substring(line.indexOf("Date:") + 6).replace("\"", "").trim());
                    list.add(date);
                }
            }
        } catch (IOException e) {
            return Collections.emptyList();
        }
        return list;
    }

    private final List <String> data = info();
    // Labels for university information
    private final JLabel countryLabel = new JLabel("Country: " + data.get(0));
    private final JLabel cityLabel = new JLabel("City: " + data.get(1));
    private final JLabel uniLabel = new JLabel("University: " + data.get(2));
    private final JLabel languageLabel = new JLabel("Language: " + data.get(3));
    private final JLabel tuitionLabel = new JLabel("Tuition: " + data.get(4));
    private final JLabel requirementsLabel = new JLabel("Requirements: " + data.get(5));

    // Labels for rental information
    private final JLabel listingNameLabel = new JLabel("Listing Name: " + data.get(6));
    private final JLabel discountedPriceLabel = new JLabel("Discounted Price: " + data.get(7));
    private final JLabel originalPriceLabel = new JLabel("Original Price: " + data.get(8));
    private final JLabel starRatingLabel = new JLabel("Star Rating: " + data.get(9));
    private final JLabel roomTypeLabel = new JLabel("Room Type: " + data.get(10));

    // Labels for flight information
    private final JLabel originLabel = new JLabel("Origin: Toronto International Airport");
    private final JLabel destinationLabel = new JLabel("Destination: " + data.get(11));
    private final JLabel priceLabel = new JLabel("Price: " + data.get(12));
    private final JLabel durationLabel = new JLabel("Duration: " + data.get(13));
    private final JLabel dateLabel = new JLabel("Date: " + data.get(14));

    // Label for total cost
    private final JLabel totalCostLabel = new JLabel("Total Cost: " + totalCost);

    // Fonts for the labels
    private final Font regularFont = new Font("Apple LiGothic", Font.PLAIN, 20);
    private final Font boldFont = new Font("Apple LiGothic", Font.BOLD, 30);

    // Constructor
    public OverviewScreen() {
        setTitle("Study Abroad Itinerary");
        setSize(600, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

    // Creates the panel with the university information
    private JPanel createUniversityPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));
        panel.setBackground(new Color(190, 211, 115));
        JLabel universityLabel = new JLabel("University Details:");
        universityLabel.setFont(boldFont);

        countryLabel.setFont(regularFont);
        cityLabel.setFont(regularFont);
        uniLabel.setFont(regularFont);
        languageLabel.setFont(regularFont);
        tuitionLabel.setFont(regularFont);
        requirementsLabel.setFont(regularFont);

        panel.add(universityLabel);
        panel.add(countryLabel);
        panel.add(cityLabel);
        panel.add(uniLabel);
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

        listingNameLabel.setFont(regularFont);
        discountedPriceLabel.setFont(regularFont);
        originalPriceLabel.setFont(regularFont);
        starRatingLabel.setFont(regularFont);
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
        panel.setLayout(new GridLayout(6, 1));

        JLabel flightLabel = new JLabel("Flight Details:");
        flightLabel.setFont(boldFont);
        panel.setBackground(new Color(235, 194, 235));

        originLabel.setFont(regularFont);
        destinationLabel.setFont(regularFont);
        priceLabel.setFont(regularFont);
        durationLabel.setFont(regularFont);
        dateLabel.setFont(regularFont);

        panel.add(flightLabel);
        panel.add(originLabel);
        panel.add(destinationLabel);
        panel.add(priceLabel);
        panel.add(durationLabel);
        panel.add(dateLabel);

        return panel;
    }

    // Creates the panel that displays the total cost
    private JPanel createTotalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));

        totalCostLabel.setFont(boldFont);
        panel.setBackground(new Color(255, 191, 71));

        panel.add(totalCostLabel);
        return panel;
    }

    public static void main(String[] args) {
        OverviewScreen screen = new OverviewScreen();
        screen.setVisible(true);
    }
}

