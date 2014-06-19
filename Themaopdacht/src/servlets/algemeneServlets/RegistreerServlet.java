package servlets.algemeneServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.email.RegisterEmail;
import domein.klantenbinding.Klant;
//import Database.Database;

public class RegistreerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Deze servlet wordt gebruikt om een nieuwe klant te registreren.
	 * Door de user moeten een aantal vakken worden ingevuld.
	 * 
	 * Er wordt eerst gecontroleert of alle vakken ingevuld zijn, en of de ingevoerde wachtwoorden en 
	 * emailadressen (beide moesten 2 maal ingevoerd worden) met elkaar overeen komen.
	 * Het email adres wordt ook op syntax gecontroleerd (@ en .com)
	 * 
	 * Als één of meerdere van bovenstaande controles een foutmelding opgeven dan wordt de gebruiker
	 * teruggestuurd naar deze pagina en wordt er een error bericht weergegeven.
	 * 
	 *  Als er geen foutmeldingen gegeven zijn wordt aan de hand van de ingevoerde gegevens een nieuwe
	 *  klant geregistreerd en toegevoegd aan de lijst met klantaccounts.
	 *  Hierna wordt de gebruiker doorgestuurd naar het inlogscherm.
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] userinfo = new String[8];
		boolean error = false;

		userinfo[0] = req.getParameter("username");
		userinfo[1] = req.getParameter("realname");
		userinfo[2] = req.getParameter("pwd");
		userinfo[3] = req.getParameter("pwd2");
		userinfo[4] = req.getParameter("email");
		userinfo[5] = req.getParameter("email2");
		userinfo[6] = req.getParameter("adres");
		userinfo[7] = req.getParameter("postcode");

		// checken of alle 8 de velden zijn ingevuld
		for (int i = 0; i < 8; i++) {
			if (userinfo[i] == null) {
				error = true;
			} else if (userinfo[i].equals("")){
				error = true;
			}
		}

		// checken of password en email overeen komen
		if (!(userinfo[2].equals(userinfo[3])) && !(userinfo[4].equals(userinfo[5]))) {
			error = true;
		}
		
		// foutmelding
		if (error) {	//misschien netter om kwamen niet overeen neer te zetten ipv matchte?
			req.setAttribute("error", "Enkele velden waren leeg en/of het wachtwoord/email matchte niet.");
			req.getRequestDispatcher("registreren.jsp").forward(req, resp);
		} else {
			// klant opslaan
			Klant k = new Klant(userinfo[1], userinfo[6], userinfo[7], userinfo[4], userinfo[0], userinfo[2]);

			@SuppressWarnings("unchecked")
			ArrayList<Klant> Users = (ArrayList<Klant>) req.getServletContext().getAttribute("alleUsers");
			Users.add(k);

			resp.sendRedirect("inloggen.jsp");
			@SuppressWarnings("unused")
			RegisterEmail m = new RegisterEmail((String) req.getParameter("email"),
					(String) req.getParameter("username"),
					(String) req.getParameter("realname"),
					(String) req.getParameter("pwd"));
		}
	}
}
