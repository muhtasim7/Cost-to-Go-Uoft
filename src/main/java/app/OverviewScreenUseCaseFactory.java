//package app;
//
//import data_access.FileReaderService;
//import interface_adapters.OverviewController;
//import usecases.overview_screen.ExtractOverviewData;
//import view.OverviewScreen;
//
//import javax.swing.*;
//
//public class OverviewScreenUseCaseFactory {
//    public static void main(String[] args) {
//        String filePath = "/Users/alisa.isk/IdeaProjects/Cost-to-Go-Uoft/Data/mockdata.txt";
//
//        FileReaderService fileReader = new FileReaderService(filePath);
//        System.out.println(fileReader);
//        ExtractOverviewData useCase = new ExtractOverviewData(fileReader);
//        OverviewController controller = new OverviewController(useCase);
//
//        SwingUtilities.invokeLater(() -> {
//            OverviewScreen screen = new OverviewScreen(controller);
//            screen.setVisible(true);
//        });
//    }
//}
//
