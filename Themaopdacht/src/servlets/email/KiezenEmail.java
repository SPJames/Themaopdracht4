package servlets.email;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.email.AutoControlenEmail;
import domein.email.KlantHerinneringEmail;
import domein.email.NietBetaaldEmail;
import domein.klantenbinding.Klant;
/**
 * In deze klasse kan een email gekozen worden die naar een te kiezen klant gestuurd gaat worden
 */
public class KiezenEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Eerst wordt aangegeven naar welke klant de mail gestuurd moet worden.
	 * Hierna wordt aangegeven welk type email er naar deze klant gestuurd gaat worden.
	 * De gebruiker wordt teruggestuurd naar klantoverzicht.jsp en er wordt een melding weergegeven
	 */
	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		@SuppressWarnings("unchecked")
		ArrayList<Klant> klanten = (ArrayList<Klant>) req.getServletContext().getAttribute("alleUsers");

		int id = Integer.parseInt(req.getParameter("id")); //klant id

		String type = req.getParameter("sort"); //email soort

		Klant klant = null;
		for (Klant k : klanten) {
			if (id == k.getId()) { //de klant opzoeken die de email moet ontvangen
				klant = k;
			}
		}

		RequestDispatcher rd = null;

		if (type.equals("herinnering")) {
			KlantHerinneringEmail kh = new KlantHerinneringEmail(klant.getEmail(), klant.getNaam());
			req.setAttribute("msgs", "Herinnerings e-mail verstuurd");
		} else if (type.equals("betaald")) {
			NietBetaaldEmail b = new NietBetaaldEmail(klant.getEmail(),klant.getNaam());
			req.setAttribute("msgs", "Niet betaald e-mail verstuurd");
		} else {
			AutoControlenEmail a = new AutoControlenEmail(klant.getEmail(),klant.getNaam());
			req.setAttribute("msgs", "Auto controlen e-mail verstuurd");
		}
		
		rd = req.getRequestDispatcher("/admin/klantoverzicht.jsp");
		rd.forward(req, resp);
	}
}