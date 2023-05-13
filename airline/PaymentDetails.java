package airline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentDetails extends JFrame {
    private JTextField pnrNoTextField;
    private JButton showButton;
    private JTable paymentTable;

    public PaymentDetails() {
        setTitle("Payment Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // PNR No. TextField
        JLabel pnrNoLabel = new JLabel("PNR No.:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.1;
        panel.add(pnrNoLabel, constraints);

        pnrNoTextField = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.3;
        panel.add(pnrNoTextField, constraints);

        // Show Button
        showButton = new JButton("Show");
        showButton.setPreferredSize(new Dimension(80, 30));
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 0.1;
        constraints.insets = new Insets(10, 10, 10, 0);
        panel.add(showButton, constraints);

        // Show button ActionListener
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform action when "Show" button is clicked
                String pnrNo = pnrNoTextField.getText();
                // Add your logic here to display payment details based on the entered PNR No.
            }
        });

        add(panel, BorderLayout.NORTH);

        // Payment Table
        paymentTable = new JTable(new String[][]{{"PNR001", "1000", "2023-05-01", "123456", "************1234", "9876543210"}, {"PNR002", "2000", "2023-05-02", "789012", "************5678", "0123456789"}}, new String[]{"PNR No.", "Paid Amount", "Payment Date", "Cheque No.", "Card No.", "Phone No."});
        paymentTable.setGridColor(Color.GRAY);
        paymentTable.setSelectionBackground(new Color(200, 220, 240));
        JScrollPane scrollPane = new JScrollPane(paymentTable);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);

        // Set the frame to fullscreen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
