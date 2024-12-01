package view;

import interface_adapters.logged_in.ChangePasswordController;
import interface_adapters.logged_in.LoggedInState;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.signup.SignupState;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final JLabel passwordErrorField = new JLabel();
    private final ChangePasswordController changePasswordController;

    private final JLabel username;

    private final JButton logOut;
    private final JButton goBackButton;

    private final JTextField passwordInputField = new JTextField(15);
    private final JTextField gpaInputField = new JTextField(15);
    private final JComboBox<String> degreeInputField = new JComboBox<>();
    private final JComboBox<String> programInputField = new JComboBox<>();
    private final JTextField languageInputField = new JTextField(15);
    private final JTextField emailInputField = new JTextField(15);
    private final JButton changePassword;

    public LoggedInView(LoggedInViewModel loggedInViewModel, ChangePasswordController changePasswordController) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);
        this.changePasswordController = changePasswordController;

        final JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), passwordInputField);
        final LabelTextPanel gpaInfo = new LabelTextPanel(
                new JLabel("GPA"), gpaInputField);
        final LabelTextPanel degreeInfo = new LabelTextPanel(new JLabel("Degree"), degreeInputField);
        degreeInputField.addItem("Select degree");
        degreeInputField.addItem("Undergrad");
        degreeInputField.addItem("Graduate");
        final LabelTextPanel programInfo = new LabelTextPanel(new JLabel("Program"), programInputField);
        String[] faculties = {
                "Select your faculty",
                "Applied Science and Engineering",
                "Arts and Science (St. George)",
                "Arts and Science (UTM)",
                "Arts and Science (UTSC)",
                "Faculty of Information",
                "Faculty of Law",
                "Faculty of Music",
                "John H. Daniels Faculty of Architecture, Landscape and Design",
                "Kinesiology and Physical Education",
                "Leslie Dan Faculty of Pharmacy",
                "Ontario Institute for Studies in Education",
                "Rotman Commerce",
                "School of Graduate Studies"

        };

        for (String faculty : faculties) {
            programInputField.addItem(faculty);
        }
        final LabelTextPanel languageInfo = new LabelTextPanel(new JLabel("Language"), languageInputField);
        final LabelTextPanel emailInfo = new LabelTextPanel(new JLabel("Email"), emailInputField);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        logOut = new JButton("Log Out");
        buttons.add(logOut);

        changePassword = new JButton("Change information");
        buttons.add(changePassword);

        goBackButton = new JButton("Back");
        buttons.add(goBackButton);


        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                changePasswordController.switchToLogInView();
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));



        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoggedInState currentState = loggedInViewModel.getState();
                currentState.setPassword(passwordInputField.getText());
                loggedInViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });



        gpaInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoggedInState currentState = loggedInViewModel.getState();
                    currentState.setGpa(gpaInputField.getText());
                    loggedInViewModel.setState(currentState);

            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

            degreeInputField.addActionListener(e -> {
                // Get the currently selected item from the combo box
                final LoggedInState currentState = loggedInViewModel.getState();
                currentState.setDegree(degreeInputField.getSelectedItem().toString());
                loggedInViewModel.setState(currentState);
            });

            programInputField.addActionListener(e -> {
                // Get the currently selected item from the combo box
                final LoggedInState currentState = loggedInViewModel.getState();
                currentState.setProgram(programInputField.getSelectedItem().toString());
                loggedInViewModel.setState(currentState);
            });
        languageInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoggedInState currentState = loggedInViewModel.getState();
                currentState.setLanguage(languageInputField.getText());
                loggedInViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
        emailInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoggedInState currentState = loggedInViewModel.getState();
                currentState.setEmail(emailInputField.getText());
                loggedInViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        changePassword.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(changePassword)) {
                        final LoggedInState currentState = loggedInViewModel.getState();

                        this.changePasswordController.execute(
                                currentState.getUsername(),
                                currentState.getPassword(),
                                currentState.getGpa(),
                                currentState.getDegree(),
                                currentState.getProgram(),
                                currentState.getLanguage(),
                                currentState.getEmail()
                        );
                    }
                }
        );
        goBackButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        changePasswordController.switchToDashboardView();
                    }
                }
        );


        this.add(title);
        this.add(usernameInfo);
        this.add(username);

        this.add(passwordInfo);
        this.add(passwordErrorField);
        this.add(gpaInfo);
        this.add(degreeInfo);
        this.add(programInfo);
        this.add(languageInfo);
        this.add(emailInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
        }
        else if (evt.getPropertyName().equals("password")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "Information updated for " + state.getUsername());
        }

    }

    public String getViewName() {
        return viewName;
    }
}
