package airline;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddCustomerDetails extends JFrame {
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
    

    public AddCustomerDetails(List<Customer> customerList2) {
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
    }
    


