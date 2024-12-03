package usecases.universities;

import entities.University;

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
        final University universityrowdata = universitiesInputData.getSelecteduniversityinfo();
        final UniversitiesOutputData universitiesOutputData = new UniversitiesOutputData(universityrowdata, false);
        universitiesPresenter.prepareSuccessView(universitiesOutputData);
    }
}
