package interface_adapters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailItinerary extends JFrame {
    public EmailItinerary() {
        setTitle("Email Yourself Your Itinerary!");

        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel emailPanel = createEmailPanel();
        mainPanel.add(emailPanel);

        add(new JScrollPane(mainPanel));
    }

    Font regularFont = new Font("Apple LiGothic", Font.PLAIN, 20);
    Color blue = new Color(159, 224, 229);

    private JPanel createEmailPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.setBackground(blue);

        JLabel promptLabel = new JLabel("Enter your email to get a copy of your itinerary!");
        promptLabel.setFont(new Font("Apple LiGothic", Font.PLAIN, 20));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setBackground(blue);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(regularFont);

        JTextField emailTextField = new JTextField(20);
        emailTextField.setFont(regularFont);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(regularFont);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                if (isValidEmail(email)) {
                    JOptionPane.showMessageDialog(panel, "Your itinerary will be emailed to " + email + "!");
                    // Add code here to handle the email submission !!!
                } else {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        inputPanel.add(emailLabel);
        inputPanel.add(emailTextField);

        panel.add(promptLabel);
        panel.add(inputPanel);
        panel.add(submitButton);

        return panel;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmailItinerary frame = new EmailItinerary();
            frame.setVisible(true);
        });
    }
}