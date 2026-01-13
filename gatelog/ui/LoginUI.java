package ui;

import gatelog.Admin;
import gatelog.Faculty;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {

    public LoginUI() {
        setTitle("Gate Log - Login");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(4, 2, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JComboBox<String> role =
                new JComboBox<>(new String[]{"Admin", "Faculty"});

        JButton login = new JButton("Login");

        p.add(new JLabel("Username"));
        p.add(user);
        p.add(new JLabel("Password"));
        p.add(pass);
        p.add(new JLabel("Role"));
        p.add(role);
        p.add(new JLabel());
        p.add(login);

        login.addActionListener(e -> {

            String u = user.getText();
            String pw = new String(pass.getPassword());
            String r = role.getSelectedItem().toString();

            if (r.equals("Admin")) {
                Admin admin = new Admin("admin", "1234");
                if (admin.login(u, pw)) {
                    dispose();
                    new AdminUI();   // ✅ FIX HERE
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Admin Login");
                }
            } else {
                Faculty faculty = new Faculty("faculty", "abcd");
                if (faculty.login(u, pw)) {
                    dispose();
                    new FacultyUI(); // ✅ FIX HERE
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Faculty Login");
                }
            }
        });

        add(p);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginUI();
    }
}
