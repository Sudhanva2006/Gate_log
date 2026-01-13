package gatelog;

import java.sql.*;

public class StudentExitDAO {

    public static boolean insertExit(StudentExit exit) {

        String sql = """
            INSERT INTO student_exit
            (usn, student_name, department, year, reason, approved_by)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, exit.getUsn());
            ps.setString(2, exit.getStudentName());
            ps.setString(3, exit.getDepartment());
            ps.setInt(4, exit.getYear());
            ps.setString(5, exit.getReason());
            ps.setString(6, exit.getApprovedBy());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static StudentExit getExitByUsn(String usn) {

        String sql = "SELECT * FROM student_exit WHERE usn = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usn);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new StudentExit(
                        rs.getString("usn"),
                        rs.getString("student_name"),
                        rs.getString("department"),
                        rs.getInt("year"),
                        rs.getString("reason"),
                        rs.getString("approved_by")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
