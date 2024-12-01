//package usecases.overview_screen;
//
//import data_access.FileReaderService;
//import java.util.List;
//
//public class ExtractOverviewData {
//    private final FileReaderService fileReader;
//
//    private String country;
//    private String city;
//    private String university;
//    private String language;
//    private String tuition;
//    private String requirements;
//    private String listingName;
//    private String discountedPrice;
//    private String originalPrice;
//    private String starRating;
//    private String roomType;
//    private String destination;
//    private String duration;
//    private String fare;
//    private String date;
//    private String totalCost;
//
//    public ExtractOverviewData(FileReaderService fileReader) {
//        this.fileReader = fileReader;
//    }
//
//    public void extractData() {
//        List<String> data = fileReader.readFileData();
//        // Parse the data and assign to instance variables
//        this.country = data.get(0);
//        this.city = data.get(1);
//        this.university = data.get(2);
//        this.language = data.get(3);
//        this.tuition = data.get(4);
//        this.requirements = data.get(5);
//        this.listingName = data.get(6);
//        this.discountedPrice = data.get(7);
//        this.originalPrice = data.get(8);
//        this.starRating = data.get(9);
//        this.roomType = data.get(10);
//        this.destination = data.get(11);
//        this.duration = data.get(12);
//        this.fare = data.get(13);
//        this.date = data.get(14);
//        this.totalCost = data.get(15);
//    }
//
//    // Add getter methods for each piece of data
//    public String getCountry() { return country; }
//    public String getCity() { return city; }
//    public String getUniversity() { return university; }
//    public String getLanguage() { return language; }
//    public String getTuition() { return tuition; }
//    public String getRequirements() { return requirements; }
//    public String getListingName() { return listingName; }
//    public String getDiscountedPrice() { return discountedPrice; }
//    public String getOriginalPrice() { return originalPrice; }
//    public String getStarRating() { return starRating; }
//    public String getRoomType() { return roomType; }
//    public String getDestination() { return destination; }
//    public String getDuration() { return duration; }
//    public String getFare() { return fare; }
//    public String getDate() { return date; }
//    public String getTotalCost() { return totalCost; }
//}
//
//
