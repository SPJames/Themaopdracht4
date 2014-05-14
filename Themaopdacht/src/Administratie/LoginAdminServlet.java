package Administratie;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("pwd");
		boolean error = false;

		if (username.equals("") || username.equals(null)) {
			error = true;
		}
		if (password.equals("") || password.equals(null)) {
			error = true;
		}
		RequestDispatcher rd = null;
		if (error) {
			req.setAttribute("msgs", "Input was empty");
			rd = req.getRequestDispatcher("login.jsp");
		} else {
			if((username.equals("Admin")) && (password.equals("Admin"))){
				Cookie c = new Cookie("C_Username", "Admin");
				c.setMaxAge(3600 * 24);
				Cookie c2 = new Cookie("C_Password", "Admin");
				c2.setMaxAge(3600 * 24);
				Cookie c3 = new Cookie("C_ID", "1");
				c3.setMaxAge(3600 * 24);
				Cookie c4 = new Cookie("C_Usertype", "Admin");
				c4.setMaxAge(3600 * 24);
				resp.addCookie(c);
				resp.addCookie(c2);
				resp.addCookie(c3);
				resp.addCookie(c4);
				rd = req.getRequestDispatcher("index.jsp");
			}

		}
		rd.forward(req, resp);
	}

}
