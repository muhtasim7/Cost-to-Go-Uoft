package interface_adapters.itinerary;

import entities.Itinerary;
import entities.Property;
import entity_rosa.University;
import interface_adapters.property.PropertyState;
import usecases.itinerary.ItineraryOutputData;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ItineraryViewModel {
    private ItineraryOutputData state;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private PropertyState propertyState;
    private University selectedUniversity;

    // Modify the constructor to accept PropertyState
    public ItineraryViewModel(PropertyState propertyState) {
        this.propertyState = propertyState;
    }

    // Getter for the state
    public ItineraryOutputData getState() {
        return state;
    }

    public void setState(ItineraryOutputData state) {
        ItineraryOutputData oldState = this.state;
        this.state = state;
        pcs.firePropertyChange("state", oldState, state);
    }

    public Property getSelectedProperty() {
        return propertyState.getSelectedProperty(); // Access selected property from PropertyState
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }

    public void setSelectedUniversities(University selectedUniversity) {
        this.selectedUniversity = selectedUniversity;
    }
    public University getSelectedUniversities() {
        return selectedUniversity;
    }
}


