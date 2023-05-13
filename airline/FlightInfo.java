package airline;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FlightInfo extends JFrame {
    private JTable flightTable;
    private List<Customer> customerList;

    public FlightInfo(List<Customer> customerList) {
        this.customerList = customerList;
        initComponents();
        populateTable(customerList);
    }
    

    // Add the constructor without parameters
    public FlightInfo() {
        this(new ArrayList<>()); // Calls the other constructor with an empty customer list
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Flight Information");
        setResizable(false);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        flightTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(flightTable);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JButton filterButton = new JButton("Filter by Flight Code");
        contentPane.add(filterButton, BorderLayout.SOUTH);

        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String flightCode = JOptionPane.showInputDialog(null, "Enter Flight Code:");
                if (flightCode != null) {
                    List<Customer> filteredList = filterCustomersByFlightCode(flightCode);
                    populateTable(filteredList);
                }
            }
        });

    }

    private void populateTable(List<Customer> customerList) {
        String[][] tableData = new String[customerList.size()][6];

        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            tableData[i][0] = customer.getPnrNo();
            tableData[i][1] = customer.getAddress();
            tableData[i][2] = customer.getNationality();
            tableData[i][3] = customer.getName();
            tableData[i][4] = customer.getGender();
            tableData[i][5] = customer.getFlightCode();
        }

        String[] columnHeaders = {"PNR No.", "Address", "Nationality", "Name", "Gender", "Flight Code"};

        flightTable.setModel(new javax.swing.table.DefaultTableModel(tableData, columnHeaders));
    }


    private List<Customer> filterCustomersByFlightCode(String flightCode) {
        List<Customer> filteredList = new ArrayList<>();

        for (Customer customer : customerList) {
            if (customer.getFlightCode().equalsIgnoreCase(flightCode)) {
                filteredList.add(customer);
            }
        }

        return filteredList;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AddCustomerDetails addCustomerDetails = new AddCustomerDetails();
                addCustomerDetails.setVisible(true);
                List<Customer> customerList = addCustomerDetails.getCustomerList();
                FlightInfo flightInfo = new FlightInfo(customerList);
                flightInfo.setVisible(true);
            }
        });
    }


    public static class Customer {
        private String pnrNo;
        private String address;
        private String nationality;
        private String name;
        private String gender;
        private String flightCode;

        public Customer(String pnrNo, String address, String nationality, String name, String gender, String flightCode) {
            this.pnrNo = pnrNo;
            this.address = address;
            this.nationality = nationality;
            this.name = name;
            this.gender = gender;
            this.flightCode = flightCode;
        }

        public String getPnrNo() {
            return pnrNo;
        }

        public String getAddress() {
            return address;
        }

        public String getNationality() {
            return nationality;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public String getFlightCode() {
            return flightCode;
        }
    }

    public static class AddCustomerDetails extends JFrame {
        private List<Customer> customerList;
        private JTextField pnrNoField;
        private JTextField addressField;
        private JTextField nationalityField;
        private JTextField nameField;
        private JComboBox<String> genderComboBox;
        private JTextField flightCodeField;

        public AddCustomerDetails() {
            customerList = new ArrayList<>();
            initComponents();
        }

        private void initComponents() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Add Customer Details");
            setResizable(false);
            setSize(400, 300);
            setLocationRelativeTo(null);

            JPanel contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
            setContentPane(contentPane);
            contentPane.setLayout(new GridLayout(7, 2, 5, 5));

            JLabel pnrNoLabel = new JLabel("PNR No.:");
            contentPane.add(pnrNoLabel);

            pnrNoField = new JTextField();
            contentPane.add(pnrNoField);

            JLabel addressLabel = new JLabel("Address:");
            contentPane.add(addressLabel);

            addressField = new JTextField();
            contentPane.add(addressField);

            JLabel nationalityLabel = new JLabel("Nationality:");
            contentPane.add(nationalityLabel);

            nationalityField = new JTextField();
            contentPane.add(nationalityField);

            JLabel nameLabel = new JLabel("Name:");
            contentPane.add(nameLabel);

            nameField = new JTextField();
            contentPane.add(nameField);

            JLabel genderLabel = new JLabel("Gender:");
            contentPane.add(genderLabel);

            genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
            contentPane.add(genderComboBox);

            JLabel flightCodeLabel = new JLabel("Flight Code:");
            contentPane.add(flightCodeLabel);

            flightCodeField = new JTextField();
            contentPane.add(flightCodeField);

            JButton addButton = new JButton("Add Customer");
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String pnrNo = pnrNoField.getText();
                    String address = addressField.getText();
                    String nationality = nationalityField.getText();
                    String name = nameField.getText();
                    String gender = (String) genderComboBox.getSelectedItem();
                    String flightCode = flightCodeField.getText();

                    Customer customer = new Customer(pnrNo, address, nationality, name, gender, flightCode);
                    customerList.add(customer);
                    clearFields();
                }
            });

            contentPane.add(addButton);
        }

        private void clearFields() {
            pnrNoField.setText("");
            addressField.setText("");
            nationalityField.setText("");
            nameField.setText("");
            genderComboBox.setSelectedIndex(0);
            flightCodeField.setText("");
        }

        public List<Customer> getCustomerList() {
            return customerList;
        }
    }
}
