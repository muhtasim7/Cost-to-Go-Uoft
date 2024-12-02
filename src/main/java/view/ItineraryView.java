package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.swing.*;

import entities.Flight;
import entities.Property;
import entity_rosa.University;
import interface_adapter_rosa.universities.UniversitiesState;
import interface_adapters.flight.FlightState;
import interface_adapters.itinerary.ItineraryController;
import interface_adapters.itinerary.ItineraryViewModel;
import interface_adapters.property.PropertyState;

/**
 * The {@code ItineraryView} class is a {@link JPanel} that displays the details of a selected property,
 * university, and flight in the user's itinerary. It listens for property changes and updates the displayed
 * details accordingly. The class is responsible for creating and updating UI components such as property details,
 * university details, and flight details in a scrollable panel.
 * The view is updated whenever there is a change in the itinerary's state, reflecting the selected property,
 * university, and flight details through panels that show relevant information.
 * <p>The view listens to changes in the {@code PropertyState} from the model via the {@link PropertyChangeListener}
 * interface and reflects these changes in the UI.</p>
 *
 */
public class ItineraryView extends JPanel implements PropertyChangeListener {

    private final JPanel propertiesPanel = new JPanel();
    private final ItineraryController itineraryController;
    private final ItineraryViewModel viewModel;
    private final PropertyState propertyState = new PropertyState();
    private final UniversitiesState universitiesState = new UniversitiesState();
    private FlightState flightState = new FlightState();

    private final Font regularFont = new Font("Apple LiGothic", Font.PLAIN, 20);
    private final Font boldFont = new Font("Apple LiGothic", Font.BOLD, 30);

    /**
     * Constructs an {@code ItineraryView} with the given {@code ItineraryController} and {@code ItineraryViewModel}.
     * Sets up the layout and initializes the view components such as the title and property details panels.
     *
     * @param itineraryController the controller that handles the interaction between the view and the model
     * @param viewModel the model that holds the current state of the itinerary
     */
    public ItineraryView(ItineraryController itineraryController, ItineraryViewModel viewModel) {
        this.itineraryController = itineraryController;
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);
        setLayout(new BorderLayout());

        // Title panel setup
        final JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBackground(new Color(255, 191, 71));

        final JLabel titleLabel = new JLabel("Your Itinerary");
        titleLabel.setFont(boldFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        // Properties panel setup
        propertiesPanel.setLayout(new BoxLayout(propertiesPanel, BoxLayout.Y_AXIS));
        final JScrollPane scrollPane = new JScrollPane(propertiesPanel);
        add(scrollPane, BorderLayout.CENTER);

        updateItinerary(propertyState, viewModel, flightState);
    }

    /**
     * Creates a panel that displays the details of a given property.
     *
     * @param property the property whose details are to be displayed
     * @return a {@code JPanel} containing labels with the property details
     */
    private JPanel createPropertyPanel(Property property) {
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(new Color(159, 224, 229));

        final String name = property.getName() != null ? property.getName() : "n/a";
        final String discountPrice = property.getDiscountedPrice() != null ? property.getDiscountedPrice() : "n/a";
        final String originalPrice = property.getOriginalPrice() != null ? property.getOriginalPrice() : "n/a";
        final String rating = property.getRating() != null ? property.getRating() : "n/a";
        final String roomType = property.getRoomType() != null ? property.getRoomType() : "n/a";

        final JLabel rentalLabel = new JLabel("Rental Details:");
        rentalLabel.setFont(boldFont);

        final JLabel listingNameDetail = new JLabel("Listing Name: " + name);
        listingNameDetail.setFont(regularFont);

        final JLabel discountedPriceDetail = new JLabel("Discounted Price: " + discountPrice);
        discountedPriceDetail.setFont(regularFont);

        final JLabel originalPriceDetail = new JLabel("Original Price: " + originalPrice);
        originalPriceDetail.setFont(regularFont);

        final JLabel starRatingDetail = new JLabel("Rating: " + rating);
        starRatingDetail.setFont(regularFont);

        final JLabel roomTypeDetail = new JLabel("Room type: " + roomType);
        roomTypeDetail.setFont(regularFont);

        panel.add(rentalLabel);
        panel.add(listingNameDetail);
        panel.add(discountedPriceDetail);
        panel.add(originalPriceDetail);
        panel.add(starRatingDetail);
        panel.add(roomTypeDetail);

        return panel;
    }

