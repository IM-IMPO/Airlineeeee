package airline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cancellation extends JFrame {
    private JTextField passengerNoTextField;
    private JTextField cancellationDateTextField;
    private JTextField flightCodeTextField;
    private JButton cancelButton;

    public Cancellation() {
        setTitle("Cancellation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 240, 240));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 10, 5, 10);

        // Passenger No. TextField
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Passenger No.:"), constraints);

        constraints.gridx = 1;
        passengerNoTextField = new JTextField(10);
        panel.add(passengerNoTextField, constraints);

        // Cancellation Date TextField
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Cancellation Date:"), constraints);

        constraints.gridx = 1;
        cancellationDateTextField = new JTextField(10);
        panel.add(cancellationDateTextField, constraints);

        // Flight Code TextField
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Flight Code:"), constraints);

        constraints.gridx = 1;
        flightCodeTextField = new JTextField(10);
        panel.add(flightCodeTextField, constraints);

        // Cancel Button
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(20, 0, 0, 0);
        cancelButton = new JButton("Cancel");
        panel.add(cancelButton, constraints);

        // Cancel button ActionListener
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform action when "Cancel" button is clicked
                String passengerNo = passengerNoTextField.getText();
                String cancellationDate = cancellationDateTextField.getText();
                String flightCode = flightCodeTextField.getText();
                // Add your logic here to handle the cancellation process
            }
        });

        add(panel);
        pack();
        setLocationRelativeTo(null);
    }
}
