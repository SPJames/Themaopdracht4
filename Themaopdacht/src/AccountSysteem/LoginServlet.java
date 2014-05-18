package AccountSysteem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import klantenbinding.Klant;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("pwd");
		boolean error = false;
		// lijst met users 'importeren'
		@SuppressWarnings("unchecked")
		ArrayList<Klant> Users = (ArrayList<Klant>) req.getServletContext()
				.getAttribute("allUsers");

		if (username.equals("") || username.equals(null)) {
			error = true;
		}
		if (password.equals("") || password.equals(null)) {
			error = true;
		}
		RequestDispatcher rd = null;
		if (Users.size() == 0) {
			req.setAttribute("msgs", "No accounts registered");
			rd = req.getRequestDispatcher("login.jsp");
		}
		if (error) {
			req.setAttribute("msgs", "Input was empty");
			rd = req.getRequestDispatcher("login.jsp");
		} else {
			for (Klant k : Users) {
				if (k.getUsername().equals(username)
						&& k.getPassword().equals(password)) {
					Cookie c = new Cookie("C_Username", username);
					c.setMaxAge(3600 * 24 * 365);
					resp.addCookie(c);
					Cookie c2 = new Cookie("C_Usertype", "Klant");
					c2.setMaxAge(3600 * 24 * 365);
					resp.addCookie(c2);
					rd = req.getRequestDispatcher("index.jsp");
					break;
				} else {
					req.setAttribute("msgs", "Unknown username/password combo");
					rd = req.getRequestDispatcher("login.jsp");
				}

			}

		}
		rd.forward(req, resp);
	}
}
