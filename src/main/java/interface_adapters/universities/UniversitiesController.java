package interface_adapters.universities;

import entities.University;
import usecases.universities.UniversitiesInputBoundary;
import usecases.universities.UniversitiesInputData;

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
