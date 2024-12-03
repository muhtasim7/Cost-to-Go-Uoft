package usecases.universities;

import entities.University;
import org.junit.Test;

import static org.junit.Assert.*;

// Test Class
public class UniversitiesInteractorTest {
    @Test
    public void testExecute() {

        // Create mock university data
        University mockUniversity = new University("Sample country", "Sample City", "sample name", "langauge", "tuition", "award", "3.0");
        UniversitiesInputData mockInputData = new UniversitiesInputData(mockUniversity);


        // This creates a successPresenter that tests whether the test case is as we expect.
        UniversitiesOutputBoundary successPresenter = new UniversitiesOutputBoundary() {
            @Override
            public void prepareSuccessView(UniversitiesOutputData outputData) {
                assertEquals("Sample country", outputData.getSelecteduniversity().getCountry());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

        };
        UniversitiesInputBoundary interactor = new UniversitiesInteractor(successPresenter);
        interactor.execute(mockInputData);
    }
}