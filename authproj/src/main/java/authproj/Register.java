package authproj;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class Register extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) {
		try {
			//Collect the data from client
			String username = req.getParameter("un");
			String password = req.getParameter("up");
			String email = req.getParameter("ue");
			String phone = req.getParameter("uph");


		
			//store the data in DB
			AuthModel rm = new AuthModel();
			boolean result = rm.persist(username, password, email, phone);
			if (result == true) {
				res.sendRedirect("/authproj/login.html");
			}
			else {
				res.sendRedirect("/authproj/regfail.html");
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
