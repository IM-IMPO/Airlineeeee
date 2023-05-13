package airline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));
        add(mainPanel);

        // Username field
        JPanel usernamePanel = new JPanel();
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        mainPanel.add(usernamePanel);

        // Password field
        JPanel passwordPanel = new JPanel();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        mainPanel.add(passwordPanel);

        // Login button
        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        buttonPanel.add(loginButton);
        mainPanel.add(buttonPanel);

        // Login button action listener
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Perform login authentication here
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login Successful!");
                    dispose(); // Close the login frame
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new MainFrame().setVisible(true); // Open the main frame
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}
