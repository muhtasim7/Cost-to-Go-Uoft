package usecases.universities;

import data_access.FileUniversitiesDataAccessObject;
import entities.User;
import entities.University;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the filtering logic for the universities based on the user info.
 */

public class FilterUniversities {

    public List<University> filterUniversities(User user) {
        String stringGPA = user.getGpa();
        double user_gpa = Double.parseDouble(stringGPA);

        // read university data from the repository
        FileUniversitiesDataAccessObject repository = new FileUniversitiesDataAccessObject();
        List<University> universityList = repository.readUniversities();

        // Initialize an empty list to hold the filtered universities
        List<University> filteredUniversities = new ArrayList<>();
        // Iterate over the university list
        for (University university : universityList) {
            boolean isEligible = meetsMinimumGPA(university.getMinimum_gpa(), user.getDegreeType(), user_gpa);

            String user_language = user.getLanguage();
            String university_language = university.getLanguage_of_study();
            if (!language(user_language, university_language)) {
                isEligible = false;
            }

            if (isEligible) {
                filteredUniversities.add(university);
            }
        }
        return filteredUniversities;
    }


    public static double extract_GPA(String gpaString, String programType) {
        try {
            if (gpaString.toLowerCase().contains("graduate")) {
                // Split the string to isolate Undergraduate and Graduate GPA
                String[] parts = gpaString.split("or");
                String undergraduateGPA = parts[0].trim();
                String graduateGrade = parts[1].trim();

                // Return the correct value based on program type
                if (programType.equalsIgnoreCase("Undergraduate")) {
                    // Use regular expression to extract the numeric GPA with decimal
                    String gpa = undergraduateGPA.replaceAll("[^0-9.]+", ""); // Keep digits and decimal
                    return Double.parseDouble(gpa);
                } else if (programType.equalsIgnoreCase("Graduate")) {
                    return 3.0; // B for graduates is 3.0 GPA
                } else {
                    throw new IllegalArgumentException("Invalid program type. Choose 'Undergraduate' or 'Graduate'.");
                }
            } else {

                // Remove non-numeric characters except the decimal point
                String gpa = gpaString.replaceAll("[^0-9.]+", "");

                // Check if the GPA string matches a valid number format (integer or decimal)
                if (gpa.matches("[0-9]*")) {
                    return 3.0;
                }
                return Double.parseDouble(gpa);
            }
        } catch (Exception e) {
            // Catch any exception and return 3.0
            System.out.println("Error: " + e.getMessage() + gpaString + "code breaks");
            return 3.0;
        }
    }

//    public static void main(String[] args) {
//        String gpaString1 = "Minimum CGPA: B";
//        String programType1 = "Undergraduate";
//        System.out.println("Test 1: " + extract_GPA(gpaString1, programType1)); // Expected output: 2.25
//    }

    public boolean meetsMinimumGPA(String gpaString, String programType, double userGPA) {
        double minimumGPA = extract_GPA(gpaString, programType);
        return userGPA >= minimumGPA;
    }
    public boolean language(String user_language, String school_language) {
        return school_language.toLowerCase().contains(user_language.toLowerCase());
    }
}


