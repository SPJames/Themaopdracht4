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

public class KiezenEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		@SuppressWarnings("unchecked")
		ArrayList<Klant> klanten = (ArrayList<Klant>) req.getServletContext()
				.getAttribute("alleUsers");

		int id = Integer.parseInt(req.getParameter("id"));

		String type = req.getParameter("sort");

		Klant klant = null;
		for (Klant k : klanten) {
			if (id == k.getId()) {
				klant = k;
			}
		}
		System.out.println(type);

		RequestDispatcher rd = null;

		if (type.equals("herinnering")) {
			KlantHerinneringEmail kh = new KlantHerinneringEmail(
					klant.getEmail(), klant.getNaam());
			req.setAttribute("msgs", "Herinnerings e-mail verstuurd");
		} else if (type.equals("betaald")) {
			NietBetaaldEmail b = new NietBetaaldEmail(klant.getEmail(),
					klant.getNaam());
			req.setAttribute("msgs", "Niet betaald e-mail verstuurd");
		} else {
			AutoControlenEmail a = new AutoControlenEmail(klant.getEmail(),
					klant.getNaam());
			req.setAttribute("msgs", "Auto controlen e-mail verstuurd");
		}
		
		rd = req.getRequestDispatcher("/admin/klantoverzicht.jsp");
		rd.forward(req, resp);
	}
}
