package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.klusbeheer.Monteur;

public class RegistreerMonteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String[] userinfo = new String[3];
		boolean error = false;
		@SuppressWarnings("unchecked")
		ArrayList<Monteur> Monteurs = (ArrayList<Monteur>) req
				.getServletContext().getAttribute("alleMonteurs");

		userinfo[0] = req.getParameter("Realname");
		userinfo[1] = req.getParameter("pwd");
		userinfo[2] = req.getParameter("pwd2");

		for (int i = 0; i < 3; i++) {
			// checken of er wat is ingevuld
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				error = true;
			}
		}
		// checken of password gelijk is
		if (!userinfo[1].equals(userinfo[2])) {
			error = true;
		}
		RequestDispatcher rd = null;

		if (error) {
			// foutmelding
			req.setAttribute("msgs", "Invoer was leeg of de email/het wachtwoord matchte niet");
			rd = req.getRequestDispatcher("registermonteur.jsp");

		} else {
			// monteur opslaan
			Monteur m = new Monteur(userinfo[0], userinfo[1]);
			// m.schrijfWeg(userinfo);
			Monteurs.add(m);
			req.setAttribute("msgs", "De nieuwe monteur "+userinfo[0]+" is succesvol opgeslagen!");
			rd = req.getRequestDispatcher("../index.jsp");

		}
		rd.forward(req, resp);

	}

}
