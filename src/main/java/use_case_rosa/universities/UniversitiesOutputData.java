package use_case_rosa.universities;

import entity_rosa.University;

import java.util.List;

/**
 * OutputData for the Universities Use Case.
 */
public class UniversitiesOutputData {
    private University selecteduniversity;
    private final boolean useCaseFailed;

    public UniversitiesOutputData(University selecteduniversity, boolean useCaseFailed) {
        this.selecteduniversity = selecteduniversity;
        this.useCaseFailed = useCaseFailed;
    }

    public University getSelecteduniversity() {return selecteduniversity;}
    }
