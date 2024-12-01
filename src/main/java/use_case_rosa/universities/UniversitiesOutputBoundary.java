package use_case_rosa.universities;

public interface UniversitiesOutputBoundary {
    /**
     * Prepares the success view for the Universities Use Case
     * @param outputData the output data
     */
    void prepareSuccessView(UniversitiesOutputData outputData);
    /**
     * Prepares the failure view for the Universities Use Case
     * @param errorMessage the explanation for the failure
     */
    void prepareFailView(String errorMessage);
}
