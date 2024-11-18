package interface_adapter_rosa.universities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UniversitiesViewModel extends ViewModel<UniversitiesState>{
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public UniversitiesViewModel(){
        super("StudyAbroadOptions");
        setState(new UniversitiesState());
    }
    // Method to handle the selection of a university
    public void selectUniversity(Object[] selectedData) {
        getState().setSelectedUniversity(selectedData);  // Update the state with selected university
        support.firePropertyChange("selectedUniversity", null, selectedData);  // Notify listeners
    }

    // Add listener to observe changes
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
