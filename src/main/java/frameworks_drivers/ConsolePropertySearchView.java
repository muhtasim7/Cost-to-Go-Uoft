package frameworks_drivers;

import entities.Property;
import interface_adapters.PropertyController;

import java.util.List;
import java.util.Scanner;

public class ConsolePropertySearchView {
    private final PropertyController controller;

    public ConsolePropertySearchView(PropertyController controller) {
        this.controller = controller;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter city name:");
        String city = scanner.nextLine();

        try {
            List<Property> properties = controller.searchProperties(city);
            if (properties.isEmpty()) {
                System.out.println("No properties found.");
            } else {
                System.out.println("Properties found:");
                for (Property property : properties) {
                    System.out.println("Listing Name: " + property.getListingName());
                    System.out.println("Discounted Price: " + property.getDiscountedPrice());
                    System.out.println("Original Price: " + property.getOriginalPrice());
                    System.out.println("Star Rating: " + property.getAvgRatingLocalized());
                    System.out.println("Room Type: " + property.getRoomTye());
                    System.out.println("--------------------------------------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching properties: " + e.getMessage());
        }
    }
}
