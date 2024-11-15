package view_sim;

import data_access_sim.AIRBNB;
import entities.Property;
import interface_adapters_sim.property.PropertyController;
import interface_adapters_sim.property.PropertySearchPresenter;
import usecases_sim.property.PropertySearchUseCase;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class PropertySearchGUI extends JFrame {
    private final Font regularFont = new Font("Apple LiGothic", Font.PLAIN, 20);
    private final Font boldFont = new Font("Apple LiGothic", Font.BOLD, 30);

    private JTextField cityTextField;
    private JButton searchButton;
    private JComboBox<String> sortDropdown;
    private JTable propertyTable;
    private DefaultTableModel tableModel;
    private PropertyController controller;
    private PropertySearchPresenter presenter;

    public PropertySearchGUI(PropertyController controller, PropertySearchPresenter presenter) {
        this.controller = controller;
        this.presenter = presenter;
        setTitle("Property Search");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with custom color
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(190, 211, 115));  // Light green background color

        // Create the input panel with custom styling
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(159, 224, 229));  // Light blue background color
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setFont(boldFont);
        inputPanel.add(cityLabel);

        cityTextField = new JTextField(15);
        cityTextField.setFont(regularFont);
        inputPanel.add(cityTextField);

        searchButton = new JButton("Search");
        searchButton.setFont(boldFont);
        inputPanel.add(searchButton);

        // Create a dropdown for sorting options
        String[] sortOptions = {"Sort by Price (High to Low)", "Sort by Price (Low to High)"};
        sortDropdown = new JComboBox<>(sortOptions);
        sortDropdown.setFont(regularFont);
        inputPanel.add(sortDropdown);

        // Create the table to display properties
        String[] columnNames = {"Name", "Rating", "Discounted Price", "Original Price", "Room Type"};
        tableModel = new DefaultTableModel(columnNames, 0);
        propertyTable = new JTable(tableModel);
        propertyTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Enable single row selection

        // Set up presenter with table model
        presenter.setTableModel(tableModel);

        // Style the table header
        JTableHeader tableHeader = propertyTable.getTableHeader();
        tableHeader.setFont(boldFont);
        tableHeader.setBackground(new Color(235, 194, 235));  // Light purple background color for header

        // Set font and row height for table cells
        propertyTable.setFont(regularFont);
        propertyTable.setRowHeight(25);

        // Set alternating row colors
        propertyTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(255, 245, 235));  // Light beige for alternate rows
                }
                return c;
            }
        });

        JScrollPane scrollPane = new JScrollPane(propertyTable);

        // Add components to the main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Add action listeners
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchProperties();
            }
        });

        sortDropdown.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (sortDropdown.getSelectedIndex() == 0) {
                    // High to Low
                    presenter.sortPropertiesByPrice(false);
                } else {
                    // Low to High
                    presenter.sortPropertiesByPrice(true);
                }
            }
        });

        // Add mouse listener for row selection
        propertyTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {  // Double-click to select
                    int selectedRow = propertyTable.getSelectedRow();
                    if (selectedRow >= 0) {
                        Map<String, String> propertyDetails = getSelectedPropertyDetails(selectedRow);
                        showPropertyDetails(propertyDetails);
                        // Here, you can call another function to use the propertyDetails map.
                    }
                }
            }
        });

        // Add main panel to frame
        add(mainPanel);
    }

    private void searchProperties() {
        String city = cityTextField.getText().trim();
        if (city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a city name.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Perform search using the controller
        controller.searchProperties(city);
    }

    /**
     * Retrieves the details of the selected property as a Map.
     * @param rowIndex Index of the selected row in the table.
     * @return Map<String, String> containing property details.
     */
    private Map<String, String> getSelectedPropertyDetails(int rowIndex) {
        Map<String, String> propertyDetails = new HashMap<>();
        propertyDetails.put("Name", (String) tableModel.getValueAt(rowIndex, 0));
        propertyDetails.put("Rating", (String) tableModel.getValueAt(rowIndex, 1));
        propertyDetails.put("Discount", (String) tableModel.getValueAt(rowIndex, 2));
        propertyDetails.put("Original", (String) tableModel.getValueAt(rowIndex, 3));
        propertyDetails.put("Room Type", (String) tableModel.getValueAt(rowIndex, 4));
        return propertyDetails;
    }

    /**
     * Displays a dialog with the details of the selected property.
     * @param propertyDetails Map containing the property details to display.
     */
    private void showPropertyDetails(Map<String, String> propertyDetails) {
        String message = "Name: " + propertyDetails.get("Name") +
                "\nRating: " + propertyDetails.get("Rating") +
                "\nDiscount: " + propertyDetails.get("Discount") +
                "\nOriginal: " + propertyDetails.get("Original") +
                "\nRoom Type: " + propertyDetails.get("Room Type");

        JOptionPane.showMessageDialog(this, message, "Property Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        AIRBNB airbnbRepository = new AIRBNB();
        PropertySearchUseCase useCase = new PropertySearchUseCase(airbnbRepository);
        PropertySearchPresenter presenter = new PropertySearchPresenter();
        PropertyController controller = new PropertyController(useCase, presenter);

        SwingUtilities.invokeLater(() -> {
            PropertySearchGUI gui = new PropertySearchGUI(controller, presenter);
            gui.setVisible(true);
        });
    }
}
