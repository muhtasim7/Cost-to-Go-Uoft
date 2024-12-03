package interface_adapters.itinerary;

import org.junit.Before;
import org.junit.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import entities.Flight;
import entities.Property;
import entities.University;
import interface_adapters.universities.UniversitiesState;
import interface_adapters.flight.FlightState;
import interface_adapters.property.PropertyState;
import usecases.itinerary.ItineraryOutputData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class ItineraryViewModelTest {

    private ItineraryViewModel viewModel;
    private PropertyState propertyState;
    private FlightState flightState;
    private UniversitiesState universitiesState;

    @Before
    public void setUp() {
        propertyState = new PropertyState();
        flightState = new FlightState();
        universitiesState = new UniversitiesState();
        viewModel = new ItineraryViewModel(propertyState, flightState, universitiesState);
    }

    @Test
    public void testGetState() {
        List<Property> properties = new ArrayList<>();
        Property selectedProperty = viewModel.getSelectedProperty();
        List<University> universities = new ArrayList<>();
        University selectedUniversity = viewModel.getSelectedUniversity();
        List<Flight> flights = new ArrayList<>();
        Flight selectedFlight = viewModel.getSelectedFlight();

        ItineraryOutputData outputData = new ItineraryOutputData(properties, selectedProperty, universities, selectedUniversity, flights, selectedFlight);
        viewModel.setState(outputData);

        assertSame(outputData, viewModel.getState());
    }

    @Test
    public void testSetState() {
        List<Property> properties = new ArrayList<>();
        Property selectedProperty = viewModel.getSelectedProperty();
        List<University> universities = new ArrayList<>();
        University selectedUniversity = viewModel.getSelectedUniversity();
        List<Flight> flights = new ArrayList<>();
        Flight selectedFlight = viewModel.getSelectedFlight();

        ItineraryOutputData outputData = new ItineraryOutputData(properties, selectedProperty, universities, selectedUniversity, flights, selectedFlight);

        class TestListener implements PropertyChangeListener {
            private PropertyChangeEvent event;

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                this.event = evt;
            }

            public PropertyChangeEvent getEvent() {
                return event;
            }
        }

        TestListener listener = new TestListener();
        viewModel.addPropertyChangeListener(listener);

        viewModel.setState(outputData);

        assertNotNull(listener.getEvent());
        assertEquals("state", listener.getEvent().getPropertyName());
        assertSame(outputData, listener.getEvent().getNewValue());
    }

    @Test
    public void testGetSelectedProperty() {
        Property selectedProperty = viewModel.getSelectedProperty();
        propertyState.setSelectedProperty(selectedProperty);

        assertSame(selectedProperty, viewModel.getSelectedProperty());
    }

    @Test
    public void testGetSelectedUniversity() {
        University selectedUniversity = viewModel.getSelectedUniversity();
        universitiesState.setSelectedUniversityData(selectedUniversity);

        assertSame(selectedUniversity, viewModel.getSelectedUniversity());
    }

    @Test
    public void testGetSelectedFlight() {
        Flight selectedFlight = viewModel.getSelectedFlight();
        flightState.setSelectedFlight(selectedFlight);

        assertSame(selectedFlight, viewModel.getSelectedFlight());
    }

    @Test
    public void testSetSelectedUniversities() {
        University selectedUniversity = viewModel.getSelectedUniversity();
        viewModel.setSelectedUniversities(selectedUniversity);

        assertSame(selectedUniversity, viewModel.getSelectedUniversities());
    }
}
