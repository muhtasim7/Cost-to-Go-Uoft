package view;

import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.property.PropertyState;
import entities.Property;
import usecases.itinerary.ItineraryOutputData;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ItineraryView extends JPanel implements PropertyChangeListener {
    private final JPanel propertiesPanel = new JPanel();
    private final ItineraryController itineraryController;
    private final ItineraryViewModel viewModel;
    private PropertyState propertyState = new PropertyState();

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

        updateItinerary(propertyState);
    }

    private JPanel createPropertyPanel(Property property) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(new Color(159, 224, 229));

        String name = property.getName() != null ? property.getName() : "N/A";
        String discountPrice = property.getDiscountedPrice() != null ? property.getDiscountedPrice() : "N/A";
        String originalPrice = property.getOriginalPrice() != null ? property.getOriginalPrice() : "N/A";
        String rating = property.getRating() != null ? property.getRating() : "N/A";
        String roomType = property.getRoomType() != null ? property.getRoomType() : "N/A";

        JLabel rentalLabel = new JLabel("Rental Details:");
        rentalLabel.setFont(boldFont);

        JLabel listingNameDetail = new JLabel("Listing Name: " + name);
        listingNameDetail.setFont(regularFont);

        JLabel discountedPriceDetail = new JLabel("Discounted Price: " + discountPrice);
        discountedPriceDetail.setFont(regularFont);

        JLabel originalPriceDetail = new JLabel("Original Price: " + originalPrice);
        originalPriceDetail.setFont(regularFont);

        JLabel starRatingDetail = new JLabel("Rating: " + rating);
        starRatingDetail.setFont(regularFont);

        JLabel roomTypeDetail = new JLabel("Room type: " + roomType);
        roomTypeDetail.setFont(regularFont);

        panel.add(rentalLabel);
        panel.add(listingNameDetail);
        panel.add(discountedPriceDetail);
        panel.add(originalPriceDetail);
        panel.add(starRatingDetail);
        panel.add(roomTypeDetail);

        return panel;
    }
    private void updateItinerary(PropertyState state) {
        propertiesPanel.removeAll();

        // Get the selected property from the ItineraryViewModel
        Property selectedProperty = viewModel.getSelectedProperty();

        // Add a panel to show the property details if a property is selected
        propertiesPanel.add(createPropertyPanel(selectedProperty));

        // Refresh the UI to show the updated property
        propertiesPanel.revalidate();
        propertiesPanel.repaint();
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            updateItinerary(propertyState);
        }
    }

    public String getViewName() {
        return "itinerary view";
    }
}
