package interface_adapter_rosa.universities;

import entity_rosa.University;

import java.util.ArrayList;
import java.util.List;

/**
 * The state for the universities view model.
 */
public class UniversitiesState {
    // Variable to hold the selected university data
    private University selectedUniversityData;
    private String universitesError;
    private static UniversitiesState instance;

    UniversitiesState() {
    }

    public static synchronized UniversitiesState getInstance() {
        if (instance == null) {
            instance = new UniversitiesState();
        }
        return instance;
    }


    // Setter for the selected university
    public void setSelectedUniversityData(University selectedUniversity) {
        this.selectedUniversityData = selectedUniversity;
    }

    // Getter for the selected university
    public University getSelectedUniversityData() {
        return selectedUniversityData;
    }

    //
    public void setUniversitiesError(String error) {this.universitesError = universitesError; }
}
