package ConnectionEstblished;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import com.mysql.cj.xdevapi.Statement;

public class Demo {
	public static void main(String[] args) {
		try {
			
			//Step -1
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			// Step-2
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kondnest","root","1234");
		    System.out.println("Connection Established");
		    
		    //step3
		    Statement stmt = con.createStatement();
		    System.out.println("Statement created.....");
		    
		    //Step4
		    String sql ="select * from student";
			ResultSet rs = stmt.executeQuery(sql );
		    System.out.println("Query Eecuted...");
		    System.out.println("=========================================================-=");

		    System.out.println("ID|   Name      | Age    | Marks   | Email            | Phone ");
		    
		    //steps 5
		    while(rs.next()) {
		    	System.out.println(rs.getInt(1) + " | " +rs.getString(2)+ " |  "+rs.getInt(3)+"   | "+rs.getInt(4)+"  | "+rs.getString(5)+"  | "+rs.getInt(6));
		    }
		    
		    
		    //step 6
		    con.close();
		    stmt.close();
		    rs.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
