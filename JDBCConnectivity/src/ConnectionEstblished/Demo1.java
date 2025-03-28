//package ConnectionEstblished;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.Scanner;
//
//public class Demo1 {
//private static final String DriverManager = null;
//
//public static void main(String[] args) {
//	Connection con = null;
//	PreparedStatement ps = null;
//	ResultSet rs = null;
//	String sql = "select * from student where id=?";
//	String dpath ="com.mysql.cj.jdbc.Driver";
//	String url ="jdbc:mysql://localhost:3306/kondnest";
//	String user ="root";
//	String password ="1234";
//	Scanner scan = new Scanner(System.in);
//	try {
//		Class.forName(dpath);
//		con=DriverManager.getConnection(url, user, password);
//		ps = con.prepareStatement(sql);
//		System.out.println("Enter Id");
//		int id = scan.nextInt();
//		ps.setInt(1, id);
//		rs = ps.executeQuery();
//		if(rs.next()) {
//			System.out.println(rs  );
//		}
//	}
//	
//}
//}




package ConnectionEstblished;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Scanner scan = new Scanner(System.in);

        String sql = "SELECT * FROM student WHERE id = ?";
        String dpath = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/kondnest";
        String user = "root";
        String password = "1234";

        try {
            // Step 1: Load the JDBC driver
            Class.forName(dpath);
            System.out.println("Driver Loaded");

            // Step 2: Establish a connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Established");

            // Step 3: Prepare the SQL query
            ps = con.prepareStatement(sql);

            // Step 4: Get the ID from the user
            System.out.println("Enter ID:");
            int id = scan.nextInt();
            ps.setInt(1, id);

            // Step 5: Execute the query
            rs = ps.executeQuery();

            // Step 6: Process the result set
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Marks: " + rs.getInt("marks"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone: " + rs.getLong("phone"));
            } else {
                System.out.println("No record found for ID: " + id);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
                scan.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
