package use_case_rosa.universities;

import java.util.List;

/**
 * The Universities Interactor
 */

public class UniversitiesInteractor implements UniversitiesInputBoundary {
    private final UniversitiesDataAccessInterface universitiesDataAccessObject;
    private final UniversitiesOutputBoundary universitiesPresenter;

    public UniversitiesInteractor(UniversitiesDataAccessInterface universitiesDataAccessInterface,
                                  UniversitiesOutputBoundary universitiesOutputBoundary) {
        this.universitiesDataAccessObject = universitiesDataAccessInterface;
        this.universitiesPresenter = universitiesOutputBoundary;
    }
    @Override
    public void execute(UniversitiesInputData universitiesInputData) {
        // implement
        final List<Object> universityrowdata = universitiesInputData.getSelecteduniversityinfo();
        final UniversitiesOutputData universitiesOutputData = new UniversitiesOutputData(universityrowdata, false);
        universitiesPresenter.prepareSuccessView(universitiesOutputData);
        // TODO: add a line
    }
}
