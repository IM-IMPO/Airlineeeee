package airline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private JMenuBar menuBar;
    private JMenu airlineSystemMenu;
    private JMenuItem flightInfoItem;
    private JMenuItem addCustomerDetailsItem;
    private JMenuItem journeyDetailsItem;
    private JMenuItem paymentDetailsItem;
    private JMenuItem cancellationItem;
    private JButton logoutButton;

    public MainFrame() {
        // Set up the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Airline System");

        // Create the menu bar
        menuBar = new JMenuBar();

        // Create the "Airline System" menu
        airlineSystemMenu = new JMenu("Airline System");
        airlineSystemMenu.setFont(new Font("Arial", Font.BOLD, 14));
        airlineSystemMenu.setForeground(Color.BLUE);

        // Create the menu items
        flightInfoItem = new JMenuItem("Flight Info");
        addCustomerDetailsItem = new JMenuItem("Add Customer Details");
        journeyDetailsItem = new JMenuItem("Journey Details");
        paymentDetailsItem = new JMenuItem("Payment Details");
        cancellationItem = new JMenuItem("Cancellation");

        // Add action listeners to the menu items
        flightInfoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        FlightInfo flightInfo = new FlightInfo();
                        flightInfo.setVisible(true);
                    }
                });
            }
        });

        addCustomerDetailsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        AddCustomerDetails addCustomerDetails = new AddCustomerDetails();
                        addCustomerDetails.setVisible(true);
                    }
                });
            }
        });

        journeyDetailsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JourneyDetails journeyDetails = new JourneyDetails();
                        journeyDetails.setVisible(true);
                    }
                });
            }
        });

        paymentDetailsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        PaymentDetails paymentDetails = new PaymentDetails();
                        paymentDetails.setVisible(true);
                    }
                });
            }
        });

        cancellationItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        Cancellation cancellation = new Cancellation();
                        cancellation.setVisible(true);
                    }
                });
            }
        });

        // Add the menu items to the "Airline System" menu
        airlineSystemMenu.add(flightInfoItem);
        airlineSystemMenu.add(addCustomerDetailsItem);
        airlineSystemMenu.add(journeyDetailsItem);
        airlineSystemMenu.add(paymentDetailsItem);
        airlineSystemMenu.add(cancellationItem);

        // Add the "Airline System" menu to the menu bar
        menuBar.add(airlineSystemMenu);

        // Create the logout button
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the LoginFrame and close the MainFrame
                dispose(); // Close the MainFrame
                new LoginFrame().setVisible(true); // Open the LoginFrame
            }
        });

        logoutButton.setBackground(new Color(204, 0, 0));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Create a Box container with horizontal layout
        Box rightBox = Box.createHorizontalBox();
        rightBox.add(Box.createHorizontalGlue()); // Add horizontal glue to push the logout button to the right
        rightBox.add(logoutButton);

        // Add the Box container to the menu bar
        menuBar.add(Box.createHorizontalStrut(10)); // Add spacing
        menuBar.add(rightBox);

        // Set the menu bar for the JFrame
        setJMenuBar(menuBar);

        // Display the JFrame
        setSize(800, 600); // Set the size of the JFrame to a medium size
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
