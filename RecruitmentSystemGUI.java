//importing packages 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Creating class for GUI
public class RecruitmentSystemGUI extends JFrame {
    private JPanel staffHiringPanel;
    private JPanel viewStaff;
    private JComboBox<String> jobTypeCombo;
    private GridBagConstraints gbc;
    private JPanel dynamicFieldsPanel;

    // Form fields
    private JTextField vacancyNumberField, designationField, staffNameField;
    private JTextField joiningDateField, qualificationField, appointedByField;
    private JCheckBox statusCheckbox;
    private JTextField displayField;

    // Dynamic fields
    private JTextField workingHoursField, wagesPerHourField, shiftsField;
    private JTextField salaryField, weeklyHoursField;
    private JButton terminateButton;

    // Buttons
    private JButton addFullTimeButton, addPartTimeButton;
    private JButton setSalaryButton, setShiftsButton, clearButton, displayButton;

    // Data storage
    private ArrayList<StaffHire> staffList = new ArrayList<>();
    
// GUI class constructor 
    public RecruitmentSystemGUI() {
        setTitle("Staff Recruitment System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
        setupMainPanel();
    }
//Method initialising all the components needed for making the GUI
    private void initializeComponents() {
        // Initialize all form fields
        vacancyNumberField = new JTextField(20);
        designationField = new JTextField(20);
        staffNameField = new JTextField(20);
        joiningDateField = new JTextField(20);
        qualificationField = new JTextField(20);
        appointedByField = new JTextField(20);
        displayField = new JTextField(20);
        statusCheckbox = new JCheckBox("Has Joined?");

        // Initialize dynamic fields
        workingHoursField = new JTextField(15);
        wagesPerHourField = new JTextField(15);
        shiftsField = new JTextField(15);
        salaryField = new JTextField(15);
        weeklyHoursField = new JTextField(15);
        terminateButton = new JButton("Terminate");

        // Initialize buttons
        addFullTimeButton = new JButton("Add Full Time Staff");
        addPartTimeButton = new JButton("Add Part Time Staff");
        setSalaryButton = new JButton("Set Salary");
        setShiftsButton = new JButton("Set Shifts");
        clearButton = new JButton("Clear");
        displayButton = new JButton("Display Staff");
    }
    
    //Method for creating the MainPanel of the GUI

    private void setupMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Staff Recruitment System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        staffHiringPanel = createStaffHiringPanel();
        viewStaff = createViewStaffPanel();
        tabbedPane.addTab("Staff Hiring", staffHiringPanel);
        tabbedPane.addTab("View Staff", viewStaff); // You can implement this later

        mainPanel.add(tabbedPane, BorderLayout.CENTER);
        add(mainPanel);

        setupButtonActions();
    }
  
// Method to create StaffHiring Panel in which the user can save Part-Time and Full-time
//staff members 

