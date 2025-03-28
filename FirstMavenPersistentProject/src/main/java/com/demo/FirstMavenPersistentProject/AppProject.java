package com.demo.FirstMavenPersistentProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class AppProject {


    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        Scanner scan = new Scanner(System.in);

        // Correct driver class name and URL
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3360/ubibank?user=root&password=1234";
        String sql = "INSERT INTO  mybank VALUES (?, ?, ?, ?)";

        try {
            // Load MySQL driver
            Class.forName(driver);

            // Establish connection
            con = DriverManager.getConnection(url);

            // Prepare SQL statement
            ps = con.prepareStatement(sql);

            // Get the number of records to insert
            System.out.println("HOW MANY RECORDS DO YOU WANT TO INSERT?");
            int nor = scan.nextInt();

            // Loop to get input and add queries to batch
            for (int i = 1; i <= nor; i++) {
                System.out.println("Enter ID, Name, Email, Balance for customer " + i + ":");
                int id = scan.nextInt();
                String cname = scan.next();
                String email = scan.next();
                int balance = scan.nextInt();

                ps.setInt(1, id);
                ps.setString(2, cname);
                ps.setString(3, email);
                ps.setInt(4, balance);

                // Add query to batch
                ps.addBatch();
            }

            // Execute batch
            int[] results = ps.executeBatch();
            System.out.println("Records inserted:");
            for (int res : results) {
                System.out.println(res + " record(s) inserted.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
                scan.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

