package interface_adapter_rosa.universities;

import use_case_rosa.universities.UniversitiesInputBoundary;

/**
 * The controller for the Universities Use Case
 */
public class UniversitiesController {
    private final UniversitiesInputBoundary universitiesUseCaseInteractor;

    public UniversitiesController(UniversitiesInputBoundary universitiesUseCaseInteractor) {
        this.universitiesUseCaseInteractor = universitiesUseCaseInteractor;
    }

    /**
     * Executes the Universities Use Case
     */
    public void execute() {
        // maybe add smth like universities input data

        universitiesUseCaseInteractor.execute(); {
            //universitiesInputData); // figure out what needs to be done
        }
    }
}
