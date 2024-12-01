package view;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapters.signup.SignupController;
import interface_adapters.signup.SignupState;
import interface_adapters.signup.SignupViewModel;
/**
 * The View for the Signup Use Case.
 */
public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final SignupController signupController;

    // New fields
    private final JTextField gpaInputField = new JTextField(5);
    private final JComboBox<String> programInputField = new JComboBox<>();
    private final JComboBox<String> degreeInputField = new JComboBox<>();
    private final JTextField languageInputField = new JTextField(20);
    private final JTextField emailInputField = new JTextField(20);

    private final JButton signUp;
    private final JButton toLogin;

    public SignupView(SignupController controller, SignupViewModel signupViewModel) {

        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        final LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.PASSWORD_LABEL), passwordInputField);
        final LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL), repeatPasswordInputField);

        // New fields
        final LabelTextPanel gpaInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.GPA_LABEL), gpaInputField);
        final LabelTextPanel degreeTypeInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.DEGREE_LABEL), degreeInputField);
        degreeInputField.addItem("Select degree");
        degreeInputField.addItem("Undergraduate");
        degreeInputField.addItem("Graduate");
        final LabelTextPanel programInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.PROGRAM_LABAEL), programInputField);
        String[] faculties = {
                "Select faculty",
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

        final LabelTextPanel languageInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.LANGUAGE_LABEL), languageInputField);
        final LabelTextPanel emailInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.EMAIL_LABEL), emailInputField);

        final JPanel buttons = new JPanel();
        toLogin = new JButton(SignupViewModel.TO_LOGIN_BUTTON_LABEL);
        buttons.add(toLogin);
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);

        signUp.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signUp)) {
                            final SignupState currentState = signupViewModel.getState();

                            signupController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getRepeatPassword(),
                                    currentState.getGpa(),
                                    currentState.getDegree(),
                                    currentState.getProgram(),
                                    currentState.getLanguage(),
                                    currentState.getEmail()
                            );
                        }
                    }
                }
        );

        toLogin.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        signupController.switchToLoginView();
                    }
                }
        );


        addUsernameListener();
        addPasswordListener();
        addRepeatPasswordListener();
        addGpaListener();
        addDegreeTypeListener();
        addProgramListener();
        addLanguageListener();
        addEmailListener();


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(gpaInfo);
        this.add(degreeTypeInfo);
        this.add(programInfo);
        this.add(languageInfo);
        this.add(emailInfo);
        this.add(buttons);
    }
    private void addLanguageListener() {
        languageInputField.getDocument().addDocumentListener(new DocumentListener() {
            private void documentListenerHelper(){
                final SignupState currentState = signupViewModel.getState();
                currentState.setLanguage(languageInputField.getText());
                signupViewModel.setState(currentState);
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
    }

    private void addGpaListener() {
        gpaInputField.getDocument().addDocumentListener(new DocumentListener() {
            private void documentListenerHelper(){
                final SignupState currentState = signupViewModel.getState();
                currentState.setGpa(gpaInputField.getText());
                signupViewModel.setState(currentState);
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
    }
    private void addEmailListener() {
        emailInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final SignupState currentState = signupViewModel.getState();
                currentState.setEmail(emailInputField.getText());
                signupViewModel.setState(currentState);
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
    }
    private void addDegreeTypeListener() {
        degreeInputField.addActionListener(e -> {
            // Get the currently selected item from the combo box
            final SignupState currentState = signupViewModel.getState();
            currentState.setDegree(degreeInputField.getSelectedItem().toString());
            signupViewModel.setState(currentState);
        });}
    private void addProgramListener() {
        programInputField.addActionListener(e -> {
            // Get the currently selected item from the combo box
            final SignupState currentState = signupViewModel.getState();
            currentState.setProgram(programInputField.getSelectedItem().toString());
            signupViewModel.setState(currentState);
        });}

    private void addUsernameListener() {
        usernameInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final SignupState currentState = signupViewModel.getState();
                currentState.setUsername(usernameInputField.getText());
                signupViewModel.setState(currentState);
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
    }

    private void addPasswordListener() {
        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final SignupState currentState = signupViewModel.getState();
                currentState.setPassword(new String(passwordInputField.getPassword()));
                signupViewModel.setState(currentState);
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
    }

    private void addRepeatPasswordListener() {
        repeatPasswordInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final SignupState currentState = signupViewModel.getState();
                currentState.setRepeatPassword(new String(repeatPasswordInputField.getPassword()));
                signupViewModel.setState(currentState);
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
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }

    public String getViewName() {
        return viewName;
    }
}
