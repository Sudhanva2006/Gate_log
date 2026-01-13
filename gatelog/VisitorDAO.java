package gatelog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VisitorDAO {

    // Add visitor to DB
    public static boolean addVisitor(Visitor v) {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO visitor_log " +
                         "(name, phone, purpose, in_time, out_time) " +
                         "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, v.getName());
            ps.setString(2, v.getPhone());
            ps.setString(3, v.getPurpose());
            ps.setString(4, v.getInTime());
            ps.setString(5, v.getOutTime());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fetch all visitors (FOR UI TABLE)
    public static ResultSet getAllVisitors() {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM visitor_log";
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
