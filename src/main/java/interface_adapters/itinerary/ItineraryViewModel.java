package interface_adapters.itinerary;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import entities.Flight;
import entities.Property;
import entity_rosa.University;
import interface_adapter_rosa.universities.UniversitiesState;
import interface_adapters.flight.FlightState;
import interface_adapters.property.PropertyState;
import usecases.itinerary.ItineraryOutputData;

/**
 * ViewModel for managing and updating the itinerary state.
 * This class acts as an intermediary between the UI and the underlying data model.
 */
public class ItineraryViewModel {
    private ItineraryOutputData state;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private final PropertyState propertyState;
    private University selectedUniversity;
    private UniversitiesState universitiesState;
    private final FlightState flightState;

    /**
     * Constructs an ItineraryViewModel with the given PropertyState, FlightState, and UniversitiesState.
     *
     * @param propertyState the initial state of the properties
     * @param flightState the initial state of the flights
     * @param universitiesState the initial state of the universities
     */
    public ItineraryViewModel(PropertyState propertyState, FlightState flightState, UniversitiesState universitiesState){
        this.propertyState = propertyState;
        this.flightState = flightState;
        this.universitiesState = universitiesState;
    }

    /**
     * Gets the current itinerary state.
     *
     * @return the current itinerary state
     */
    public ItineraryOutputData getState() {
        return state;
    }

    /**
     * Sets a new itinerary state and notifies listeners of the change.
     *
     * @param state the new itinerary state
     */
    public void setState(ItineraryOutputData state) {
        final ItineraryOutputData oldState = this.state;
        this.state = state;
        pcs.firePropertyChange("state", oldState, state);
    }

    /**
     * Gets the currently selected property from the PropertyState.
     *
     * @return the selected property
     */
    public Property getSelectedProperty() {
        return propertyState.getSelectedProperty();
    }

    /**
     * Gets the currently selected university from the UniversitiesState.
     *
     * @return the selected university
     */
    public University getSelectedUniversity() {
        return universitiesState.getSelectedUniversityData();
    }

    /**
     * Adds a PropertyChangeListener to the listener list.
     *
     * @param listener the PropertyChangeListener to be added
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * Sets the selected university for the itinerary.
     *
     * @param selectedUniversity the selected university
     */
    public void setSelectedUniversities(University selectedUniversity) {
        this.selectedUniversity = selectedUniversity;
    }

    /**
     * Gets the currently selected university.
     *
     * @return the selected university
     */
    public University getSelectedUniversities() {
        return selectedUniversity;
    }

    /**
     * Gets the currently selected flight from the FlightState.
     *
     * @return the selected flight
     */
    public Flight getSelectedFlight() {
        return flightState.getSelectedFlight();
    }

    /**
     * Sets the selected property for the itinerary.
     *
     * @param selectedFlight the selected university
     */
    public void setSelectedFlight(Flight selectedFlight) {
        flightState.setSelectedFlight(selectedFlight);
    }

    /**
     * Sets the selected property for the itinerary.
     *
     * @param selectedProperty the selected university
     */
    public void setSelectedProperty(Property selectedProperty) {
        this.propertyState.setSelectedProperty(selectedProperty);
    }
}
