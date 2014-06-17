package servlets.monteurServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.klusbeheer.Klus;

public class KlusAfrondenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * In deze servlet kan een klus worden afgerond. De klusstatus wordt op
	 * afgerond gezet en er verschijnt een bericht dat de klus succesvol is
	 * afgerond. De monteur wordt doorgestuurd naar de klussenlijst.
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		@SuppressWarnings("unchecked")
		ArrayList<Klus> klussen = (ArrayList<Klus>) req.getServletContext()
				.getAttribute("alleKlussen");
		int id = Integer.parseInt(req.getParameter("id"));
		for (Klus k : klussen) {
			if (id == k.getKlusNummer()) {
				k.setKlusafgerond(true);
				req.setAttribute("msgs", "klus " + id + " succesvol afgerond");

				//hier zit nog een fout!!
//				KlusAfgerondEmail m = new KlusAfgerondEmail(
//						(String) req.getParameter("email"),
//						(String) req.getParameter("realname"));
			}
		}

		req.getRequestDispatcher("klussenlijst.jsp").forward(req, resp);

	}

}
