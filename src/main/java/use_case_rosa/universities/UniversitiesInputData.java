package use_case_rosa.universities;

import entities.User;

import java.util.List;

/**
 * The Input Data for the Universities Use Case
 */
public class UniversitiesInputData {
    private List<Object> selecteduniversityinfo;

    public UniversitiesInputData(List<Object> selecteduniversityinfo) {
        this.selecteduniversityinfo = selecteduniversityinfo;
    }
    List<Object> getSelecteduniversityinfo() {return selecteduniversityinfo;}
}
