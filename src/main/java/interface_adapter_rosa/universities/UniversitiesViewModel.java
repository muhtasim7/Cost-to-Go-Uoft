package interface_adapter_rosa.universities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UniversitiesViewModel extends ViewModel<UniversitiesState>{
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public UniversitiesViewModel(){
        super("StudyAbroadOptions");
        setState(new UniversitiesState());
    }
    // Add listener to observe changes
//    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        support.addPropertyChangeListener(listener);
    }

