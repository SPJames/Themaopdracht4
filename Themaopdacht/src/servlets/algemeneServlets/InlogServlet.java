package servlets.algemeneServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domein.klantenbinding.Klant;
import domein.klusbeheer.Monteur;

public class InlogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("pwd");
		boolean error = false;
		boolean done = false;
		ServletContext sc = req.getServletContext();
		HttpSession ses = req.getSession();
		
		// servlet context imports
		@SuppressWarnings("unchecked")
		ArrayList<Klant> Users = (ArrayList<Klant>) sc.getAttribute("alleUsers");
		@SuppressWarnings("unchecked")
		ArrayList<Monteur> monteurs = (ArrayList<Monteur>) sc.getAttribute("alleMonteurs");

		// checken of er iets is ingevoerd
		if (password == null || username == null) {
			error = true;
		} else if (password.equals("") || username.equals("")) {
			error = true;
		}

		// foutmelding geven
		RequestDispatcher rd = null;
		if (Users.size() == 0) {
			req.setAttribute("msgs", "Er zijn nog geen accounts in het systeem");
			rd = req.getRequestDispatcher("inloggen.jsp");
		}
		if (error) {
			req.setAttribute("msgs", "Username/password was leeg");
			rd = req.getRequestDispatcher("inloggen.jsp");
		} else { 
			
			// inloggen als admin
			if (username.equals("Admin") && password.equals("Admin")) {
				ses.setAttribute("Access", "Admin");
				ses.setAttribute("Username", "Admin");
				done = true;
			} else {
				// foutmelding monteur
				req.setAttribute("msgs", "Dit is geen geldige login");
				rd = req.getRequestDispatcher("inloggen.jsp");
			}
			
			// inloggen als monteur
			if (!(done)) {
				for (Monteur m : monteurs) {
					if (m.getNaam().equals(username) && m.getPassword().equals(password)) {
						ses.setAttribute("Access", "Monteur");
						ses.setAttribute("Username", m.getNaam());
						ses.setAttribute("ID", m.getId());
						done = true;
						break;
					} else {
						// foutmelding monteur
						req.setAttribute("msgs", "Dit is geen geldige login");
						rd = req.getRequestDispatcher("inloggen.jsp");
					}
				}
			}
			
			// inloggen als klant
			if (!(done)) { 
				for (Klant k : Users) {
					if (k.getUsername().equals(username) && k.getPassword().equals(password)) {
						ses.setAttribute("Access", "Klant");
						ses.setAttribute("Username", k.getUsername());
						ses.setAttribute("ID", k.getId());
						done = true;
						break;
					} else {
						// foutmelding klant
						req.setAttribute("msgs", "Dit is geen geldige login");
						rd = req.getRequestDispatcher("inloggen.jsp");
					}
				}
			}
		}
		if (done) {
			resp.sendRedirect("index.jsp");
		} else {
			rd.forward(req, resp);
		}
	}
}