    private JPanel createStaffHiringPanel() {
        //Creating the layout
        JPanel panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Job Type selection
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Job Type:"), gbc);

        gbc.gridx = 1;
        jobTypeCombo = new JComboBox<>(new String[]{"Part-Time", "Full-Time"});
        jobTypeCombo.addActionListener(new JobTypeChangeListener());
        panel.add(jobTypeCombo, gbc);

        // Standard fields
        addFormField(panel, "Vacancy Number:", vacancyNumberField, 1);
        addFormField(panel, "Designation:", designationField, 2);
        addFormField(panel, "Staff Name:", staffNameField, 3);
        addFormField(panel, "Joining Date (yyyy-MM-dd):", joiningDateField, 4);
        addFormField(panel, "Qualification:", qualificationField, 5);
        addFormField(panel, "Appointed By:", appointedByField, 6);

        // Status field
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        panel.add(statusCheckbox, gbc);

        // Panel for dynamic fields
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        dynamicFieldsPanel = new JPanel();
        dynamicFieldsPanel.setLayout(new GridBagLayout());
        panel.add(dynamicFieldsPanel, gbc);

        // Initialize with fields based on default selection
        updateDynamicFields();

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(addFullTimeButton);
        buttonPanel.add(addPartTimeButton);
        buttonPanel.add(setSalaryButton);
        buttonPanel.add(setShiftsButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(buttonPanel, gbc);

        return panel;
    }
    
    
// Helper method to add labeled fields to panels
    private void addFormField(JPanel panel, String labelText, JTextField field, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }
    
    //Method to create dynamic fields for different job types i.e Part-time, Full-time
    private void updateDynamicFields() {
        dynamicFieldsPanel.removeAll();

        GridBagConstraints dynGbc = new GridBagConstraints();
        dynGbc.insets = new Insets(5, 5, 5, 5);
        dynGbc.anchor = GridBagConstraints.WEST;
        dynGbc.fill = GridBagConstraints.HORIZONTAL;

        String selectedType = (String) jobTypeCombo.getSelectedItem();

        if ("Part-Time".equals(selectedType)) {
            // Add part-time specific fields
            dynGbc.gridx = 0;
            dynGbc.gridy = 0;
            dynamicFieldsPanel.add(new JLabel("Working Hours:"), dynGbc);

            dynGbc.gridx = 1;
            dynamicFieldsPanel.add(workingHoursField, dynGbc);

            dynGbc.gridx = 0;
            dynGbc.gridy = 1;
            dynamicFieldsPanel.add(new JLabel("Wages Per Hour:"), dynGbc);

            dynGbc.gridx = 1;
            dynamicFieldsPanel.add(wagesPerHourField, dynGbc);

            dynGbc.gridx = 0;
            dynGbc.gridy = 2;
            dynamicFieldsPanel.add(new JLabel("Shifts:"), dynGbc);

            dynGbc.gridx = 1;
            dynamicFieldsPanel.add(shiftsField, dynGbc);

            dynGbc.gridx = 2;
            dynGbc.gridy = 0;
            dynGbc.gridheight = 3;
            dynamicFieldsPanel.add(terminateButton, dynGbc);
        } else if ("Full-Time".equals(selectedType)) {
            // Add full-time specific fields
            dynGbc.gridx = 0;
            dynGbc.gridy = 0;
            dynamicFieldsPanel.add(new JLabel("Salary:"), dynGbc);

            dynGbc.gridx = 1;
            dynamicFieldsPanel.add(salaryField, dynGbc);

            dynGbc.gridx = 0;
            dynGbc.gridy = 1;
            dynamicFieldsPanel.add(new JLabel("Weekly Fractional Hours:"), dynGbc);

            dynGbc.gridx = 1;
            dynamicFieldsPanel.add(weeklyHoursField, dynGbc);
        }

        dynamicFieldsPanel.revalidate();
        dynamicFieldsPanel.repaint();
    }
    //Method to add functionality to the buttons 
    private void setupButtonActions() {
        addFullTimeButton.addActionListener(e -> addFullTimeStaff());
        addPartTimeButton.addActionListener(e -> addPartTimeStaff());
        setSalaryButton.addActionListener(e -> setSalary());
        setShiftsButton.addActionListener(e -> setShifts());
        terminateButton.addActionListener(e -> terminateStaff());
        displayButton.addActionListener(e -> displayStaff());
        clearButton.addActionListener(e -> clearFields());
    }
    //Method to create view staff panel 
    private JPanel createViewStaffPanel(){


        // Create the title label (same style as your image)
        JLabel titleLabel = new JLabel("View Staff", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));


        // Create the display panel (matches your image exactly)
        JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));

        JLabel displayLabel = new JLabel("Display Number:");
        JButton displayButton = new JButton("Display");
        displayButton.addActionListener(e -> displayByIndex());

        displayPanel.add(displayLabel);
        displayPanel.add(displayField);
        displayPanel.add(displayButton);


        return displayPanel;
    }

    // Action methods

