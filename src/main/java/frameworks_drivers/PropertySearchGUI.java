import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import entities.Property;
import interface_adapters.PropertyController;
import API.AIRBNB;
import usecases.PropertySearchUseCase;
public class PropertySearchGUI extends JFrame {
    private final Font regularFont = new Font("Apple LiGothic", Font.PLAIN, 20);
    private final Font boldFont = new Font("Apple LiGothic", Font.BOLD, 30);

    private JTextField cityTextField;
    private JButton searchButton;
    private JTable propertyTable;
    private DefaultTableModel tableModel;
    private PropertyController controller;

    public PropertySearchGUI(PropertyController controller) {
        this.controller = controller;
        setTitle("Property Search");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the input panel
        JPanel inputPanel = new JPanel();
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setFont(regularFont);
        inputPanel.add(cityLabel);

        cityTextField = new JTextField(15);
        cityTextField.setFont(regularFont);
        inputPanel.add(cityTextField);

        searchButton = new JButton("Search");
        searchButton.setFont(boldFont);
        inputPanel.add(searchButton);

        // Create the table to display properties
        String[] columnNames = {"Name", "Rating", "Discounted Price", "Original Price", "Room Type"};
        tableModel = new DefaultTableModel(columnNames, 0);
        propertyTable = new JTable(tableModel);

        // Apply bold font to table header
        JTableHeader tableHeader = propertyTable.getTableHeader();
        tableHeader.setFont(boldFont);

        // Set font for table cells
        propertyTable.setFont(regularFont);
        propertyTable.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(propertyTable);

        // Add components to the frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add action listener to search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchProperties();
            }
        });
    }

    private void searchProperties() {
        String city = cityTextField.getText().trim();
        if (city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a city name.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Clear previous search results
            tableModel.setRowCount(0);

            // Perform search using the controller
            List<Property> properties = controller.searchProperties(city);

            // Display results in the table
            for (Property property : properties) {
                tableModel.addRow(new Object[]{
                        property.getListingName(),
                        property.getAvgRatingLocalized(),
                        property.getDiscountedPrice(),
                        property.getOriginalPrice(),
                        property.getRoomTye()
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error fetching properties: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Assuming PropertySearchUseCase and AIRBNB classes are properly configured
        AIRBNB airbnbRepository = new AIRBNB();
        PropertySearchUseCase useCase = new PropertySearchUseCase(airbnbRepository);
        PropertyController controller = new PropertyController(useCase);

        // Launch the GUI
        SwingUtilities.invokeLater(() -> {
            PropertySearchGUI gui = new PropertySearchGUI(controller);
            gui.setVisible(true);
        });
    }
}
