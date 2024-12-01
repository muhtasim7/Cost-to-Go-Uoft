package use_case_rosa.universities;

import java.util.List;

/**
 * The Universities Interactor
 */

public class UniversitiesInteractor implements UniversitiesInputBoundary {
    private final UniversitiesOutputBoundary universitiesPresenter;

    public UniversitiesInteractor(UniversitiesOutputBoundary universitiesOutputBoundary) {
        this.universitiesPresenter = universitiesOutputBoundary;
    }
    @Override
    public void execute(UniversitiesInputData universitiesInputData) {
        final List<Object> universityrowdata = universitiesInputData.getSelecteduniversityinfo();
        final UniversitiesOutputData universitiesOutputData = new UniversitiesOutputData(universityrowdata, false);
        universitiesPresenter.prepareSuccessView(universitiesOutputData);
    }
}
