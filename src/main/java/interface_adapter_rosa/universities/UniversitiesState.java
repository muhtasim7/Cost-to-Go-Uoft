package interface_adapter_rosa.universities;

/**
 * The state for the universities view model.
 */
public class UniversitiesState {
    // Variable to hold the selected university data
    private Object[] selectedUniversity;

    // Getter for the selected university
    public Object[] getSelectedUniversity() {
        return selectedUniversity;
    }

    // Setter for the selected university
    public void setSelectedUniversity(Object[] selectedUniversity) {
        this.selectedUniversity = selectedUniversity;
    }
}
