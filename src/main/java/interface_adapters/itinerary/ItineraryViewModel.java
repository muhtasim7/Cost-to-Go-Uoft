package interface_adapters.itinerary;

import entities.Flight;
import entities.Itinerary;
import entities.Property;
import entity_rosa.University;
import interface_adapter_rosa.universities.UniversitiesState;
import entity_rosa.University;
import interface_adapters.property.PropertyState;
import usecases.itinerary.ItineraryOutputData;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import interface_adapters.flight.FlightState;
/**
 * ViewModel for managing and updating the itinerary state.
 * This class acts as an intermediary between the UI and the underlying data model.
 */
public class ItineraryViewModel {
    private ItineraryOutputData state;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private PropertyState propertyState;
    private University selectedUniversity;
    private UniversitiesState universitiesState;
    private FlightState flightState;

    /**
     * Constructs an ItineraryViewModel with the given PropertyState.
     *
     * @param propertyState the initial state of the properties
     */
    public ItineraryViewModel(PropertyState propertyState, FlightState flightState) {
        this.propertyState = propertyState;
        this.flightState = flightState;
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
     * Removes a PropertyChangeListener from the listener list.
     *
     * @param listener the PropertyChangeListener to be removed
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }

    public void setSelectedUniversities(University selectedUniversity) {
        this.selectedUniversity = selectedUniversity;
    }
    public University getSelectedUniversities() {
        return selectedUniversity;
    }
//Javadocs
    public Flight getSelectedFlight() {
        return flightState.getSelectedFlight();
    }
}
