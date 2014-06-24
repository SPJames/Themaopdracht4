package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.financien.Factuur;
import domein.klusbeheer.Klus;

/**
 * In deze klasse wordt de facuur van een klus gemaakt.
 */

public class KlusFacturerenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * De klus wordt opgehaald. Er wordt een factuur bij aangemaakt en deze
	 * wordt aan de lijst facturen toegevoegd. Hierna wordt de klus verwijdert
	 * uit de lijst klussen.
	 * 
	 * De gebruiker wordt doorgestuurd naar klussenlijstaf en er wordt een
	 * melding weergegeven.
	 */
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;

		int klusid = Integer.parseInt(req.getParameter("klusid"));
		ArrayList<Factuur> facturen = (ArrayList<Factuur>) req.getServletContext().getAttribute("alleFacturen");
		ArrayList<Klus> klussen = (ArrayList<Klus>) req.getServletContext().getAttribute("alleKlussen");

		Klus klus = null;
		for (Klus k : klussen) {
			if (k.getKlusNummer() == klusid) { //huidige klus zoeken
				int id = ((HashMap<String, Integer>) req.getServletContext().getAttribute("ids")).get("factuurID");
				Factuur factuur = new Factuur(k, id);
				((HashMap<String, Integer>) req.getServletContext().getAttribute("ids")).put("factuurID", id+1);
				req.setAttribute("id", factuur.getFactuurNummer());
				facturen.add(factuur);
				klus = k;
			}
		}
		klussen.remove(klus); //klus wordt uit de lijst klussen gehaald

		req.setAttribute("msgs", "Klus succesvol gefactureerd!");
		
		Logger.getLogger("atd").info("Klus <"+klusid+"> succesvol gefactureerd");
		rd = req.getRequestDispatcher("factuurberekenen.jsp");
		rd.forward(req, resp);
	}
}