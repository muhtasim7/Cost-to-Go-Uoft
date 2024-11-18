package interface_adapters;

import entities.UniversityInfo;
import usecases.InfoExtractor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OverviewScreen {
    private JFrame frame;

    // Define fonts only once
    private final Font regularFont = new Font("Apple LiGothic", Font.PLAIN, 20);
    private final Font boldFont = new Font("Apple LiGothic", Font.BOLD, 30);

    public OverviewScreen() {
        frame = new JFrame("Study Abroad Itinerary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel universityPanel = createUniversityPanel();
        JPanel rentalPanel = createRentalPanel();
        JPanel flightPanel = createFlightPanel();
        JPanel totalPanel = createTotalCostPanel();

        mainPanel.add(universityPanel);
        mainPanel.add(rentalPanel);
        mainPanel.add(flightPanel);
        mainPanel.add(totalPanel);

        frame.add(new JScrollPane(mainPanel));
        frame.setVisible(true);
    }

    private JPanel createUniversityPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(new Color(190, 211, 115));

        JLabel titleLabel = new JLabel("University Details:");
        titleLabel.setFont(boldFont);
        panel.add(titleLabel);

        InfoExtractor extractor = new InfoExtractor();
        List<UniversityInfo> infoList = extractor.extractInfo();

        for (UniversityInfo info : infoList) {
            JLabel countryLabel = new JLabel("Country: " + info.getCountry());
            JLabel cityLabel = new JLabel("City: " + info.getCity());
            JLabel universityLabel = new JLabel("University: " + info.getUniversity());
            JLabel languageLabel = new JLabel("Language: " + info.getLanguage());
            JLabel requirementsLabel = new JLabel("Requirements: " + info.getRequirements());

            countryLabel.setFont(regularFont);
            cityLabel.setFont(regularFont);
            universityLabel.setFont(regularFont);
            languageLabel.setFont(regularFont);
            requirementsLabel.setFont(regularFont);

            panel.add(countryLabel);
            panel.add(cityLabel);
            panel.add(universityLabel);
            panel.add(languageLabel);
            panel.add(requirementsLabel);
        }

        return panel;
    }
//in view
    private JPanel createRentalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(new Color(159, 224, 229));

        JLabel titleLabel = new JLabel("Hotel Details:");
        titleLabel.setFont(boldFont);
        panel.add(titleLabel);

        InfoExtractor extractor = new InfoExtractor();
        List<UniversityInfo> infoList = extractor.extractInfo();

        for (UniversityInfo info : infoList) {
            JLabel listingLabel = new JLabel("Listing Name: " + info.getListingName());
            JLabel discountedPriceLabel = new JLabel("Discounted Price: $" + info.getDiscountedPrice());
            JLabel originalPriceLabel = new JLabel("Original Price: $" + info.getOriginalPrice());
            JLabel starRatingLabel = new JLabel("Star Rating: " + info.getStarRating());
            JLabel roomTypeLabel = new JLabel("Room Type: " + info.getRoomType());

            listingLabel.setFont(regularFont);
            discountedPriceLabel.setFont(regularFont);
            originalPriceLabel.setFont(regularFont);
            starRatingLabel.setFont(regularFont);
            roomTypeLabel.setFont(regularFont);

            panel.add(listingLabel);
            panel.add(discountedPriceLabel);
            panel.add(originalPriceLabel);
            panel.add(starRatingLabel);
            panel.add(roomTypeLabel);
        }

        return panel;
    }
//in view
    private JPanel createFlightPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(new Color(235, 194, 235));

        JLabel titleLabel = new JLabel("Flight Details:");
        titleLabel.setFont(boldFont);
        panel.add(titleLabel);

        InfoExtractor extractor = new InfoExtractor();
        List<UniversityInfo> infoList = extractor.extractInfo();

        for (UniversityInfo info : infoList) {
            JLabel originLabel = new JLabel("Origin: Toronto International Airport");
            JLabel destinationLabel = new JLabel("Destination: " + info.getDestination());
            JLabel fareLabel = new JLabel("Fare: $" + info.getFare());
            JLabel durationLabel = new JLabel("Duration: " + info.getDuration());
            JLabel dateLabel = new JLabel("Date: " + info.getDate());

            originLabel.setFont(regularFont);
            destinationLabel.setFont(regularFont);
            fareLabel.setFont(regularFont);
            durationLabel.setFont(regularFont);
            dateLabel.setFont(regularFont);

            panel.add(originLabel);
            panel.add(destinationLabel);
            panel.add(fareLabel);
            panel.add(durationLabel);
            panel.add(dateLabel);
        }

        return panel;
    }

    //in view
    private JPanel createTotalCostPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setBackground(new Color(255, 191, 71));

        InfoExtractor extractor = new InfoExtractor();
        List<UniversityInfo> infoList = extractor.extractInfo();

        double totalCost = infoList.stream()
                .mapToDouble(UniversityInfo::calculateTotalCost)
                .sum();

        JLabel totalCostLabel = new JLabel("Total Cost: $" + String.format("%.2f", totalCost));
        totalCostLabel.setFont(boldFont);
        panel.add(totalCostLabel);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OverviewScreen::new);
    }
}

