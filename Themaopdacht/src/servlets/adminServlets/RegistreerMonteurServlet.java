package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.klantenbinding.Klant;
import domein.klusbeheer.Monteur;

/**
 * In deze servlet kan de admin een monteur account toevoegen.
 */
public class RegistreerMonteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Er wordt een gebruikersnaam en een wachtwoord opgegeven. Er wordt
	 * gecontroleerd of de gegevens ingevoerd zijn. Zoniet dan wordt de admin
	 * teruggestuurd naar deze pagina en wordt er een foutmelding weergegeven.
	 * 
	 * Als alles ingevuld is wordt gecontroleert of de wachtworden overeenkomen
	 * met elkaar. Zo niet dan wordt de admin teruggestuurd naar deze pagina en
	 * wordt er een foutmelding weergegeven.
	 * 
	 * Als er geen foutmeldingen zijn wordt de monteur opgeslagen, aan de lijst
	 * van monteurs toegevoegd, wordt de admin doorgestuurd naar de index en
	 * wordt een melding weergegeven dat het registreren gelukt is.
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

		String[] userinfo = new String[3];
		boolean error = false;
		boolean error2 = false;
		ArrayList<Monteur> Monteurs = (ArrayList<Monteur>) req.getServletContext().getAttribute("alleMonteurs");

		userinfo[0] = req.getParameter("Realname");
		userinfo[1] = req.getParameter("pwd");
		userinfo[2] = req.getParameter("pwd2");

		for (int i = 0; i < 3; i++) {
			// controlerern of alle velden zijn ingevuld
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				error = true;
			}
		}
		// controleren of de ingevoerde wachtwoorden hetzelfde zijn
		if (!userinfo[1].equals(userinfo[2])) {
			error = true;
		}
		
		//controlleer of naam al bestaat
		ArrayList<Klant> klanten = (ArrayList<Klant>) req.getServletContext().getAttribute("alleUsers");
		ArrayList<Monteur> monteurs = (ArrayList<Monteur>) req.getServletContext().getAttribute("alleMonteurs");
		for(Klant k : klanten) {
			if(k.getUsername().equals(userinfo[0])) {
				error2 = true;
			}
		}
		for(Monteur m : monteurs) {
			if(m.getNaam().equals(userinfo[0])) {
				error2 = true;
			}
		}
		
		RequestDispatcher rd = null;
		if (error) {
			// foutmelding weergeven
			req.setAttribute("error","Invoer was leeg of wachtwoord is niet gelijk");
			rd = req.getRequestDispatcher("registreermonteur.jsp");
		} else if (error2) {
			//foutmelding 2
			req.setAttribute("error","Deze naam is al in gebruik");
			rd = req.getRequestDispatcher("registreermonteur.jsp");
		} else {
			// monteur account opslaan
			int id = ((HashMap<String, Integer>) req.getServletContext().getAttribute("ids")).get("monteurID");
			Monteur m = new Monteur(userinfo[0], userinfo[1], id);
			((HashMap<String, Integer>) req.getServletContext().getAttribute("ids")).put("monteurID", id+1);
			
			Monteurs.add(m);
			req.setAttribute("msgs", "De nieuwe monteur " + userinfo[0] + " is succesvol opgeslagen!");
			rd = req.getRequestDispatcher("../index.jsp");
		}
		rd.forward(req, resp);
	}
}