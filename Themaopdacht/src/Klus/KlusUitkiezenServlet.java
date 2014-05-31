package Klus;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Klusbeheer.Klus;

public class KlusUitkiezenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// ergens onbekende fout. System outs worden niet bereikt.
		// probeer try catch! om achter het probleem te komen

		int klusid = Integer.parseInt(req.getParameter("id"));
		String werknemer = (String) req.getSession().getAttribute("Username");
		boolean succes = false;
		@SuppressWarnings("unchecked")
		// klussen ophalen
		ArrayList<Klus> klussen = (ArrayList<Klus>) req.getServletContext()
				.getAttribute("allKlussen");
		for (Klus k : klussen) {
			if (k.getKlusNummer() == klusid
					&& !werknemer.equals(k.getWerknemer())) {
				k.setWerknemer(werknemer);
				succes = true;
				break;
			}
		}
		RequestDispatcher rd = null;
		if (succes) {
			req.setAttribute("msgs", "Klus succesvol uitgekozen!");
			rd = req.getRequestDispatcher("monteur/klussenlijst.jsp");
			System.out.println("probleem");
		} else { // foutmelding
			req.setAttribute("msgs", "Deze klus is al aan iemand toegewezen!");
			rd = req.getRequestDispatcher("monteur/klussenlijst.jsp");
			System.out.println("probleem 2");
		}
		rd.forward(req, resp);
	}
}