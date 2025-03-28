package authproj;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res ) {
		try {
			// collect UI Data
			String username = req.getParameter("un");
			String password = req.getParameter("up");
			// Check wether username and password is 
			AuthModel authModel = new AuthModel();
			boolean result = authModel.validateUser(username, password);
		if(result) {
			res.sendRedirect("/authproj/dashboard.html");
		} else {
		    res.sendRedirect("/authproj/loginfail.html");
	
		}
	}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
