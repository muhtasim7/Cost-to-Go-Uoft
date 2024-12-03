package usecases.universities;

import entities.University;

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
