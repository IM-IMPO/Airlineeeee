package airline;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JourneyDetails.java (inside JourneyDetails package or same package as AirlineData)
 // Replace with your package name or adjust accordingly



public class JourneyDetails extends JFrame {
    private JComboBox<String> sourceComboBox;
    private JComboBox<String> destinationComboBox;
    private JButton showButton;
    private JTable journeyTable;
    

    public JourneyDetails() {
        setTitle("Journey Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(new BorderLayout());

        initializeComponents();
        addEventListeners();
        buildLayout();

        // Set the frame to fullscreen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    

    private void initializeComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 10, 5, 10);

        // Source ComboBox
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Source:"), constraints);

        constraints.gridx = 1;
        sourceComboBox = new JComboBox<>(new String[]{"Source 1", "Source 2", "Source 3"}); // Replace with your data
        panel.add(sourceComboBox, constraints);

        // Destination ComboBox
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Destination:"), constraints);

        constraints.gridx = 1;
        destinationComboBox = new JComboBox<>(new String[]{"Destination 1", "Destination 2", "Destination 3"}); // Replace with your data
        panel.add(destinationComboBox, constraints);

        // Show Button
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(20, 0, 0, 0);
        showButton = new JButton("Show");
        panel.add(showButton, constraints);

        // Journey Table
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH; // Stretch horizontally and vertically
        journeyTable = new JTable(new String[][]{{"PNR1", "Ticket1", "Time1", "Source1", "Destination1"}, {"PNR2", "Ticket2", "Time2", "Source2", "Destination2"}}, new String[]{"PNR No.", "Ticket ID", "Journey Time", "Source", "Destination"}); // Replace with your data
        JScrollPane scrollPane = new JScrollPane(journeyTable);
        panel.add(scrollPane, constraints);

        add(panel, BorderLayout.CENTER);
    }

    private void addEventListeners() {
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform action when "Show" button is clicked
                String source = (String) sourceComboBox.getSelectedItem();
                String destination = (String) destinationComboBox.getSelectedItem();
                // Add your logic here to display journey details based on the selected source and destination
            }
        });
    }

    private void buildLayout() {
        // Set the layout manager of the content pane to BorderLayout
        getContentPane().setLayout(new BorderLayout());
    
        // Create a JPanel for the source and destination components
        JPanel sourceDestPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 10, 5, 10);
    
        // Source ComboBox
        constraints.gridx = 0;
        constraints.gridy = 0;
        sourceDestPanel.add(new JLabel("Source:"), constraints);
    
        constraints.gridx = 1;
        constraints.weightx = 0.5; // Set equal weight for horizontal resizing
        constraints.fill = GridBagConstraints.HORIZONTAL; // Allow horizontal resizing
        sourceDestPanel.add(sourceComboBox, constraints);
    
        // Destination ComboBox
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0; // Reset weight for destination ComboBox
        constraints.fill = GridBagConstraints.NONE; // Disable horizontal resizing
        sourceDestPanel.add(new JLabel("Destination:"), constraints);
    
        constraints.gridx = 1;
        constraints.weightx = 0.5; // Set equal weight for horizontal resizing
        constraints.fill = GridBagConstraints.HORIZONTAL; // Allow horizontal resizing
        sourceDestPanel.add(destinationComboBox, constraints);
    
        // Show Button
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.weightx = 0; // Reset weight for the showButton
        constraints.insets = new Insets(5, 10, 5, 10);
        sourceDestPanel.add(showButton, constraints);
    
        // Create a JScrollPane for the journey table
        JScrollPane scrollPane = new JScrollPane(journeyTable);
    
        // Add the source and destination panel to the North region of the content pane
        getContentPane().add(sourceDestPanel, BorderLayout.NORTH);
    
        // Add the scroll pane to the center of the content pane with BorderLayout.CENTER
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
    

    // Other methods, if any

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JourneyDetails journeyDetails = new JourneyDetails();
                journeyDetails.setVisible(true);
            }
        });
    }
}
