package authproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthModel {
Connection con;
PreparedStatement pstmt;
String dpath="com.mysql.cj.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/august?user=root&password=1234";
String sql="insert into user(username, password, email, phone) values (?,?,?,?)";
PreparedStatement pstmt1;
String loginsql="select * from user where username=? and password=?";
ResultSet rs;

public AuthModel() {
	try {
	Class.forName(dpath);
	con=DriverManager.getConnection(url);
}
catch (Exception e) {
			e.printStackTrace();
}
}
public boolean persist (String username, String password, String email, String phone) {
try {
pstmt=con.prepareStatement(sql);
pstmt.setString(1, username);
pstmt.setString(2, password);
pstmt.setString(3, email);
pstmt.setString(4, phone);
int nora=pstmt.executeUpdate();
if(nora== 1) {
return true;
}
}
catch (Exception e) {
e.printStackTrace();
}
return false;
}

public boolean validateUser(String username, String password) {
	try {
		pstmt1 = con.prepareStatement(loginsql);
		pstmt1.setString(1, username);
		pstmt.setString(2, password);
		rs = pstmt1.executeQuery();
			if(rs.next()) {
				return true;
			}
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	return false;
}
}