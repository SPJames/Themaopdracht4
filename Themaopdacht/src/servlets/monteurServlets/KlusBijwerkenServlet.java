package servlets.monteurServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.klantenbinding.Auto;
import domein.klusbeheer.Klus;

public class KlusBijwerkenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * In deze servlet kan een klus bijgewerkt worden.
	 * Eerst wordt de klus opgehaalt.
	 * 
	 * Aan het eind wordt gecontroleert of alle velden zijn ingevuld. Zo niet dan wordt de monteur
	 * teruggestuurd naar deze pagina en wordt er een foutmelding weergegeven.
	 * 
	 * Als alle velden zijn ingevuld worden de nieuwe gegevens opgeslagen en wordt de monteur
	 * teruggestuurd naar de klussenlijst en wordt daar een melding weergegeven dat de wijzigingen
	 * doorgevoert zijn.
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext sc = req.getServletContext();
		
		String[] userinfo = new String[3];
		@SuppressWarnings("unchecked")
		ArrayList<Klus> Klussen = (ArrayList<Klus>) sc.getAttribute("alleKlussen");

		userinfo[0] = req.getParameter("klusid");// klusid voor foreign key
		userinfo[1] = req.getParameter("diensttype");
		userinfo[2] = req.getParameter("comments");
		Auto auto = null;

		Klus klus = null;
		for (Klus k : Klussen) {
			// klus invoer ophalen
			if (k.getKlusNummer() == Integer.parseInt(userinfo[0])) {
				klus = k;
			}
		}

		@SuppressWarnings("unchecked")
		ArrayList<Auto> autos = (ArrayList<Auto>) sc.getAttribute("alleAutos");
		for (Auto a : autos) {
			if (a.getKenteken().equals(req.getParameter("auto"))) {
				auto = a;
			}
		}

		RequestDispatcher rd = null;
		for (int i = 0; i < 3; i++) {
			// foutmelding
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				req.setAttribute("msgs", "Sommige velden waren leeg.");
				rd = req.getRequestDispatcher("klusaanpassen.jsp");
				break;
			} else {
				if (i == 1) {
					klus.setHetType(userinfo[1]);
				} else if (i == 2) {
					klus.setBeschrijving(userinfo[2]);
					req.setAttribute("msgs", "Klus succesvol aangepast.");
					rd = req.getRequestDispatcher("klussenlijst.jsp");
					auto.setInReparatie(true);
				}
			}
		}
		rd.forward(req, resp);
	}
}