package view;

import entities.CommonProperty;
import entities.Property;
import interface_adapters.property.PropertyController;
import interface_adapters.property.PropertySelectedCallback;

import interface_adapters.property.PropertyState;
import interface_adapters.property.PropertyViewModel;
import usecases.property.PropertyUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

public class PropertyView extends JPanel {
    private final JTable propertyTable;
    private final DefaultTableModel tableModel;
    private final PropertyController controller;
    private final PropertyViewModel viewModel;
    private final PropertySelectedCallback callback;

    public PropertyView(PropertyController controller, PropertyViewModel viewModel, String city, PropertySelectedCallback callback) {
        this.controller = controller;
        this.viewModel = viewModel;
        this.callback = callback;

        setLayout(new BorderLayout());
        String[] columnNames = {"Name", "Rating", "Discounted Price", "Original Price", "Room Type", "Select"};
        tableModel = new DefaultTableModel(columnNames, 0);
        propertyTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5; // Only the "Select" column is editable
            }
        };

        // Add custom button renderer and editor for the "Select" column
        propertyTable.getColumn("Select").setCellRenderer(new ButtonRenderer());
        propertyTable.getColumn("Select").setCellEditor(new ButtonEditor());

        propertyTable.setFont(new Font("Apple LiGothic", Font.PLAIN, 20));
        propertyTable.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(propertyTable);
        add(scrollPane, BorderLayout.CENTER);

        // Automatically trigger the search
        searchProperties(city);
    }

    private void searchProperties(String city) {
        try {
            controller.searchProperties(city);

            // Get sorted properties and update the table
            List<Property> properties = PropertyUtils.filterAndSortProperties(viewModel.getState().getProperties(), true);
            updateTable(properties);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Search failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable(List<Property> properties) {
        // Clear the table
        tableModel.setRowCount(0);

        // Add rows for properties with valid prices
        for (Property property : properties) {
            tableModel.addRow(new Object[]{
                    property.getName(),
                    property.getRating(),
                    property.getDiscountedPrice().equals("N/A") ? "N/A" : property.getDiscountedPrice(),
                    property.getOriginalPrice().equals("N/A") ? "N/A" : property.getOriginalPrice(),
                    property.getRoomType(),
                    "Select" // Button text
            });
        }
    }
    private class ButtonEditor extends DefaultCellEditor {
        private final JButton button;
        private int row;

        public ButtonEditor() {
            super(new JCheckBox());
            button = new JButton("Select");
            button.addActionListener(e -> {

                // Fetch the property details directly from the propertyTable
                String name = (String) tableModel.getValueAt(row, 0);
                String rating = (String) tableModel.getValueAt(row, 1);
                String discountedPrice = (String) tableModel.getValueAt(row, 2);
                String originalPrice = (String) tableModel.getValueAt(row, 3);
                String roomType = (String) tableModel.getValueAt(row, 4);

                Property property = new CommonProperty(name, rating, discountedPrice, originalPrice, roomType);

                // Notify parent component of the selected property
                if (callback != null) {
                    callback.onPropertySelected(property);
                }


                controller.switchToDashboardView();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            return button;
        }
    }

    private static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setText("Select");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            return this;
        }
    }
}