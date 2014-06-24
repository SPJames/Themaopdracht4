package servlets.algemeneServlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.email.RegisterEmail;
import domein.klantenbinding.Klant;
import domein.klusbeheer.Monteur;

/**
 * Deze servlet wordt gebruikt om een nieuwe klant te registreren.
 */
public class RegistreerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] userinfo = new String[8];
		boolean error = false;
		boolean error2 = false;
		boolean error3 = false;
		
		

		userinfo[0] = req.getParameter("username");
		userinfo[1] = req.getParameter("realname");
		userinfo[2] = req.getParameter("pwd");
		userinfo[3] = req.getParameter("pwd2");
		userinfo[4] = req.getParameter("email");
		userinfo[5] = req.getParameter("email2");
		userinfo[6] = req.getParameter("adres");
		userinfo[7] = req.getParameter("postcode");

		// controleren of alle 8 de velden zijn ingevuld
		for (int i = 0; i < 8; i++) {
			if (userinfo[i] == null) {
				error = true;
			} else if (userinfo[i].equals("")){
				error = true;
			}
		}
		RequestDispatcher rd = null;
		// controleren of de beide wachtwoorden en beide emailadressen overeen komen
		
		ArrayList<Klant> klanten = (ArrayList<Klant>) req.getServletContext().getAttribute("alleUsers");
		ArrayList<Monteur> monteurs = (ArrayList<Monteur>) req.getServletContext().getAttribute("alleMonteurs");
		for(Klant k : klanten) {
			if(k.getUsername().equals(userinfo[0])) {
				error2 = true;
			}
			if(k.getEmail().equals(userinfo[4])) {
				error3 = true;
			}
		}
		for(Monteur m : monteurs) {
			if(m.getNaam().equals(userinfo[0])) {
				error2 = true;
			}
		}
		if (error2) {
			req.setAttribute("error", "Deze gebruikersnaam is al bezet");
			rd = req.getRequestDispatcher("registreren.jsp");
		} else if (error3) {
			req.setAttribute("error", "Dit email adres is al bezet");
			rd = req.getRequestDispatcher("registreren.jsp");
		} else {
			if (userinfo[2].equals(userinfo[3]) && userinfo[4].equals(userinfo[5]) && !error) {
				
			// klant opslaan
			int id = ((HashMap<String, Integer>) req.getServletContext().getAttribute("ids")).get("userID");
			Klant k = new Klant(userinfo[1], userinfo[6], userinfo[7], userinfo[4], userinfo[0], userinfo[2], id);
			((HashMap<String, Integer>) req.getServletContext().getAttribute("ids")).put("userID", id+1);

			ArrayList<Klant> Users = (ArrayList<Klant>) req.getServletContext().getAttribute("alleUsers");
			Users.add(k);
			req.setAttribute("msgs", "U bent succesvol geregistreerd.");
			Logger.getLogger("atd").info("<"+k.getNaam()+"> met het IP '"+req.getRemoteAddr()+"' heeft zich succesvol geregistreerd");
			rd = req.getRequestDispatcher("inloggen.jsp");
			@SuppressWarnings("unused") //de registratie email wordt gestuurd
			RegisterEmail m = new RegisterEmail((String) req.getParameter("email"),
					(String) req.getParameter("username"),
					(String) req.getParameter("realname"),
					(String) req.getParameter("pwd"));
			
			} else {
			req.setAttribute("error", "Enkele velden waren leeg en/of het wachtwoord/email kwamen niet overeen.");
			rd = req.getRequestDispatcher("registreren.jsp");
			}
		}
		rd.forward(req, resp);
	}
}