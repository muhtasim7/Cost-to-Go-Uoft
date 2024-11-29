package use_case_rosa.universities;

import data_access.FileUserDataAccessObject;
import data_access_rosa.FileUniversitiesDataAccessObject;
import entities.CommonUser;
import entities.CommonUserFactory;
import entities.User;
import entities.UserFactory;
import entity_rosa.University;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the filtering logic for the universities based on the user info.
 */

public class FilterUniversities {
//    private CommonUser current_user;
//    String gpa;
//    String degree;
//    String program;
//    String language;

    public List<Object[]> filterUniversities(User user) {
        String gpa = user.getGpa();
        String degree = user.getDegreeType();
        String program = user.getProgram();
        String language = user.getLanguage();

        FileUniversitiesDataAccessObject repository = new FileUniversitiesDataAccessObject();
        List<Object[]> universityList = repository.readUniversities();

        // Initialize an empty list to hold the filtered universities
        List<Object[]> filteredUniversities = new ArrayList<>();

        // Iterate over the university list
        for (Object[] university : universityList) {
            boolean isEligible = true;

//            // Ensure the university row has the required data
//            if (university.length < 7) {
//                continue; // Skip malformed rows
//            }
//
//            // Get values from the Object[] (index references match the example in your previous message)
//            String country = (String) university[0];
//            String city = (String) university[1];
//            String universityName = (String) university[2];
            String studyLanguage = (String) university[3];
//            String tuition = (String) university[4];
//            String award = (String) university[5];
//            String minGPA = (String) university[6];
//
//            // Check if the user's program matches the university's program (assuming program is in user's info)
//            if (user.getProgram() != null && !studyLanguage.contains(program)) {
//                isEligible = false;
//            }
//
//            // Check if the user's language matches the university's language of study
//            if (studyLanguage != null && !studyLanguage.equalsIgnoreCase(language)) {
//                isEligible = false;
//            }
//
//            // Check if the user's GPA meets the minimum requirement of the university
////            if (minGPA != null) {
////                try {
////                    double userGPA = Double.parseDouble(gpa);
////                    double minGPAValue = Double.parseDouble(minGPA);
////                    if (userGPA < minGPAValue) {
////                        isEligible = false;
////                    }
////                } catch (NumberFormatException e) {
////                    isEligible = false; // Invalid GPA value from the user or university
////                }
////            }

            // If all conditions are met, add the university to the filtered list
            if (isEligible) {
                filteredUniversities.add(university);
            }
        }
        // Return the filtered list
        return filteredUniversities;
    }
}