    /**
     * Creates a panel that displays the details of a given university.
     *
     * @param university the university whose details are to be displayed
     * @return a {@code JPanel} containing labels with the university details
     */
    private JPanel createUniversityDetailsPanel(University university) {
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        panel.setBackground(new Color(235, 194, 235));

        final String country = university.getCountry() != null ? university.getCountry() : "n/a";
        final String city = university.getCity() != null ? university.getCity() : "n/a";
        final String name = university.getUniversityName() != null ? university.getUniversityName() : "n/a";
        final String language = university.getLanguage_of_study() != null ? university.getLanguage_of_study() : "n/a";
        final String programFee = university.getTuition() != null ? university.getTuition() : "n/a";
        final String minimumGpa = university.getMinimum_gpa() != null ? university.getMinimum_gpa() : "n/a";

        final JLabel universityLabel = new JLabel("University Details:");
        universityLabel.setFont(boldFont);

        final JLabel countryDetail = new JLabel("Country: " + country);
        countryDetail.setFont(regularFont);

        final JLabel cityDetail = new JLabel("City: " + city);
        cityDetail.setFont(regularFont);

        final JLabel universityNameDetail = new JLabel("University: " + name);
        universityNameDetail.setFont(regularFont);

        final JLabel languageDetail = new JLabel("Language: " + language);
        languageDetail.setFont(regularFont);

        final JLabel programFeeDetail = new JLabel("Program Fee: " + programFee);
        programFeeDetail.setFont(regularFont);

        final JLabel minimumGpaDetail = new JLabel(minimumGpa);
        minimumGpaDetail.setFont(regularFont);

        panel.add(universityLabel);
        panel.add(countryDetail);
        panel.add(cityDetail);
        panel.add(universityNameDetail);
        panel.add(languageDetail);
        panel.add(programFeeDetail);
        panel.add(minimumGpaDetail);

        return panel;
    }

    /**
     * Creates a panel that displays the flight details such as departure time, arrival time,
     * arrival airport, flight duration, and price.
     *
     * @param flight the flight whose details are to be displayed
     * @return a {@code JPanel} containing labels with the flight details
     */
    private JPanel createFlightDetailsPanel(Flight flight) {
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(new Color(190, 211, 115));

        final String departureTime = flight.getDepartureTime() != null ? flight.getDepartureTime() : "n/a";
        final String arrivalTime = flight.getArrivalTime() != null ? flight.getArrivalTime() : "n/a";
        final String arrivalAirport = flight.getArrivalAirport() != null ? flight.getArrivalAirport() : "n/a";
        final String flightDuration = flight.getFlightDuration() != null ? flight.getFlightDuration() : "n/a";
        final String price = flight.getPrice() != null ? flight.getPrice() : "n/a";

        final JLabel flightLabel = new JLabel("Flight Details:");
        flightLabel.setFont(boldFont);

        final JLabel departureTimeDetail = new JLabel("Departure Time: " + departureTime);
        departureTimeDetail.setFont(regularFont);

        final JLabel arrivalTimeDetail = new JLabel("Arrival Time: " + arrivalTime);
        arrivalTimeDetail.setFont(regularFont);

        final JLabel arrivalAirportDetail = new JLabel("Arrival Airport: " + arrivalAirport);
        arrivalAirportDetail.setFont(regularFont);

        final JLabel flightDurationDetail = new JLabel("Flight Duration: " + flightDuration);
        flightDurationDetail.setFont(regularFont);

        final JLabel priceDetail = new JLabel("Price: " + price);
        priceDetail.setFont(regularFont);

        panel.add(flightLabel);
        panel.add(departureTimeDetail);
        panel.add(arrivalTimeDetail);
        panel.add(arrivalAirportDetail);
        panel.add(flightDurationDetail);
        panel.add(priceDetail);

        return panel;
    }
    /**
     * Updates the itinerary by setting up property, university, and flight details in the view.
     *
     * @param propertyState the current state of the property
       ADD BACK UNIVERSITY AFTER !!!!!!!!
     */
    private void updateItinerary(PropertyState propertyState, ItineraryViewModel itineraryViewModel, FlightState flightstate) {
        propertiesPanel.removeAll();

        Property selectedProperty = viewModel.getSelectedProperty();
        Flight selectedFlight = viewModel.getSelectedFlight();

        if (selectedProperty != null) {
            propertiesPanel.add(createPropertyPanel(selectedProperty));
        }
        if (selectedFlight != null) {
            propertiesPanel.add(createFlightDetailsPanel(selectedFlight));
        }
        if (selectedProperty == null) {
            System.out.print("Hello sim");
        }
        itineraryViewModel.setSelectedUniversities(UniversitiesState.getInstance().getSelectedUniversityData());
        University selectedUniversity = itineraryViewModel.getSelectedUniversities();
        if (selectedUniversity != null) {
            propertiesPanel.add(createUniversityDetailsPanel(selectedUniversity));
        }
        propertiesPanel.revalidate();
        propertiesPanel.repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        if ("state".equals(evt.getPropertyName())) {
//            propertyState = (PropertyState) evt.getNewValue();
////        } else if ("selectedUniversity".equals(evt.getPropertyName())) {
////            universitiesState = (UniversitiesState) evt.getNewValue();
//        } else if ("selectedFlight".equals(evt.getPropertyName())) {
//            flightState = (FlightState) evt.getNewValue();
//        }
        if ("state".equals(evt.getPropertyName())) {
            updateItinerary(propertyState, viewModel, flightState);
        }

    }
}
