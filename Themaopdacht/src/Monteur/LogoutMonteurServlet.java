package Monteur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutMonteurServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		for (Cookie c : req.getCookies()) { 
	 		if (c.getName().equals("C_Username")) { 
	 		 	c.setMaxAge(0);
	 		 	resp.addCookie(c);
	 		} 
	 		if(c.getName().equals("C_Password")){
	 			c.setMaxAge(0);
	 			resp.addCookie(c);
	 		}
	 		if(c.getName().equals("C_ID")){
	 			c.setMaxAge(0);
	 			resp.addCookie(c);
	 		}
	 		if(c.getName().equals("C_Usertype")){
	 			c.setMaxAge(0);
	 			resp.addCookie(c);
	 		}
	 	} 
		resp.sendRedirect("index.jsp");
	}
	
}
