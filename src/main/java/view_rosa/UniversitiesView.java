package view_rosa;
import entity_rosa.University;
import interface_adapter_rosa.universities.UniversitiesController;
import interface_adapter_rosa.universities.UniversitiesState;
import interface_adapter_rosa.universities.UniversitiesViewModel;
import entities.User;
import use_case_rosa.universities.FilterUniversities;
import use_case_rosa.universities.UniversitiesUserDataAccessInterface;


import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * The View for when the user wants to see the study abroad options.
 */

public class UniversitiesView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "StudyAbroadOptions";
    private final UniversitiesViewModel universitiesViewModel;
    private final UniversitiesUserDataAccessInterface userDataAccessInterface; //access user data through this interface

    // UI components
    private JTable table;
    private JButton selectButton;
    private UniversitiesController universitiesController; //connect controller later
    private User user; // the current user of the program


    public UniversitiesView(UniversitiesController controller, UniversitiesViewModel universitiesViewModel, UniversitiesUserDataAccessInterface userDataAccessInterface) {
        this.universitiesController = controller; // controller
        this.universitiesViewModel = universitiesViewModel;
        this.universitiesViewModel.addPropertyChangeListener(this);
        // initialize the current user
        this.userDataAccessInterface = userDataAccessInterface;
        // initialize the user
        currentUserHelper();

        // Create UI components
        final JLabel titleLabel = new JLabel("Study Abroad Options");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        selectButton = new JButton("Select University");
        buttons.add(selectButton);

//         action listener to the button
        selectButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(selectButton)) {
                            final UniversitiesState currentstate = universitiesViewModel.getState();
                            UniversitiesState.getInstance().setSelectedUniversityData(getSelectedRowData()); //ROSA TEST


                            universitiesController.execute(getSelectedRowData());
                            {
                            }
                        }
                    }
                }
        );

        // layout setup
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(buttons, BorderLayout.SOUTH);

//        // retrieve the filtered data
//        // TODO finish this and pass in the user as an argument
//        FilterUniversities filterUniversities = new FilterUniversities();
//        List<University> filteredData = filterUniversities.filterUniversities(user);

        // Initialize the table (will be populated later)
        createTable(); //pass empty data initially, will update later
    }

    // helper to get the current user and initialize it
    private void currentUserHelper() {
        String currentUsername = userDataAccessInterface.getCurrentUser();
        this.user = userDataAccessInterface.get(currentUsername);
    }

    public String getViewName() {
        return viewName;
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click" + evt.getActionCommand());
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
    public void createTable() {
        // retrieve the filtered data
        // TODO finish this and pass in the user as an argument
        FilterUniversities filterUniversities = new FilterUniversities();
        List<University> filteredData = filterUniversities.filterUniversities(user);

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

        // Populate table with university data using getters
        for (University university : filteredData) {
            tableModel.addRow(new Object[]{
                    university.getCountry(),
                    university.getCity(),
                    university.getUniversityName(),
                    university.getLanguage_of_study(),
                    university.getTuition(),
                    university.getAward(),
                    university.getMinimum_gpa()
            });
        }

            // Enable column resizing
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            // Adjust column widths to fit the content
            for (int i = 0; i < table.getColumnCount(); i++) {
                TableColumn column = table.getColumnModel().getColumn(i);
                int preferredWidth = 150; // Default width
                for (int row = 0; row < table.getRowCount(); row++) {
                    TableCellRenderer renderer = table.getCellRenderer(row, i);
                    Component comp = table.prepareRenderer(renderer, row, i);
                    preferredWidth = Math.max(comp.getPreferredSize().width + 10, preferredWidth); // Add some padding
                }
                column.setPreferredWidth(preferredWidth);
            }

            // Adjust row height to fit content
            table.setRowHeight(25);
            for (int row = 0; row < table.getRowCount(); row++) {
                int rowHeight = table.getRowHeight();
                for (int column = 0; column < table.getColumnCount(); column++) {
                    TableCellRenderer renderer = table.getCellRenderer(row, column);
                    Component comp = table.prepareRenderer(renderer, row, column);
                    rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
                }
                table.setRowHeight(row, rowHeight);
            }

            // Wrap table in scroll pane
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(800, 400)); // Adjust viewport size


            // sorting by university names alphabetically
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
            table.setRowSorter(sorter);
            sorter.setSortKeys(List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)));


            // disable sorting for other columns
            sorter.setSortable(1, false);
            sorter.setSortable(2, false);


            // customize table header colour to light blue and make header bold
            JTableHeader header = table.getTableHeader();
            header.setBackground(new Color(173, 216, 230));
            header.setOpaque(true);
            header.setFont(header.getFont().deriveFont(Font.BOLD));
            // set rest of the table colour to white
            table.setBackground(Color.WHITE);
            table.setOpaque(true);

            // Customize the button appearance
            selectButton.setBackground(new Color(128, 0, 128)); // Purple background
            selectButton.setForeground(Color.WHITE); // White text
            selectButton.setFocusPainted(false); // Remove focus border for a cleaner look
            selectButton.setFont(new Font("Arial", Font.BOLD, 14)); // Bold font for better visibility

            // add table and buttons to panel
            setLayout(new BorderLayout());
            add(scrollPane, BorderLayout.CENTER);
            add(selectButton, BorderLayout.SOUTH);
        }

//         Get selected row's data
        private University getSelectedRowData () {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Vector<?> rowVector = model.getDataVector().elementAt(table.convertRowIndexToModel(table.getSelectedRow()));

            // map the row data to a University
            University selectedUniversity = new University(
                    (String) rowVector.get(0), // country
                    (String) rowVector.get(1), // city
                    (String) rowVector.get(2), // uni name
                    (String) rowVector.get(3), // language of study
                    (String) rowVector.get(4), // tuition
                    (String) rowVector.get(5), // award
                    (String) rowVector.get(6) // min gpa needed
            );
            return selectedUniversity;
        }
    }


