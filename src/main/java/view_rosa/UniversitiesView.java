package view_rosa;
import interface_adapter_rosa.universities.UniversitiesController;
import interface_adapter_rosa.universities.UniversitiesViewModel;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * The View for when the user wants to see the study abroad options.
 */

public class UniversitiesView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "StudyAbroadOptions";
    private final UniversitiesViewModel universitiesViewModel;

    // UI components
    private JTable table;
    private JButton selectButton;

    private UniversitiesController universitiesController; //connect controller later

    // to track selected row index
    private int selectedRow = -1;

    public UniversitiesView(UniversitiesViewModel universitiesViewModel) {
        this.universitiesViewModel = universitiesViewModel;
        this.universitiesViewModel.addPropertyChangeListener(this);

        // Create UI components
        final JLabel titleLabel = new JLabel("Study Abroad Options");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        selectButton = new JButton("Select University");
        buttons.add(selectButton);

        // action listener to the button
        selectButton.addActionListener(this);

        // layout setup
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);

        // Initialize the table (will be populated later)
        createTable(List.of()); //pass empty data initially, will update later
    }
    public String getViewName() {
        return viewName;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectButton) {
            // when "select" button is pressed, pass the selected row to the view model
            if (selectedRow != -1) {
                Object[] selectedData = getSelectedRowData(selectedRow);
                universitiesViewModel.selectUniversity(selectedData);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a University first");
            }
        }
    }
    public void propertyChange(PropertyChangeEvent evt) {
        // This listens for changes in the state of the view model (ex. selected uni)
        if ("selectedUniversity".equals(evt.getPropertyName())) {
            Object[] selectedUniversity = (Object[]) evt.getNewValue();
            // here do UI updates like changing the button test, highlighting the row, etc
            System.out.println("Selected University: " + selectedUniversity[2]); // assuming index 2 is university
        }
    }
    // create table by university data
    public void createTable(List<Object[]> data) {
        // create column names
        String[] columnNames = {"Country", "City", "University", "Language of Study", "Tuition", "Award", "Min GPA"};


        // set up table model and JTable
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { // dont let users edit table
                return false;
            }
        };
        table = new JTable(tableModel);


        // populate table with data
        for (Object[] rowData : data) {
            tableModel.addRow(rowData);
        }
        // set column widths, scrolling, and look
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(table);


        // sorting by university names alphabetically
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);
        sorter.setSortKeys(List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)));


        // disable sorting for other columns
        sorter.setSortable(1, false);
        sorter.setSortable(2, false);


        // customize table header colour to light blue and make header bold
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(173,216,230));
        header.setOpaque(true);
        header.setFont(header.getFont().deriveFont(Font.BOLD));
        // set rest of the table colour to light pink
        table.setBackground(new Color(255,240,245));
        table.setOpaque(true);


        // add table and buttons to panel
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(selectButton, BorderLayout.SOUTH);

    }
    // Get selected row's data
    private Object[] getSelectedRowData(int rowIndex) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] rowData = new Object[model.getColumnCount()];
        for (int i = 0; i < model.getColumnCount(); i++) {
            rowData[i] = model.getValueAt(rowIndex, i);
        }
        return rowData;
    }

    // Listen for row selection in the table (used to track selected row)
    public void setTableSelectionListener() {
        table.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting()) {
                selectedRow = table.getSelectedRow();  // Track the selected row
            }
        });
    }


    public static void main(String[] args) {
        // sample data
        List<Object[]> data = List.of(
                new Object[] {"Country A", "City A", "University A", "French", "Paid to uni", "Award: whatever", "3.0"},
                new Object[] {"Country A", "City A", "University A", "French", "Paid to uni", "Award: whatever", "3.0"},
                new Object[] {"Country C", "City C", "University C", "French, English", "Paid to uni", "Award: whatever", "2.5"},
                new Object[] {"Country C", "City C", "University C", "French, English", "Paid to uni", "Award: whatever", "2.5"},
                new Object[] {"Country C", "City C", "University C", "French, English", "Paid to uni", "Award: whatever", "2.5"},
                new Object[] {"Country C", "City C", "University C", "French, English", "Paid to uni", "Award: whatever", "2.5"},
                new Object[] {"Country C", "City C", "University C", "French, English", "Paid to uni", "Award: whatever", "2.5"},
                new Object[] {"Country A", "City A", "University A", "French", "Paid to uni", "Award: whatever", "3.0"},
                new Object[] {"Country A", "City A", "University A", "French", "Paid to uni", "Award: whatever", "3.0"},
                new Object[] {"Country A", "City A", "University A", "French", "Paid to uni", "Award: whatever", "3.0"},
                new Object[] {"Country A", "City A", "University A", "French", "Paid to uni", "Award: whatever", "3.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country A", "City A", "University A", "French", "Paid to uni", "Award: whatever", "3.0"},
                new Object[] {"Country A", "City A", "University A", "French", "Paid to uni", "Award: whatever", "3.0"},
                new Object[] {"Country A", "City A", "University A", "French", "Paid to uni", "Award: whatever", "3.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"},
                new Object[] {"Country B", "City B", "University B", "Spanish, English", "Paid to uni", "Award: whatever", "4.0"}

        );
        // Create the view model and pass it to the view
        UniversitiesViewModel viewModel = new UniversitiesViewModel();
        UniversitiesView view = new UniversitiesView(viewModel);
        view.createTable(data); // Pass data to the table once

        // Set up frame
        JFrame frame = new JFrame("Study Abroad Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
