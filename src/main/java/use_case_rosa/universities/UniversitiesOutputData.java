package use_case_rosa.universities;

import java.util.List;

/**
 * OutputData for the Universities Use Case.
 */
public class UniversitiesOutputData {
    private List<Object> selecteduniversity;
    private final boolean useCaseFailed;

    public UniversitiesOutputData(List<Object> selecteduniversity, boolean useCaseFailed) {
        this.selecteduniversity = selecteduniversity;
        this.useCaseFailed = useCaseFailed;
    }

    public List<Object> getSelecteduniversity() {return selecteduniversity;}
    }
