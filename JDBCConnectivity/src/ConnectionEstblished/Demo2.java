package ConnectionEstblished;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Corrected Scanner initialization
        Connection con = null;
        PreparedStatement ps = null;

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");

            // Step 2: Establish a connection
            String url = "jdbc:mysql://localhost:3306/kondnest";
            String user = "root";
            String password = "1234";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Established");

            // Step 3: Create a SQL query
            String sql = "INSERT INTO student (id, name, age, marks, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);

            // Step 4: Input data from the user
            System.out.println("Enter id, name, age, marks, email, phone:");
            int id = scan.nextInt();
            String name = scan.next();
            int age = scan.nextInt();
            int marks = scan.nextInt();
            String email = scan.next();
            long phone = scan.nextLong(); // Use long for phone numbers

            // Step 5: Set the parameters
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setInt(4, marks);
            ps.setString(5, email);
            ps.setLong(6, phone);

            // Step 6: Execute the query
            int rowsInserted = ps.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
                scan.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
