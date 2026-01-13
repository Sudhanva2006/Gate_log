package gatelog.ui;

import gatelog.StudentExit;
import gatelog.StudentExitDAO;

import javax.swing.*;
import java.awt.*;

public class FacultyUI extends JFrame {

    private JTextField usnField;
    private JTextField nameField;
    private JTextField deptField;
    private JTextField yearField;
    private JTextArea reasonArea;

    public FacultyUI() {
        setTitle("Faculty Dashboard");
        setSize(450, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initUI();
        setVisible(true);
    }

    private void initUI() {

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Add Student Exit", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // USN
        gbc.gridy++;
        panel.add(new JLabel("USN:"), gbc);
        gbc.gridx = 1;
        usnField = new JTextField(15);
        panel.add(usnField, gbc);

        // Name
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Student Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField();
        panel.add(nameField, gbc);

        // Department
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Department:"), gbc);
        gbc.gridx = 1;
        deptField = new JTextField();
        panel.add(deptField, gbc);

        // Year
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Year:"), gbc);
        gbc.gridx = 1;
        yearField = new JTextField();
        panel.add(yearField, gbc);

        // Reason
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Reason:"), gbc);
        gbc.gridx = 1;
        reasonArea = new JTextArea(3, 15);
        panel.add(new JScrollPane(reasonArea), gbc);

        // Button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;

        JButton addBtn = new JButton("Add Student Exit");
        addBtn.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(addBtn, gbc);

        addBtn.addActionListener(e -> addStudentExit());

        add(panel);
    }

    private void addStudentExit() {

        try {
            String usn = usnField.getText().trim();
            String name = nameField.getText().trim();
            String dept = deptField.getText().trim();
            int year = Integer.parseInt(yearField.getText().trim());
            String reason = reasonArea.getText().trim();

            if (usn.isEmpty() || name.isEmpty() || dept.isEmpty() || reason.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "All fields are required",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            StudentExit exit = new StudentExit(
                    usn,
                    name,
                    dept,
                    year,
                    reason,
                    "Faculty"
            );

            boolean success = StudentExitDAO.insertExit(exit);

            if (success) {
                JOptionPane.showMessageDialog(this,
                        "Student Exit Added Successfully",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Failed to add exit",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Year must be a number",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        usnField.setText("");
        nameField.setText("");
        deptField.setText("");
        yearField.setText("");
        reasonArea.setText("");
    }
}
