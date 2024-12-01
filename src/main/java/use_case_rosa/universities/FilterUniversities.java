package use_case_rosa.universities;

import data_access_rosa.FileUniversitiesDataAccessObject;
import entities.CommonUser;
import entities.User;
import entity_rosa.University;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements the filtering logic for the universities based on the user info.
 */

public class FilterUniversities {

    public List<University> filterUniversities(User user) {
//        String stringGPA = user.getGpa();
//        double user_gpa = Double.parseDouble(stringGPA);
//        String degree = user.getDegreeType();
//        String program = user.getProgram();
//        String language = user.getLanguage();

        // read university data from the repository
        FileUniversitiesDataAccessObject repository = new FileUniversitiesDataAccessObject();
        List<University> universityList = repository.readUniversities();

        // Initialize an empty list to hold the filtered universities
        List<University> filteredUniversities = new ArrayList<>();
        // Iterate over the university list
        for (University university : universityList) {
            boolean isEligible = true;

//            // Get values from the Object[] (index references match the example in your previous message)
//            String country = (String) university[0];
//            String city = (String) university[1];
//            String universityName = (String) university[2];
//            String studyLanguage = (String) university[3];
//            String tuition = (String) university[4];
//            String award = (String) university[5];
//            String minGPA = (String) university[6];
//
//          // Check if the user's program matches the university's program (assuming program is in user's info)

            // Check if the user's language matches the university's language of study
//            if (studyLanguage != null && !studyLanguage.equalsIgnoreCase(language)) {
//                isEligible = false;
//            }

//            // Check if the user's GPA meets the minimum requirement of the university
            // If all conditions are met, add the university to the filtered list
//            if (isEligible) {
////                int lastIndex = university.length - 1; // calculate the last index
////                System.out.println(university[lastIndex] + "in filteruniversities" + university[lastIndex].getClass().getName());
////                filteredUniversities.add(university);
//                System.out.println(university.getUniversityName() + "FILTERUNIVERSITIES");
                filteredUniversities.add(university);
//            }
        }
        // testing if the user information is actually accessed
//        System.out.println(filteredUniversities + "Sim is the best");
//        System.out.println(user.getName() + user.getGpa() + "checking for null in filter universities");
        // Return the filtered list
        return filteredUniversities;
    }
}

//        public double extract_GPA(String gpaString, String programType) {
//            // GPA mapping for grades letter B
//            Map<String, Double> gradeToGPA = new HashMap<>();
//            gradeToGPA.put("B", 3.0);
//
//            // Split the string to isolate Undergraduate and Graduate GPA
//            String[] parts = gpaString.split("\\(Undergraduates\\)|\\(Graduates\\)");
//            String undergraduateGPA = parts[0].replace("Minimum CGPA:", "").trim();
//            String graduateGrade = parts[1].trim();
//
//            // Return the correct value based on program type
//            if (programType.equalsIgnoreCase("Undergraduate")) {
//                return Double.parseDouble(undergraduateGPA);
//            } else if (programType.equalsIgnoreCase("Graduate")) {
//                return gradeToGPA.getOrDefault(graduateGrade, 0.0); // Default to 0.0 if grade not found
//            } else {
//                throw new IllegalArgumentException("Invalid program type. Choose 'Undergraduate' or 'Graduate'.");
//            }
//        }
//        public boolean meetsMinimumGPA(String gpaString, String programType, double userGPA) {
//        double minimumGPA = extract_GPA(gpaString, programType);
//        return userGPA >= minimumGPA;
//        }
//    }

