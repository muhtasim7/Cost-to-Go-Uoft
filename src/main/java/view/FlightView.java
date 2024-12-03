package view;

import entities.CommonFlight;
import entities.Flight;
import interface_adapters.flight.FlightController;
import interface_adapters.flight.FlightSelectedCallback;
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
    private final FlightController flightcontroller;
    private final FlightViewModel viewModel;
    private final FlightSelectedCallback callback;

    public FlightView(FlightController controller, FlightViewModel viewModel, String city, FlightSelectedCallback callback) {
        this.flightcontroller = controller;
        this.viewModel = viewModel;
        this.callback = callback;
        setLayout(new BorderLayout());

        // Create and configure the table, I referred to code for PropertyView to help me out with the following code
        String[] columnNames = {"Departure Time", "Arrival Time", "Departure Airport", "Arrival Airport",
                "Flight Duration", "Price", "Select"};
        tableModel = new DefaultTableModel(columnNames, 0);
        flightTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }
        };

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
            flightcontroller.searchFlights(city);

            // Get sorted flights and update the table
            List<Flight> flights = FlightUtils.filterAndSortFlights(viewModel.getState().getFlights(), true);
            updateTable(flights);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Search failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable(List<Flight> flights) {
        tableModel.setRowCount(0);

        // Add rows for flights with valid prices
        for (Flight flight : flights) {
            tableModel.addRow(new Object[] {
                    flight.getDepartureTime(),
                    flight.getArrivalTime(),
                    flight.getDepartureAirport(),
                    flight.getArrivalAirport(),
                    flight.getFlightDuration(),
                    flight.getPrice(),
                    "Select"
            });
        }
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
                // Fetch flight details from flightTable
                String departureTime = (String) tableModel.getValueAt(row, 0);
                String arrivalTime = (String) tableModel.getValueAt(row, 1);
                String departureAirport = (String) tableModel.getValueAt(row, 2);
                String arrivalAirport = (String) tableModel.getValueAt(row, 3);
                String flightDuration = (String) tableModel.getValueAt(row, 4);
                String price = (String) tableModel.getValueAt(row, 5);

                // Create a new flight instance
                Flight flight = new CommonFlight(departureTime, arrivalTime, departureAirport, arrivalAirport,
                        flightDuration, price);

                if (callback != null){
                    callback.onFlightSelected(flight);
                }
//                FlightState state = viewModel.getState();
//                state.setSelectedFlight(flight);
//                viewModel.setState(state);
//
//                System.out.println("Selected Flight Saved: " + state.getSelectedFlight());

                flightcontroller.switchToDashboardView();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            return button;
        }
    }
}
