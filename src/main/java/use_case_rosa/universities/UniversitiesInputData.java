package use_case_rosa.universities;

import entities.User;
import entity_rosa.University;

import java.util.List;

/**
 * The Input Data for the Universities Use Case
 */
public class UniversitiesInputData {
    private University selecteduniversityinfo;

    public UniversitiesInputData(University selecteduniversityinfo) {
        this.selecteduniversityinfo = selecteduniversityinfo;
    }
    University getSelecteduniversityinfo() {return selecteduniversityinfo;}
}
