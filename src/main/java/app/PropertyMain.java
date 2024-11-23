package app;

import data_access.AIRBNB;
import entities.CommonPropertyFactory;
import view.PropertyView;

import javax.swing.*;

public class PropertyMain {
    public static void main(String[] args) {
        // Create the main application frame
        JFrame application = new JFrame("Property Management Application");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create the necessary components
        CommonPropertyFactory propertyFactory = new CommonPropertyFactory();
        AIRBNB airbnbDataAccess = new AIRBNB(propertyFactory);

        // Directly create and display the PropertyView
        PropertyView propertyView = PropertyUseCaseFactory.create(airbnbDataAccess, "Toronto");
        application.add(propertyView);

        application.setSize(800, 600);
        application.setVisible(true);
    }
}