//Method to display staff member by the index of an arraylist 
    private void displayByIndex(){
        try {
            int displayNumber = Integer.parseInt(displayField.getText());
            if (displayNumber >= 0 && displayNumber < staffList.size()) {

                StaffHire staff = staffList.get(displayNumber);
                JOptionPane.showMessageDialog(this,staff.display(),"Staff Details",JOptionPane.PLAIN_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this,"Invalid display number.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Invalid input. Please enter a valid number.");
        }


    }



// Method to add Full-time staff member 
    private void addFullTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String designation = designationField.getText();
            String jobType = (String) jobTypeCombo.getSelectedItem();
            String staffName = staffNameField.getText();
            String joiningDate = joiningDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = statusCheckbox.isSelected();
            double salary = Double.parseDouble(salaryField.getText());
            int weeklyFractionalHours = Integer.parseInt(weeklyHoursField.getText());

            FullTimeStaffHire staff = new FullTimeStaffHire(
                    vacancyNumber,
                    designation,
                    jobType,
                    staffName,
                    joiningDate,
                    qualification,
                    appointedBy,
                    joined,
                    salary,
                    weeklyFractionalHours
            );

            staffList.add(staff);
            JOptionPane.showMessageDialog(this, "Full-time staff added successfully!");
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid input",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding staff: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Method to add part-time staff member 
    private void addPartTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String designation = designationField.getText();
            String jobType = (String) jobTypeCombo.getSelectedItem();
            String staffName = staffNameField.getText();
            String joiningDate = joiningDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = statusCheckbox.isSelected();
            int workingHour = Integer.parseInt(workingHoursField.getText());
            double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
            String shifts = shiftsField.getText();

            PartTimeStaffHire staff = new PartTimeStaffHire(vacancyNumber, designation, jobType, staffName, joiningDate,
                    qualification, appointedBy, joined, workingHour, wagesPerHour, shifts);



            staffList.add(staff);
            JOptionPane.showMessageDialog(this, "Part-time staff added successfully!");
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid input",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding staff: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Method to set shifts for fulltime staff member identified by vacancy number 

    private void setSalary() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            double salary = Double.parseDouble(salaryField.getText());

            for (StaffHire staff : staffList) {
                if (staff instanceof FullTimeStaffHire && staff.getVacancyNumber() == vacancyNumber) {
                    ((FullTimeStaffHire) staff).setSalary(salary);
                    JOptionPane.showMessageDialog(this,"Salary updated successfully!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this,"Staff not found.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Invalid input. Please check the fields.");
        }
    }


    //Method to set shifts for partTime staff member identified by vacancy number 
    private void setShifts() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String shifts = shiftsField.getText();

            for (StaffHire staff : staffList) {
                if (staff instanceof PartTimeStaffHire && staff.getVacancyNumber() == vacancyNumber) {
                    ((PartTimeStaffHire) staff).setShifts(shifts);
                    JOptionPane.showMessageDialog(this,"Shifts updated successfully!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this,"Staff not found.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,"Invalid input. Please check the fields.");
        }
    }
    
    //Terminates a part-time staff member identified by vacancy number
     private void terminateStaff() {
        try {
            // Get vacancy number from input field
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText().trim());

            // Search for the staff member
            for (int i = 0; i < staffList.size(); i++) {
                StaffHire staff = staffList.get(i);

                // Check if it's a part-time staff with matching vacancy number
                if (staff instanceof PartTimeStaffHire &&
                        staff.getVacancyNumber() == vacancyNumber) {

                    // Remove from ArrayList
                    staffList.remove(i);

                    // Show success message
                    JOptionPane.showMessageDialog(this,
                            "Part-time staff with vacancy #" + vacancyNumber + " has been terminated.",
                            "Termination Successful",
                            JOptionPane.PLAIN_MESSAGE);

                    // Clear the input field
                    vacancyNumberField.setText("");
                    return;
                }
            }

            // If not found
            JOptionPane.showMessageDialog(this,
                    "No part-time staff found with vacancy #" + vacancyNumber,
                    "Not Found",
                    JOptionPane.WARNING_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid vacancy number",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


//  Method to display all the staff members 
    private void displayStaff() {
        if (staffList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No staff records available");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Staff Records:\n\n");
        for (StaffHire staff : staffList) {
            sb.append(staff.display()).append("\n\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));

        JOptionPane.showMessageDialog(this, scrollPane, "Staff Records", JOptionPane.PLAIN_MESSAGE);
    }
    //Method to clear all the fields 

    private void clearFields() {
        vacancyNumberField.setText("");
        designationField.setText("");
        staffNameField.setText("");
        joiningDateField.setText("");
        qualificationField.setText("");
        appointedByField.setText("");
        statusCheckbox.setSelected(false);

        workingHoursField.setText("");
        wagesPerHourField.setText("");
        shiftsField.setText("");
        salaryField.setText("");
        weeklyHoursField.setText("");
    }
    //Method to change the fields according to selected Job Type 

    private class JobTypeChangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateDynamicFields();
        }
    }

//  Main method for running GUI 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RecruitmentSystemGUI system = new RecruitmentSystemGUI();
            system.setVisible(true);
        });
    }
}