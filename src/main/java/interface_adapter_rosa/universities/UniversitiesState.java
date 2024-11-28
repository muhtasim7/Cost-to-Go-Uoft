package interface_adapter_rosa.universities;

import java.util.List;

/**
 * The state for the universities view model.
 */
public class UniversitiesState {
    // Variable to hold the selected university data
    private List<Object> selectedUniversityData;
    private String universitesError;

    // Setter for the selected university
    public void setSelectedUniversityData(List<Object> selectedUniversity) {
        this.selectedUniversityData = selectedUniversity;
    }

    // Getter for the selected university
    public List<Object> getSelectedUniversityData() {
        return selectedUniversityData;
    }

    //
    public void setUniversitiesError(String error) {this.universitesError = universitesError; }
}
