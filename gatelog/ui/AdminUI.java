package ui;

import gatelog.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class AdminUI extends JFrame {

    public AdminUI() {
        setTitle("Admin Dashboard");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Add Visitor", addVisitorPanel());
        tabs.add("View Visitors", viewVisitorPanel());
        tabs.add("Verify Student Exit", verifyExitPanel());

        add(tabs);
        setVisible(true);
    }

    private JPanel addVisitorPanel() {
        JPanel p = new JPanel(new GridLayout(5,2,10,10));
        p.setBorder(BorderFactory.createEmptyBorder(30,50,30,50));

        JTextField name = new JTextField();
        JTextField phone = new JTextField();
        JTextField purpose = new JTextField();
        JTextField time = new JTextField();

        JButton add = new JButton("Add Visitor");

        p.add(new JLabel("Name")); p.add(name);
        p.add(new JLabel("Phone")); p.add(phone);
        p.add(new JLabel("Purpose")); p.add(purpose);
        p.add(new JLabel("In Time")); p.add(time);
        p.add(new JLabel()); p.add(add);

        add.addActionListener(e -> {
            Visitor v = new Visitor(
                    name.getText(),
                    phone.getText(),
                    purpose.getText(),
                    time.getText()
            );

            if (VisitorDAO.addVisitor(v))
                JOptionPane.showMessageDialog(this, "Visitor Added");
            else
                JOptionPane.showMessageDialog(this, "Failed");
        });

        return p;
    }

    private JPanel viewVisitorPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] cols = {"ID","Name","Phone","Purpose","In Time","Out Time"};
        DefaultTableModel model = new DefaultTableModel(cols,0);
        JTable table = new JTable(model);

        JButton load = new JButton("Load Visitors");

        load.addActionListener(e -> {
            model.setRowCount(0);
            try {
                ResultSet rs = VisitorDAO.getAllVisitors();
                while(rs.next()) {
                    model.addRow(new Object[]{
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getString("purpose"),
                            rs.getString("in_time"),
                            rs.getString("out_time")
                    });
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(load, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel verifyExitPanel() {
        JPanel p = new JPanel(new GridLayout(3,2,10,10));
        p.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

        JTextField usn = new JTextField();
        JTextArea result = new JTextArea();
        result.setEditable(false);

        JButton check = new JButton("Verify");

        p.add(new JLabel("USN")); p.add(usn);
        p.add(new JLabel()); p.add(check);
        p.add(new JLabel("Details")); p.add(new JScrollPane(result));

        check.addActionListener(e -> {
            StudentExit exit = StudentExitDAO.getExitByUsn(usn.getText());

            if(exit == null) {
                result.setText("No Exit Found");
            } else {
                result.setText(
                        "USN: " + exit.getUsn() +
                        "\nName: " + exit.getName() +
                        "\nDepartment: " + exit.getDepartment() +
                        "\nYear: " + exit.getYear() +
                        "\nReason: " + exit.getReason()
                );
            }
        });

        return p;
    }
}
