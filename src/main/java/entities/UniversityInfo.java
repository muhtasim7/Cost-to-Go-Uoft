package entities;

public class UniversityInfo {
    private String country;
    private String city;
    private String university;
    private String language;
    private String tuition;
    private String requirements;
    private String listingName;
    private String discountedPrice;
    private String originalPrice;
    private String starRating;
    private String roomType;
    private String destination;
    private String duration;
    private String fare;
    private String date;

    public UniversityInfo() {
    }

    // Constructor
    public UniversityInfo(String country, String city, String university, String language, String tuition, String requirements,
                          String listingName, String discountedPrice, String originalPrice, String starRating,
                          String roomType, String destination, String duration, String fare, String date) {
        this.country = country;
        this.city = city;
        this.university = university;
        this.language = language;
        this.tuition = tuition;
        this.requirements = requirements;
        this.listingName = listingName;
        this.discountedPrice = discountedPrice;
        this.originalPrice = originalPrice;
        this.starRating = starRating;
        this.roomType = roomType;
        this.destination = destination;
        this.duration = duration;
        this.fare = fare;
        this.date = date;
    }

    // Getters and Setters
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getListingName() {
        return listingName;
    }

    public void setListingName(String listingName) {
        this.listingName = listingName;
    }

    public String getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(String discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    // Business logic for total cost
    public double calculateTotalCost() {
        double discountedPriceValue = parseCost(discountedPrice);
        double fareValue = parseCost(fare);
        return discountedPriceValue + fareValue;
    }
    // Helper method for parsing costs
    private double parseCost(String cost) {
        try {
            return Double.parseDouble(cost.replaceAll("[^0-9.]", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    @Override
    public String toString() {
        return "UniversityInfo{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", university='" + university + '\'' +
                ", language='" + language + '\'' +
                ", tuition='" + tuition + '\'' +
                ", requirements='" + requirements + '\'' +
                ", listingName='" + listingName + '\'' +
                ", discountedPrice='" + discountedPrice + '\'' +
                ", originalPrice='" + originalPrice + '\'' +
                ", starRating='" + starRating + '\'' +
                ", roomType='" + roomType + '\'' +
                ", destination='" + destination + '\'' +
                ", duration='" + duration + '\'' +
                ", fare='" + fare + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}