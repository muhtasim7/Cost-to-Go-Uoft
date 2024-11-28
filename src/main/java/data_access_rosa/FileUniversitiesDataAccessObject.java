package data_access_rosa;

import entity_rosa.University;
import use_case_rosa.universities.UniversitiesDataAccessInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles reading and writing data from the CSV file.
 * DAO for the universities csv file.
 */

public class FileUniversitiesDataAccessObject implements UniversitiesDataAccessInterface {
    String file = "src/main/java/data_access_rosa/Cleaned_University_Data.csv";

    public List<Object[]> readUniversities() {
        List<Object[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            reader.readLine(); // Skip the header row
            while ((line = reader.readLine()) != null) {
                // Strip any leading or trailing whitespace and handle commas within quotes
                line = line.trim();
                if (!line.isEmpty()) {
                    // Manually handle splitting the line by commas but keeping quoted values intact
                    String[] row = splitCSVLine(line);
                    if (row.length == 8) {
                        // Add row data to the list
                        data.add(new Object[] {
                                row[0].trim(), // Country
                                row[1].trim(), // City
                                row[2].trim(), // University Name
                                row[3].trim(), // Language of Study
                                row[4].trim(), // Tuition
                                row[5].trim(), // Award
                                row[7].trim()  // Min GPA
                        });
                        // Print the current row data being added to the list
                        System.out.println("Added row: " + String.join(", ", row));
                    } else {
                        System.err.println("Malformed row: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private String[] splitCSVLine(String line) {
        // This method will handle commas within quotes properly.
        List<String> values = new ArrayList<>();
        StringBuilder currentField = new StringBuilder();
        boolean insideQuotes = false;

        // Iterate through each character in the line
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            if (currentChar == '"') {
                // Toggle the insideQuotes flag when encountering a quote
                insideQuotes = !insideQuotes;
            } else if (currentChar == ',' && !insideQuotes) {
                // If we are outside quotes, split on commas
                values.add(currentField.toString().trim());
                currentField = new StringBuilder(); // reset for next field
            } else {
                // Add the character to the current field
                currentField.append(currentChar);
            }
        }
        // Add the last field
        values.add(currentField.toString().trim());

        // Return the array of split values
        return values.toArray(new String[0]);
    }


//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line;
//            reader.readLine(); // skip the header row
//            while ((line = reader.readLine()) != null) {
//                String[] row = line.split(",");
//                if (row.length == 8) {
//                    // Add the data to the list in the desired format
//                    data.add(new Object[] {
//                            row[0].trim(), // country
//                            row[1].trim(), // city
//                            row[2].trim(), // university name
//                            row[3].trim(), // language of study
//                            row[4].trim(), // tuition
//                            row[5].trim(), // award
//                            row[7].trim()  // min gpa
//                    });
//                } else {
//                    System.err.println("Malformed row: " + line);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return data;
    }
