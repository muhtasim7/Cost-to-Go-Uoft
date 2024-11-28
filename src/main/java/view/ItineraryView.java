package view;

import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.property.PropertyState;
import usecases.itinerary.ItineraryOutputData;
import entities.Property;


import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ItineraryView extends JPanel implements PropertyChangeListener {
    private final JPanel propertiesPanel = new JPanel();
    private final ItineraryController itineraryController;
    private final ItineraryViewModel viewModel;

    private final Font regularFont = new Font("Apple LiGothic", Font.PLAIN, 20);
    private final Font boldFont = new Font("Apple LiGothic", Font.BOLD, 30);

    public ItineraryView(ItineraryController itineraryController, ItineraryViewModel viewModel) {
        this.itineraryController = itineraryController;
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(new Color(255,191,71));

        JLabel titleLabel = new JLabel("Your Itinerary");
        titleLabel.setFont(boldFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        propertiesPanel.setLayout(new BoxLayout(propertiesPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(propertiesPanel);
        add(scrollPane, BorderLayout.CENTER);

                updateItinerary();
    }

    private JPanel createPropertyPanel(Property property) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(new Color(159, 224, 229));


        JLabel rentalLabel = new JLabel("Rental Details:");
        rentalLabel.setFont(boldFont);

        JLabel listingNameDetail = new JLabel(property != null ? "Listing Name: " + property.getName() : "Listing Name: N/A");
        listingNameDetail.setFont(regularFont);

        JLabel discountedPriceDetail = new JLabel(property != null ? "Discounted Price: " + property.getDiscountedPrice() : "Discounted Price: N/A");
        discountedPriceDetail.setFont(regularFont);

        JLabel originalPriceDetail = new JLabel(property != null ? "Original Price: " + property.getOriginalPrice() : "Original Price: N/A");
        originalPriceDetail.setFont(regularFont);

        JLabel starRatingDetail = new JLabel(property != null ? "Rating: " + property.getRating() : "Rating: N/A");
        starRatingDetail.setFont(regularFont);

        JLabel roomTypeDetail = new JLabel(property != null ? "Room type: " + property.getRoomType() : "Room type: N/A");
        roomTypeDetail.setFont(regularFont);

        panel.add(rentalLabel);
        panel.add(listingNameDetail);
        panel.add(discountedPriceDetail);
        panel.add(originalPriceDetail);
        panel.add(starRatingDetail);
        panel.add(roomTypeDetail);

        return panel;
    }

    private void updateItinerary() {
        propertiesPanel.removeAll();

        // Get the selected property from the ItineraryViewModel
        Property selectedProperty = viewModel.getSelectedProperty();

        // Add a panel to show the property details if a property is selected
        if (selectedProperty != null) {
            propertiesPanel.add(createPropertyPanel(selectedProperty));
        } else {
            propertiesPanel.add(createPropertyPanel(null));  // No property selected
        }

        // Refresh the UI to show the updated property
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






















