package servlets.klantServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.klantenbinding.Auto;
import domein.klantenbinding.Klant;

public class RegistreerAutoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String merk = req.getParameter("merk");
		String kt = req.getParameter("kenteken");
		String id = req.getParameter("klantid");
		boolean error = false;
		boolean error2 = false;

		// checken of alles is ingevuld
		if (merk.equals("") || merk.equals(null)) {
			error = true;
		}
		if (kt.equals("") || kt.equals(null)) {
			error = true;
		}
		RequestDispatcher rd = null;
		if (error) { // foutmelding
			req.setAttribute("msgs", "Een of meerdere velden waren leeg.");
			rd = req.getRequestDispatcher("autotoevoegen.jsp");
		} else {
			Auto a = new Auto(kt, merk, id);
			@SuppressWarnings("unchecked")
			ArrayList<Auto> Autos = (ArrayList<Auto>) req.getServletContext().getAttribute("alleAutos");
			for (Auto auto : Autos) {
				if (auto.getKenteken().equals(kt)) { // foutmelding als auto al bestaat
					req.setAttribute("msgs", "Deze auto bestaat al.");
					rd = req.getRequestDispatcher("autotoevoegen.jsp");
					error2 = true;
					break;
				}
			}
			if (!error2) { // als er geen fout meer is kan de auto toegevoegd worden
				@SuppressWarnings("unchecked")
				ArrayList<Klant> klanten = (ArrayList<Klant>) req.getServletContext().getAttribute("alleUsers");
				for (Klant k : klanten) {
					if (k.getUsername().equals(req.getSession().getAttribute("Username"))) {
						k.voegAutoToe(a);
					}
				}
				Autos.add(a);
				req.setAttribute("msgs", "Auto succesvol toegevoegd!");
				rd = req.getRequestDispatcher("autolijst.jsp");
			}
		}
		rd.forward(req, resp);
	}
}