package interface_adapter_rosa.universities;

import interface_adapters.ViewManagerModel;
import use_case_rosa.universities.UniversitiesOutputBoundary;
import use_case_rosa.universities.UniversitiesOutputData;

import java.util.List;

/**
 * The Presenter for the Universities Use Case.
 */
public class UniversitiesPresenter implements UniversitiesOutputBoundary {
    private final UniversitiesViewModel universitiesViewModel;
    private final ViewManagerModel viewManagerModel;

    // usage will be in the app builder
    public UniversitiesPresenter(ViewManagerModel viewManagerModel,
                                 UniversitiesViewModel universitiesViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.universitiesViewModel = universitiesViewModel;
        // add in the next view model
    }
    public void prepareSuccessView(UniversitiesOutputData response) {
        List<Object> selecteduniversitydata = response.getSelecteduniversity();

        // updates the universitiesstate
        final UniversitiesState universitiesState = universitiesViewModel.getState();
        universitiesState.setSelectedUniversityData(selecteduniversitydata);

        // TEST: checking if the university is saved
        System.out.println(universitiesState.getSelectedUniversityData() + "in the unipresenter file");

        this.universitiesViewModel.setState(universitiesState);
        //notify the view model of the update
        this.universitiesViewModel.firePropertyChanged();
        // TODO: On success, switch to the dashboard view.
        this.viewManagerModel.setState("dashboardView");
        this.viewManagerModel.firePropertyChanged();

    }
    public void prepareFailView(String error) {
        final UniversitiesState universitiesState = universitiesViewModel.getState();
        universitiesState.setUniversitiesError(error);
        universitiesViewModel.firePropertyChanged();
    }
}
