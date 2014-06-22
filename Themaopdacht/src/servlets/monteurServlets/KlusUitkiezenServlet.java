package servlets.monteurServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.klusbeheer.Klus;
//import domein.klusbeheer.Weekplanning;
import domein.klusbeheer.Weekplanning;

/**
 * In deze servlet kunnen monteurs een klus uitkiezen om aan te werken.
 */
public class KlusUitkiezenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Er wordt gecontroleert of de klus al een werknemer heeft en of deze overeenkomt
	 * met de ingelogde monteur. 
	 * 
	 * Als de klus al een werknemer heeft en deze is niet de ingelogde monteur dan wordt de monteur
	 * teruggestuurd naar deze pagina en wordt er een foutmelding weergegeven.
	 * 
	 * Als de monteur nog geen werknemer heeft of de werknemer is de ingelogde monteur
	 * dan wordt  de ingelogde monteur aan de klus toegewezen en wordt de monteur doorgestuurd
	 * naar deze pagina en wordt een melding weergegeven dat het uitkiezen gelukt is.
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int klusid = Integer.parseInt(req.getParameter("id"));
		String werknemer = (String) req.getSession().getAttribute("Username");
		Weekplanning planning = (Weekplanning)req.getServletContext().getAttribute("planning");
		boolean succes = false;
		@SuppressWarnings("unchecked")
		// klussen ophalen
		ArrayList<Klus> klussen = (ArrayList<Klus>) req.getServletContext().getAttribute("alleKlussen");
		for (Klus k : klussen) {
			if ((k.getKlusNummer() == klusid) && !(werknemer.equals(k.getWerknemer()))) {
				k.setWerknemer(werknemer);
				planning.addKlus(k);
				succes = true;
				break;
			}
		}
		RequestDispatcher rd = null;
		if (succes) {
			req.setAttribute("msgs", "Klus succesvol uitgekozen!");
			rd = req.getRequestDispatcher("klussenlijst.jsp");
		} else{ 
			req.setAttribute("error", "Deze klus is al aan iemand toegewezen!");
			rd = req.getRequestDispatcher("klussenlijst.jsp");
		}
		rd.forward(req, resp);
	}
}