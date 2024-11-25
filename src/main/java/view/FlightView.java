package view;

import entities.CommonFlight;
import entities.Flight;
import interface_adapters.flight.FlightController;
import interface_adapters.flight.FlightState;
import interface_adapters.flight.FlightViewModel;
import usecases.flight.FlightUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

public class FlightView extends JPanel {
    private final JTable flightTable;
    private final DefaultTableModel tableModel;
    private final FlightController controller;
    private final FlightViewModel viewModel;

    public FlightView(FlightController controller, FlightViewModel viewModel, String city) {
        this.controller = controller;
        this.viewModel = viewModel;

        setLayout(new BorderLayout());

        // Create and configure the table
        String[] columnNames = {"Departure Time", "Arrival Time", "Departure Airport", "Arrival Airport",
                "Flight Duration", "Layovers", "Price", "Select"};
        tableModel = new DefaultTableModel(columnNames, 0);
        flightTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 7; // Only the "Select" column is editable
            }
        };

        // Add custom button renderer and editor for the "Select" column
        flightTable.getColumn("Select").setCellRenderer(new ButtonRenderer());
        flightTable.getColumn("Select").setCellEditor(new ButtonEditor());

        flightTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        flightTable.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(flightTable);
        add(scrollPane, BorderLayout.CENTER);

        searchFlights(city);
    }

    private void searchFlights(String city) {
        try {
            controller.searchFlights(city);

            // Get sorted flights and update the table
            List<Flight> flights = FlightUtils.filterAndSortFlights(viewModel.getState().getFlights(), true);
            updateTable(flights);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Search failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable(List<Flight> flights) {
        // Clear the table
        tableModel.setRowCount(0);

        // Add rows for flights with valid prices
        for (Flight flight : flights) {
            tableModel.addRow(new Object[] {
                    flight.getDepartureTime(),
                    flight.getArrivalTime(),
                    flight.getDepartureAirport(),
                    flight.getArrivalAirport(),
                    flight.getFlightDuration(),
                    flight.getLayovers(),
                    flight.getPrice(),
                    "Select" // Button text
            });
        }
    }

    private void displayFlightDetails(Flight flight) {
        String message = "Departure Time: " + flight.getDepartureTime() + "\n" +
                "Arrival Time: " + flight.getArrivalTime() + "\n" +
                "Departure Airport: " + flight.getDepartureAirport() + "\n" +
                "Arrival Airport: " + flight.getArrivalAirport() + "\n" +
                "Flight Duration: " + flight.getFlightDuration() + "\n" +
                "Layovers: " + flight.getLayovers() + "\n" +
                "Price: " + flight.getPrice();
        JOptionPane.showMessageDialog(this, message, "Selected Flight", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Selected Flight Details:");
        System.out.println(message);
    }

    // Renderer for the "Select" column buttons
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

    // Editor for the "Select" column buttons
    private class ButtonEditor extends DefaultCellEditor {
        private final JButton button;
        private int row;

        public ButtonEditor() {
            super(new JCheckBox());
            button = new JButton("Select");
            button.addActionListener(e -> {
                // Fetch the flight details directly from the flightTable
                String departureTime = (String) tableModel.getValueAt(row, 0);
                String arrivalTime = (String) tableModel.getValueAt(row, 1);
                String departureAirport = (String) tableModel.getValueAt(row, 2);
                String arrivalAirport = (String) tableModel.getValueAt(row, 3);
                String flightDuration = (String) tableModel.getValueAt(row, 4);
                String layovers = (String) tableModel.getValueAt(row, 5);
                String price = (String) tableModel.getValueAt(row, 6);

                // Create a new flight instance
                Flight flight = new CommonFlight(departureTime, arrivalTime, departureAirport, arrivalAirport,
                        flightDuration, layovers, price);

                FlightState state = viewModel.getState();
                state.setSelectedFlight(flight);
                viewModel.setState(state);

                System.out.println("Selected Flight Saved: " + state.getSelectedFlight());

                controller.switchToDashboardView();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row; // Save the selected row index
            return button;
        }
    }
}
