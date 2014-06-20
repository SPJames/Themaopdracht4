package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;

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
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;

		int klusid = Integer.parseInt(req.getParameter("klusid"));
		@SuppressWarnings("unchecked")
		ArrayList<Factuur> facturen = (ArrayList<Factuur>) req
				.getServletContext().getAttribute("alleFacturen");
		@SuppressWarnings("unchecked")
		ArrayList<Klus> klussen = (ArrayList<Klus>) req.getServletContext()
				.getAttribute("alleKlussen");

		Klus klus = null;
		for (Klus k : klussen) {
			if (k.getKlusNummer() == klusid) {
				Factuur factuur = new Factuur(k);
				facturen.add(factuur);
				klus = k;
			}
		}
		klussen.remove(klus);

		//req.setAttribute("msgs", "Klus succesvol gefactureerd!");
		rd = req.getRequestDispatcher("factuur.jsp");
		rd.forward(req, resp);
	}
}