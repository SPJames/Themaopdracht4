package AccountSysteem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Klusbeheer.Monteur;
import klantenbinding.Klant;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("static-access")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("pwd");
		boolean error = false;
		boolean done = false;
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
			req.setAttribute("msgs", "Er zijn nog geen accounts in het systeem");
			rd = req.getRequestDispatcher("login.jsp");
		}
		if (error) {
			req.setAttribute("msgs", "Username/password was leeg");
			rd = req.getRequestDispatcher("login.jsp");
		} else {
			if (username.equals("Admin") && password.equals("Admin")) {
				req.getSession().setAttribute("Access", "Admin");
				req.getSession().setAttribute("Username", "Admin");
				rd = req.getRequestDispatcher("index.jsp");
				done = true;
			}
			@SuppressWarnings("unchecked")
			ArrayList<Monteur> monteurs = (ArrayList<Monteur>) req
					.getServletContext().getAttribute("allMonteurs");
			if (!(done)) {
				for (Monteur m : monteurs) {
					if (m.getNaam().equals(username)
							&& m.getPassword().equals(password)) {
						req.getSession().setAttribute("Access","Monteur");
						req.getSession().setAttribute("Username",m.getNaam());
						req.getSession().setAttribute("ID", m.getId());
						done = true;
						rd = req.getRequestDispatcher("index.jsp");
						

						break;
					} else {
						req.setAttribute("msgs", "Dit is geen geldige login");
						rd = req.getRequestDispatcher("login.jsp");
					}
				}
			}
			if (!(done)) {
				for (Klant k : Users) {
					if (k.getUsername().equals(username)
							&& k.getPassword().equals(password)) {
						req.getSession().setAttribute("Access", "Klant");
						req.getSession().setAttribute("Username",
								k.getUsername());
						req.getSession().setAttribute("ID", k.getId());
						done = true;
						rd = req.getRequestDispatcher("index.jsp");
						break;
					} else {
						req.setAttribute("msgs", "Dit is geen geldige login");
						rd = req.getRequestDispatcher("login.jsp");
					}

				}
			}

		}
		rd.forward(req, resp);
	}
}
