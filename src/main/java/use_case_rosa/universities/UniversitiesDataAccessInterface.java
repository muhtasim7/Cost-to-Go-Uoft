package use_case_rosa.universities;

import entities.User;
import entity_rosa.University;

import java.util.List;

/**
 * The DAO for the Universities Use Case.
 */
public interface UniversitiesDataAccessInterface {

    /**
     * Checks for the eligible study abroad options depending on user input.
     */
    public List<Object[]> readUniversities();
}
