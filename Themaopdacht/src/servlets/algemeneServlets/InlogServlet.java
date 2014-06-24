package servlets.algemeneServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domein.klantenbinding.Klant;
import domein.klusbeheer.Monteur;

/**
 * Via deze servlet kan er ingelogd worden
 */
public class InlogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Er wordt gecontroleert of de vakken username en pwd zijn ingevuld
	 * 
	 * Als username en/of wachtwoord niet zijn ingevuld wordt de gebruiker
	 * teruggestuurd naar de inlogpagina en wordt er een error bericht
	 * weergegeven.
	 * 
	 * Als deze ingevuld zijn wordt gekeken of er wordt ingelogd als Admin,
	 * monteur of klant Dit wordt gedaan door voor admin de naam en pw te
	 * vergelijken (er is maar één admin), en voor monteur/klant wordt gekeken
	 * of de naam met het wachtwoord overeen komen met de geregistreerde
	 * monteurs/klanten.
	 * 
	 * Als de naam en het wachtwoord ergens mee overeenkomen dan wordt er
	 * ingelogd en wordt de gebruiker doorgestuurt naar de index.jsp met een
	 * menu dat er anders uitziet afhankelijk van welke soort gebruiker er is
	 * ingelogd. Dit wordt bepaalt afhankelijk van het Access attribuut. Verder
	 * worden de username en waar nodig het ID opgeslagen als attributen.
	 * 
	 * Als de naam en het wachtwoord niet is gevonden wordt de gebruiker
	 * teruggestuurt naar de inlogpagina en wordt er een error bericht
	 * weergegeven.
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("pwd");
		boolean error = false;
		boolean done = false;
		ServletContext sc = req.getServletContext();
		HttpSession ses = req.getSession();

		// servlet context imports
		@SuppressWarnings("unchecked")
		ArrayList<Klant> Users = (ArrayList<Klant>) sc
				.getAttribute("alleUsers");
		@SuppressWarnings("unchecked")
		ArrayList<Monteur> monteurs = (ArrayList<Monteur>) sc
				.getAttribute("alleMonteurs");

		// checken of er lege velden zijn
		if (password == null || username == null) {
			error = true;
		} else if (password.equals("") || username.equals("")) {
			error = true;
		}

		// foutmelding geven
		RequestDispatcher rd = null;
		if (Users.size() == 0) {
			req.setAttribute("error", "Er zijn nog geen accounts aanwezig in het systeem");
			rd = req.getRequestDispatcher("inloggen.jsp");
		}
		if (error) {
			req.setAttribute("error", "Username of Wachtwoord was leeg");
			rd = req.getRequestDispatcher("inloggen.jsp");
		} else {
			// inloggen als admin
			if (username.equals("Admin") && password.equals("Admin")) {
				ses.setAttribute("Access", "Admin");
				ses.setAttribute("Username", "Admin");
				done = true;
			} else {
				// foutmelding admin
				req.setAttribute("error", "Dit is geen geldige log in");
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
						req.setAttribute("error", "Dit is geen geldige log in");
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
						req.setAttribute("error", "Dit is geen geldige log in");
						rd = req.getRequestDispatcher("inloggen.jsp");
					}
				}
			}
		}
		if (done) { 
			Logger.getLogger("atd").info("Gebruiker <" + username + "> is ingelogd!");
			resp.sendRedirect("index.jsp");
		} else {
			Logger.getLogger("atd").warning("Inloggen mislukt voor gebruiker <" + username + ">!");
			rd.forward(req, resp);
		}
	}
}