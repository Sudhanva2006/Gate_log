package gatelog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitorDAO {

    // INSERT visitor entry
    public static boolean addVisitor(Visitor v) {

        String sql = "INSERT INTO visitor_log (name, phone, purpose, in_time, out_time) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, v.getName());
            ps.setString(2, v.getPhone());
            ps.setString(3, v.getPurpose());
            ps.setString(4, v.getInTime());
            ps.setString(5, v.getOutTime());

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Failed to add visitor.");
            e.printStackTrace();
            return false;
        }
    }

    // FETCH all visitors
    public static void viewVisitors() {

        String sql = "SELECT * FROM visitor_log";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\nID | Name | Phone | Purpose | In-Time | Out-Time");
            System.out.println("------------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("phone") + " | " +
                        rs.getString("purpose") + " | " +
                        rs.getString("in_time") + " | " +
                        rs.getString("out_time")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

}
