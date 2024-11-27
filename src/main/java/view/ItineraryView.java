package view;

import entities.Property;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryViewModel; // Updated to use the correct ViewModel
import interface_adapters.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ItineraryView extends JPanel implements PropertyChangeListener {
    private final String viewName = "itinerary view";
    private final JPanel propertiesPanel = new JPanel();
    private final ItineraryController itineraryController;
    private final ItineraryViewModel viewModel;  // Updated to use the correct ViewModel type

    // Fonts for the labels
    private final Font regularFont = new Font("Apple LiGothic", Font.PLAIN, 20);
    private final Font boldFont = new Font("Apple LiGothic", Font.BOLD, 30);

    public ItineraryView(ItineraryController itineraryController, ItineraryViewModel viewModel) {
        this.itineraryController = itineraryController;
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);  // Listen to property changes
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Your Itinerary");
        title.setFont(boldFont);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        propertiesPanel.setLayout(new BoxLayout(propertiesPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(propertiesPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Display initial labels (placeholders)
        updateItinerary();
    }

    private JPanel createPropertyPanel(Property property) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(new Color(159, 224, 229)); // Original blue color

        JLabel hotelLabel = new JLabel("Hotel Details:");
        hotelLabel.setFont(boldFont);

        JLabel listingNameLabel = new JLabel("Listing Name: ");
        listingNameLabel.setFont(boldFont);
        JLabel listingNameDetail = new JLabel(property != null ? property.getName() : "N/A");
        listingNameDetail.setFont(regularFont);

        JLabel discountedPriceLabel = new JLabel("Discounted Price: ");
        discountedPriceLabel.setFont(boldFont);
        JLabel discountedPriceDetail = new JLabel(property != null ? property.getDiscountedPrice() : "N/A");
        discountedPriceDetail.setFont(regularFont);

        JLabel originalPriceLabel = new JLabel("Original Price: ");
        originalPriceLabel.setFont(boldFont);
        JLabel originalPriceDetail = new JLabel(property != null ? property.getOriginalPrice() : "N/A");
        originalPriceDetail.setFont(regularFont);

        JLabel starRatingLabel = new JLabel("Star Rating: ");
        starRatingLabel.setFont(boldFont);
        JLabel starRatingDetail = new JLabel(property != null ? property.getRating() : "N/A");
        starRatingDetail.setFont(regularFont);

        JLabel roomTypeLabel = new JLabel("Room Type: ");
        roomTypeLabel.setFont(boldFont);
        JLabel roomTypeDetail = new JLabel(property != null ? property.getRoomType() : "N/A");
        roomTypeDetail.setFont(regularFont);

        // Add labels to the panel
        panel.add(hotelLabel);
        panel.add(listingNameLabel);
        panel.add(listingNameDetail);
        panel.add(discountedPriceLabel);
        panel.add(discountedPriceDetail);
        panel.add(originalPriceLabel);
        panel.add(originalPriceDetail);
        panel.add(starRatingLabel);
        panel.add(starRatingDetail);
        panel.add(roomTypeLabel);
        panel.add(roomTypeDetail);

        return panel;
    }

    private void updateItinerary() {
        propertiesPanel.removeAll(); // Clear previous panels

        List<Property> itinerary = viewModel.getState().getProperties();
        if (itinerary.isEmpty()) {
            // If there are no properties, show placeholder labels
            propertiesPanel.add(createPropertyPanel(null));
        } else {
            // Otherwise, display the properties
            for (Property property : itinerary) {
                propertiesPanel.add(createPropertyPanel(property));
            }
        }

        propertiesPanel.revalidate();
        propertiesPanel.repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            updateItinerary();
        }
    }

    public String getViewName() {
        return "itinerary view";
    }
}





















