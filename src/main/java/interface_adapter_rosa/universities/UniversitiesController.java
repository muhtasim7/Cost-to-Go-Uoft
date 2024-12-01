package interface_adapter_rosa.universities;

import entity_rosa.University;
import use_case_rosa.universities.UniversitiesInputBoundary;
import use_case_rosa.universities.UniversitiesInputData;

import java.util.List;

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
     * @param universityrowdata a list of the data from the selected row from the jtable.
     */
    public void execute(University universityrowdata) {
        final UniversitiesInputData universitiesInputData = new UniversitiesInputData(universityrowdata);

        universitiesUseCaseInteractor.execute(universitiesInputData);
        }
    }
