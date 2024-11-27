//package data_access;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import interface_adapters.property.PropertyState;
//import interface_adapters.property.PropertyViewModel;
//
//public class FileReaderService {
//    private final String filePath;
//    private PropertyViewModel viewModel;
//
//    public FileReaderService(String filePath) {
//        this.filePath = filePath;
//    }
//
//    public List<String> readFileData() {
//        this.viewModel = viewModel;
//        List<String> list = new ArrayList<>();
//        double totalCost = 0;
//        PropertyState state = viewModel.getState();
//        viewModel.setState(state);
//
//        System.out.println("Selected Property Saved: " + state.getSelectedProperty());
//        return void;
//    }
//}
//
//
////        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
////            String line;
////            while ((line = reader.readLine()) != null) {
////                if (line.contains("Country:")) {
////                    list.add(line.substring(line.indexOf("Country:") + 8).replace("\"", "").trim());
////                }
////                if (line.contains("City:")) {
////                    list.add(line.substring(line.indexOf("City:") + 6).replace("\"", "").trim());
////                }
////                if (line.contains("University:")) {
////                    list.add(line.substring(line.indexOf("University:") + 12).replace("\"", "").trim());
////                }
////                if (line.contains("Langauge:")) {
////                    list.add(line.substring(line.indexOf("Langauge:") + 9).replace("\"", "").trim());
////                }
////                if (line.contains("Tuition:")) {
////                    list.add(line.substring(line.indexOf("Tuition:") + 8).replace("\"", "").trim());
////                }
////                if (line.contains("Requirements:")) {
////                    list.add(line.substring(line.indexOf("Requirements:") + 13).replace("\"", "").trim());
////                }
////                if (line.contains("Listing Name:")) {
////                    list.add(line.substring(line.indexOf("Listing Name:") + 13).replace("\"", "").trim());
////                }
////                if (line.contains("Discounted Price:")) {
////                    String discountedPrice = line.substring(line.indexOf("Discounted Price:") + 17).replace("\"", "").trim();
////                    totalCost += Double.parseDouble(discountedPrice);
////                    list.add(discountedPrice);
////                }
////                if (line.contains("Original Price:")) {
////                    list.add(line.substring(line.indexOf("Original Price:") + 15).replace("\"", "").trim());
////                }
////                if (line.contains("Star Rating:")) {
////                    list.add(line.substring(line.indexOf("Star Rating:") + 12).replace("\"", "").trim());
////                }
////                if (line.contains("Bedroom Type:")) {
////                    list.add(line.substring(line.indexOf("Bedroom Type:") + 13).replace("\"", "").trim());
////                }
////                if (line.contains("Destination:")) {
////                    list.add(line.substring(line.indexOf("Destination:") + 12).replace("\"", "").trim());
////                }
////                if (line.contains("Duration:")) {
////                    list.add(line.substring(line.indexOf("Duration:") + 9).replace("\"", "").trim());
////                }
////                if (line.contains("Fare:")) {
////                    String fare = line.substring(line.indexOf("Fare:") + 6).replace("\"", "").trim();
////                    totalCost += Double.parseDouble(fare);
////                    list.add(fare);
////                }
////                if (line.contains("Date:")) {
////                    list.add(line.substring(line.indexOf("Date:") + 6).replace("\"", "").trim());
////                }
////            }
////            System.out.println("hi");
////        } catch (IOException e) {
////            return Collections.emptyList();
////        }
////
////        return list;
////    }
//
//
//
