//package view;
//
//import interface_adapters.OverviewController;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class OverviewScreen extends JFrame {
//    private final OverviewController controller;
//
//    // Fonts for the labels
//    private final Font regularFont = new Font("Apple LiGothic", Font.PLAIN, 20);
//    private final Font boldFont = new Font("Apple LiGothic", Font.BOLD, 30);
//
//    // Constructor
//    public OverviewScreen(OverviewController controller) {
//        this.controller = controller;
//
//        setTitle("Study Abroad Itinerary");
//        setSize(600, 800);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        // Fetch data from the controller
//        controller.fetchOverviewData();
//
//        // Main panel with sub-panels
//        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//
//        // Initialize the sub-panels
//        JPanel universityPanel = createUniversityPanel();
//        JPanel rentalPanel = createRentalPanel();
//        JPanel flightPanel = createFlightPanel();
//        JPanel totalPanel = createTotalPanel();
//
//        // Add sub-panels to the main panel
//        mainPanel.add(universityPanel);
//        mainPanel.add(rentalPanel);
//        mainPanel.add(flightPanel);
//        mainPanel.add(totalPanel);
//
//        add(new JScrollPane(mainPanel)); // Add a scroll pane for better usability
//    }
//
//    // Creates the panel with the university information
//    private JPanel createUniversityPanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(8, 1));
//        panel.setBackground(new Color(190, 211, 115)); // Original green color
//        JLabel universityLabel = new JLabel("University Details:");
//        universityLabel.setFont(boldFont);
//
//        JLabel countryLabel = new JLabel("Country: " + controller.getCountry());
//        JLabel cityLabel = new JLabel("City: " + controller.getCity());
//        JLabel uniLabel = new JLabel("University: " + controller.getUniversity());
//        JLabel languageLabel = new JLabel("Language: " + controller.getLanguage());
//        JLabel tuitionLabel = new JLabel("Tuition: " + controller.getTuition());
//        JLabel requirementsLabel = new JLabel("Requirements: " + controller.getRequirements());
//
//        // Set fonts
//        countryLabel.setFont(regularFont);
//        cityLabel.setFont(regularFont);
//        uniLabel.setFont(regularFont);
//        languageLabel.setFont(regularFont);
//        tuitionLabel.setFont(regularFont);
//        requirementsLabel.setFont(regularFont);
//
//        // Add labels to the panel
//        panel.add(universityLabel);
//        panel.add(countryLabel);
//        panel.add(cityLabel);
//        panel.add(uniLabel);
//        panel.add(languageLabel);
//        panel.add(tuitionLabel);
//        panel.add(requirementsLabel);
//
//        return panel;
//    }
//
//    // Creates the panel with the rental information
//    private JPanel createRentalPanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(6, 1));
//        panel.setBackground(new Color(159, 224, 229)); // Original blue color
//        JLabel hotelLabel = new JLabel("Hotel Details:");
//        hotelLabel.setFont(boldFont);
//
//        JLabel listingNameLabel = new JLabel("Listing Name: " + controller.getListingName());
//        JLabel discountedPriceLabel = new JLabel("Discounted Price: " + controller.getDiscountedPrice());
//        JLabel originalPriceLabel = new JLabel("Original Price: " + controller.getOriginalPrice());
//        JLabel starRatingLabel = new JLabel("Star Rating: " + controller.getStarRating());
//        JLabel roomTypeLabel = new JLabel("Room Type: " + controller.getRoomType());
//
//        // Set fonts
//        listingNameLabel.setFont(regularFont);
//        discountedPriceLabel.setFont(regularFont);
//        originalPriceLabel.setFont(regularFont);
//        starRatingLabel.setFont(regularFont);
//        roomTypeLabel.setFont(regularFont);
//
//        // Add labels to the panel
//        panel.add(hotelLabel);
//        panel.add(listingNameLabel);
//        panel.add(discountedPriceLabel);
//        panel.add(originalPriceLabel);
//        panel.add(starRatingLabel);
//        panel.add(roomTypeLabel);
//
//        return panel;
//    }
//
//    // Creates the panel with the flight information
//    private JPanel createFlightPanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(6, 1));
//        panel.setBackground(new Color(235, 194, 235)); // Original purple color
//        JLabel flightLabel = new JLabel("Flight Details:");
//        flightLabel.setFont(boldFont);
//
//        JLabel originLabel = new JLabel("Origin: Toronto International Airport");
//        JLabel destinationLabel = new JLabel("Destination: " + controller.getDestination());
//        JLabel priceLabel = new JLabel("Price: " + controller.getFare());
//        JLabel durationLabel = new JLabel("Duration: " + controller.getDuration());
//        JLabel dateLabel = new JLabel("Date: " + controller.getDate());
//
//        // Set fonts
//        originLabel.setFont(regularFont);
//        destinationLabel.setFont(regularFont);
//        priceLabel.setFont(regularFont);
//        durationLabel.setFont(regularFont);
//        dateLabel.setFont(regularFont);
//
//        // Add labels to the panel
//        panel.add(flightLabel);
//        panel.add(originLabel);
//        panel.add(destinationLabel);
//        panel.add(priceLabel);
//        panel.add(durationLabel);
//        panel.add(dateLabel);
//
//        return panel;
//    }
//
//    // Creates the panel that displays the total cost
//    private JPanel createTotalPanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(1, 1));
//        panel.setBackground(new Color(255, 191, 71)); // Original orange color
//
//        JLabel totalCostLabel = new JLabel("Total Cost: " + controller.getTotalCost());
//        totalCostLabel.setFont(boldFont);
//
//        panel.add(totalCostLabel);
//        return panel;
//    }
//}
//
//
