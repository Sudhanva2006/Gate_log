package gatelog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentExitDAO {

    public static boolean insertExit(StudentExit exit) {

        String sql = "INSERT INTO student_exit VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, exit.getUsn());
            ps.setString(2, exit.getStudentName());
            ps.setString(3, exit.getDepartment());
            ps.setInt(4, exit.getYear());
            ps.setString(5, exit.getReason());
            ps.setString(6, "Faculty");

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Failed to insert student exit.");
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
            StudentExit exit = new StudentExit(
                    rs.getString("usn"),
                    rs.getString("student_name"),
                    rs.getString("department"),
                    rs.getInt("year"),
                    rs.getString("reason")
            );
            exit.approveExit(rs.getString("approved_by"));
            return exit;
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
}

}
