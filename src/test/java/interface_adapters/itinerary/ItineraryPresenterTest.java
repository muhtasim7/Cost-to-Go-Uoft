package interface_adapters.itinerary;

import interface_adapters.ViewManagerModel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import entities.Flight;
import entities.Property;
import entity_rosa.University;
import interface_adapter_rosa.universities.UniversitiesState;
import interface_adapters.flight.FlightState;
import interface_adapters.property.PropertyState;
import usecases.itinerary.ItineraryOutputData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ItineraryPresenterTest {

    private ItineraryViewModel viewModel;
    private ViewManagerModel viewManagerModel;
    private ItineraryPresenter presenter;

    @Before
    public void setUp() {
        PropertyState propertyState = new PropertyState();
        FlightState flightState = new FlightState();
        UniversitiesState universitiesState = new UniversitiesState(); // Ensure this is initialized properly
        viewModel = new ItineraryViewModel(propertyState, flightState, universitiesState);
        viewManagerModel = new ViewManagerModel();
        presenter = new ItineraryPresenter(viewModel, viewManagerModel);
    }

    @Test
    public void testPresentItinerary() {
        List<Property> properties = new ArrayList<>();
        Property selectedProperty = viewModel.getSelectedProperty();
        List<University> universities = new ArrayList<>();
        University selectedUniversity = viewModel.getSelectedUniversity();
        List<Flight> flights = new ArrayList<>();
        Flight selectedFlight = viewModel.getSelectedFlight();

        ItineraryOutputData outputData = new ItineraryOutputData(properties, selectedProperty, universities,
                selectedUniversity, flights, selectedFlight);

        presenter.presentItinerary(outputData);

        // Verify that the state has been set in the viewModel
        ItineraryOutputData state = viewModel.getState();
        assertNotNull(state);
        assertEquals(outputData, state);
    }

    @Test
    public void testSwitchToItineraryView() {
        presenter.switchToItineraryView();

        assertEquals("itinerary view", viewManagerModel.getState());
        // If firePropertyChanged() has side effects, you may need additional checks here
    }
}
