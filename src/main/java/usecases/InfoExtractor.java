package usecases;

import entities.UniversityInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InfoExtractor {
    private static final String FILE_PATH = "/Users/alisa.isk/IdeaProjects/Cost-to-Go-Uoft/Data/mockdata.txt";

    public List<UniversityInfo> extractInfo() {
        List<UniversityInfo> infoList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            UniversityInfo universityInfo = new UniversityInfo();

            while ((line = reader.readLine()) != null) {
                // Extracting country data
                if (line.contains("Country:")) {
                    String country = (line.substring(line.indexOf("Country:") + 8).replace("\"", "").trim());
                    universityInfo.setCountry(country);
                }

                // Extracting city data
                if (line.contains("City:")) {
                    String city = (line.substring(line.indexOf("City:") + 6).replace("\"", "").trim());
                    universityInfo.setCity(city);
                }

                // Extracting university data
                if (line.contains("University:")) {
                    String university = (line.substring(line.indexOf("University:") + 12).replace("\"", "").trim());
                    universityInfo.setUniversity(university);
                }

                // Extracting language data
                if (line.contains("Langauge:")) {
                    String language = (line.substring(line.indexOf("Langauge:") + 9).replace("\"", "").trim());
                    universityInfo.setLanguage(language);
                }

                // Extracting tuition data
                if (line.contains("Tuition:")) {
                    String tuition = (line.substring(line.indexOf("Tuition:") + 8).replace("\"", "").trim());
                    universityInfo.setTuition(tuition);
                }

                // Extracting requirements data
                if (line.contains("Requirements:")) {
                    String requirements = (line.substring(line.indexOf("Requirements:") + 13).replace("\"", "").trim());
                    universityInfo.setRequirements(requirements);
                }

                // Extracting listing name data
                if (line.contains("Listing Name:")) {
                    String listingName = (line.substring(line.indexOf("Listing Name:") + 13).replace("\"", "").trim());
                    universityInfo.setListingName(listingName);
                }

                // Extracting discounted price data
                if (line.contains("Discounted Price:")) {
                    String discountedPrice = (line.substring(line.indexOf("Discounted Price:") + 17).replace("\"", "").trim());
                    universityInfo.setDiscountedPrice(discountedPrice);
                }

                // Extracting original price data
                if (line.contains("Original Price:")) {
                    String originalPrice = (line.substring(line.indexOf("Original Price:") + 15).replace("\"", "").trim());
                    universityInfo.setOriginalPrice(originalPrice);
                }

                // Extracting star rating data
                if (line.contains("Star Rating:")) {
                    String starRating = (line.substring(line.indexOf("Star Rating:") + 12).replace("\"", "").trim());
                    universityInfo.setStarRating(starRating);
                }

                // Extracting room type data
                if (line.contains("Bedroom Type:")) {
                    String roomType = (line.substring(line.indexOf("Bedroom Type:") + 13).replace("\"", "").trim());
                    universityInfo.setRoomType(roomType);
                }

                // Extracting destination data
                if (line.contains("Destination:")) {
                    String destination = (line.substring(line.indexOf("Destination:") + 12).replace("\"", "").trim());
                    universityInfo.setDestination(destination);
                }

                // Extracting duration data
                if (line.contains("Duration:")) {
                    String duration = (line.substring(line.indexOf("Duration:") + 9).replace("\"", "").trim());
                    universityInfo.setDuration(duration);
                }

                // Extracting flight price/fare data
                if (line.contains("Fare:")) {
                    String fare = (line.substring(line.indexOf("Fare:") + 6).replace("\"", "").trim());
                    universityInfo.setFare(fare);
                }

                // Extracting flight date data
                if (line.contains("Date:")) {
                    String date = (line.substring(line.indexOf("Date:") + 6).replace("\"", "").trim());
                    universityInfo.setDate(date);
                }
            }

            infoList.add(universityInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return infoList;
    }
}
